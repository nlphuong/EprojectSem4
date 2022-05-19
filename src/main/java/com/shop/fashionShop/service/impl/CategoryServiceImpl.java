package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Category;
import com.shop.fashionShop.repository.CategoryRepository;
import com.shop.fashionShop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    public static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
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
