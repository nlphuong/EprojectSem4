package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Promotion;
import com.shop.fashionShop.repository.PromotionRepository;
import com.shop.fashionShop.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion findById(int id) {
        return promotionRepository.findById(id).get();
    }
}
