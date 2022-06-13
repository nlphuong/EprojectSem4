package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.ProductImage;
import com.shop.fashionShop.repository.ProductImageRepository;
import com.shop.fashionShop.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    @Override
    public ProductImage findOne(int id) {
        return productImageRepository.findById(id).get();
    }
}
