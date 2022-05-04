package com.shop.fashionShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductController {
    @GetMapping("/product")
    public String index(){
        return "user/product/product";
    }

    @GetMapping("/product-detail")
    public String detail(){
        return "user/product/product-detail";
    }
}
