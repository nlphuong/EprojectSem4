package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.repository.BrandRepository;
import com.shop.fashionShop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findOne(int id) {
        return brandRepository.findById(id).get();
    }
}
