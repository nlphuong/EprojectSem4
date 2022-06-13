package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.viewModel.FilterProduct;
import com.shop.fashionShop.model.viewModel.ProductCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public List<Product> findAll();
    public Product findOne(int id);
    public Product findByProductCode(String code);
    public Product save(Product product);
    public Set<String> listProductCode();
    public List<Product> findAllWithFilter(FilterProduct filterProduct);
    public List<Product> findByCategoryName(String catName);
    public Page<Product> findProductByMultiConditions(ProductCondition productCondition);
}
