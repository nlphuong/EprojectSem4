package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.Inventory;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.model.ProductImage;
import com.shop.fashionShop.repository.InventoryRepository;
import com.shop.fashionShop.repository.ProductDetailRepository;
import com.shop.fashionShop.repository.ProductImageRepository;
import com.shop.fashionShop.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public ProductDetail save(ProductDetail productDetail, MultipartFile[] files) throws IOException {
        Inventory inventory;
        ProductDetail existDetail=productDetailRepository.findProductDetailByColorAndSize(productDetail.getProduct(),productDetail.getColor(),productDetail.getSize());
        if (existDetail!=null){
            existDetail.setQuantity(existDetail.getQuantity()+productDetail.getQuantity());
            productDetailRepository.save(existDetail);
            inventory=new Inventory(productDetail.getQuantity(),productDetail.getSell_price(),new Date(),existDetail);
            inventoryRepository.save(inventory);
            return existDetail;
        }
        else {
            productDetail.setCreateAt(new Date());
            productDetail.setStatus(Status.AVAILABLE);
            ProductDetail newProductDetail=productDetailRepository.save(productDetail);
            inventory=new Inventory(productDetail.getQuantity(),productDetail.getSell_price(),new Date(),newProductDetail);
            inventoryRepository.save(inventory);
            //save Image
            for (MultipartFile file :files){
                ProductImage productImage=new ProductImage();
                productImage.setName(newProductDetail.getProduct().getProductCode()+"_"+newProductDetail.getColor());
                productImage.setImage(file.getBytes());
                productImage.setProductDetail(newProductDetail);
                productImageRepository.save(productImage);
            }
            return newProductDetail;
        }
    }

    @Override
    public ProductDetail findOne(int id) {
        return productDetailRepository.findById(id).get();
    }

    @Override
    public ProductDetail update(ProductDetail productDetail, MultipartFile[] files) throws IOException {
        if (productDetail.getQuantity()==0){
            productDetail.setStatus(Status.OUT_STOCK);
        }
       ProductDetail productDetailUpdate=  productDetailRepository.save(productDetail);
        int length=files.length;

        if (!files[0].isEmpty()) {

            Set<ProductImage> productImageSet = productDetailUpdate.getProductImageSet();
            productImageRepository.deleteAll(productImageSet);
        }
        //Add new image
        ProductImage productImage;
        for (MultipartFile file :files){
            productImage=new ProductImage();
            productImage.setName(productDetailUpdate.getProduct().getProductCode()+"_"+productDetailUpdate.getColor());
            productImage.setImage(file.getBytes());
            productImage.setProductDetail(productDetailUpdate);
            productImageRepository.save(productImage);
        }

       return productDetailUpdate;
    }
}
