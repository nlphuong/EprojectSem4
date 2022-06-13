package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Category;

import java.util.List;

public interface CategoryService {
    void saveCategory(Category category);
    void deleteCategory(int id);
    List<Category> getAllCategory();
    Category getCategoryByName(String name);
}
