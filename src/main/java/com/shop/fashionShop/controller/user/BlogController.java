package com.shop.fashionShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogController {
    @GetMapping("/blog")
    public String index(){
        return "user/blog/blog";
    }
    @GetMapping("/blog-detail")
    public String detail(){
        return "user/blog/blog-details";
    }
}
