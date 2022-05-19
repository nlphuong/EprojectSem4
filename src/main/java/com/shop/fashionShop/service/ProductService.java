package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public List<Product> findAll();
    public Product findOne(int id);
    public Product findByProductCode(String code);
    public Product save(Product product);
    public Set<String> listProductCode();
}
