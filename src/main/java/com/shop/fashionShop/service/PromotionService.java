package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PromotionService {
    List<Promotion> findAll();
    Promotion findById(int id);
}
