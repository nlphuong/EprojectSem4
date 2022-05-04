package com.shop.fashionShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactController {
    @GetMapping("/contact")
    public String index(){
        return "user/contact/contact";
    }
    @GetMapping("/faq")
    public String faq(){
        return "user/contact/faq";
    }
}
