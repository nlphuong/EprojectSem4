package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.repository.ProductRepository;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

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
}
