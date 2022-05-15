package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Category;
import com.shop.fashionShop.repository.CategoryRepository;
import com.shop.fashionShop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        LOG.info("Insert category: "+category.toString());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        LOG.info("Delete category: "+id);
        categoryRepository.deleteById(id);
    }

}
