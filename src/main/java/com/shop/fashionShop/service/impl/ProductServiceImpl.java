package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Category;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.Product_;
import com.shop.fashionShop.model.viewModel.FilterProduct;
import com.shop.fashionShop.model.viewModel.ProductCondition;
import com.shop.fashionShop.repository.BrandRepository;
import com.shop.fashionShop.repository.CategoryRepository;
import com.shop.fashionShop.repository.ProductRepository;
import com.shop.fashionShop.repository.specification.ProductSpecification;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    public final   static int SORT_DATE_CREATE_DESC=1;
    public final static int SORT_PRICE_ASC=2;
    public final static int SORT_PRICE_DESC=3;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product findByProductCode(String code) {
        return productRepository.getProductByCode(code);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Set<String> listProductCode() {
        Set<String> list= new HashSet<>();
        productRepository.findAll().forEach(product -> {
            list.add(product.getProductCode());
        });
        return list;
    }

    @Override
    public List<Product> findAllWithFilter(FilterProduct filterProduct) {
        //tim kiem theo nhieu dieu kien
        Specification condition=null;

        if (!filterProduct.getProductCode().isEmpty()){
            condition=ProductSpecification.hasProductCode(filterProduct.getProductCode());
        }
        if (!filterProduct.getProductName().isEmpty()){
            condition=condition==null?ProductSpecification.hasProductName(filterProduct.getProductName()):condition.and(ProductSpecification.hasProductName(filterProduct.getProductName()));
        }
        if (Objects.nonNull(filterProduct.getCategory())){
            condition=condition==null?ProductSpecification.hasCategory(filterProduct.getCategory()):condition.and(ProductSpecification.hasCategory(filterProduct.getCategory()));
        }
        if (Objects.nonNull(filterProduct.getBrand())){
            condition=condition==null?ProductSpecification.hasBrand(filterProduct.getBrand()):condition.and(ProductSpecification.hasBrand(filterProduct.getBrand()));
        }
        List<Product> productList;
        if (condition==null){
            productList=productRepository.findAll();
        }
        else {
           productList   =productRepository.findAll(Specification.where(condition));
        }
        return productList;
    }

    @Override
    public List<Product> findByCategoryName(String catName) {
        return productRepository.getProductByCategoryName(catName);
    }

    @Override
    public Page<Product> findProductByMultiConditions(ProductCondition  productCondition) {

        List<Product> productList;
        Specification condition=null;
        Pageable pageable=PageRequest.of(productCondition.getPage(),9,Sort.by("create_at").descending());
        Category category=categoryRepository.findByName(productCondition.getCatName());
        List<Brand> brand=brandRepository.getBrandByListName(productCondition.getBrandName());

        if (productCondition.getCatName()!=null){
            condition= condition==null?ProductSpecification.hasCategory(category):condition.and(ProductSpecification.hasCategory(category));
        }
        if (productCondition.getBrandName()!=null){
            condition=condition==null?ProductSpecification.hasListBrand(brand):condition.and(ProductSpecification.hasListBrand(brand));
        }
        if (productCondition.getPrice_from()!=null&&productCondition.getPrice_to()!=null){
            condition=condition==null?ProductSpecification.hasPrice(productCondition.getPrice_from(), productCondition.getPrice_to(),productCondition.getOrderSort()):condition.and(ProductSpecification.hasPrice(productCondition.getPrice_from(), productCondition.getPrice_to(), productCondition.getOrderSort()));
        }
        if(Objects.nonNull(productCondition.getColor())){
            condition=condition==null?ProductSpecification.hasColor(productCondition.getColor()):condition.and(ProductSpecification.hasColor(productCondition.getColor()));
        }
        if (Objects.nonNull(productCondition.getGender())){
            condition=condition==null?ProductSpecification.hasGender(productCondition.getGender()):condition.and(ProductSpecification.hasGender(productCondition.getGender()));
        }
        if (condition==null){
            productList=productRepository.findAll();
            return new PageImpl<Product>(productList,pageable,productList.size());
        }
        productList=productRepository.findAll(Specification.where(condition.and(ProductSpecification.distinct())));
        return new PageImpl<Product>(productList, pageable, productList.size());
    }

}
