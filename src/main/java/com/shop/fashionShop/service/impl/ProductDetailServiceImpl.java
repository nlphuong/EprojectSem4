package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.model.ProductImage;
import com.shop.fashionShop.repository.ProductDetailRepository;
import com.shop.fashionShop.repository.ProductImageRepository;
import com.shop.fashionShop.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductDetail save(ProductDetail productDetail, MultipartFile[] files) throws IOException {
        productDetail.setCreateAt(new Date());
        productDetail.setStatus(Status.AVAILABLE);
        ProductDetail newProductDetail=productDetailRepository.save(productDetail);

        //save Image
        ProductImage productImage;
        for (MultipartFile file :files){
            productImage=new ProductImage();
            productImage.setName(newProductDetail.getProduct().getProductCode()+"_"+newProductDetail.getColor());
            productImage.setImage(file.getBytes());
            productImage.setProductDetail(newProductDetail);
            productImageRepository.save(productImage);
        }
        return newProductDetail;
    }
}
