package com.shop.fashionShop.service;

import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.model.ProductImage;
import com.shop.fashionShop.repository.ProductDetailRepository;
import com.shop.fashionShop.repository.ProductImageRepository;
import com.shop.fashionShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface ProductDetailService {
    public ProductDetail save(ProductDetail productDetail, MultipartFile [] files) throws IOException;
}
