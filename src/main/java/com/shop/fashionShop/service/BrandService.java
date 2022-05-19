package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    public List<Brand> findAll();
    public Brand findOne(int id);
}
