package com.shop.fashionShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaymentController {
    @GetMapping("/shopping-cart")
    public String cart(){
        return "user/payment/shopping-cart";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "user/payment/check-out";
    }

}
