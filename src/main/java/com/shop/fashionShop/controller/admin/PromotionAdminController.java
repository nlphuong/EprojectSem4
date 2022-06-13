package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.model.Promotion;
import com.shop.fashionShop.service.ProductService;
import com.shop.fashionShop.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/promotion")
public class PromotionAdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PromotionService promotionService;
    @GetMapping("/index")
    public String list(Model model){
        model.addAttribute("promotions",promotionService.findAll());
        return "admin/promotion/promotion_list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("promotion",new Promotion());
        return "admin/promotion/add_promotion";
    }
    @PostMapping("/add")
    public String postPromotion(Model model){
        model.addAttribute("promotion",new Promotion());
        return "admin/promotion/add_promotion";
    }
}
