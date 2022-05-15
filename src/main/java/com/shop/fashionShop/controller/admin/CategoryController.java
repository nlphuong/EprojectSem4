package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.model.Category;
import com.shop.fashionShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public String allCategory(Model model) {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("list",categories);
        return "admin/category/all_category";
    }

    @GetMapping("addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/add_category";
    }

    @PostMapping("saveCategory")
    public String save(@ModelAttribute("category") Category category, Model model){
        categoryService.saveCategory(category);
        return "redirect:/admin/category";
    }

    @GetMapping("deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }
}
