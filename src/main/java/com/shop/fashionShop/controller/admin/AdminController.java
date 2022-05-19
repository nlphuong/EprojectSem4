package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/home")
    public String home() {
        return "admin/index";
    }

    //Manager Account

//    @GetMapping("/listAccount")
//    public String account() {
//        return "admin/account/all_customer";
//    }
//
//    @GetMapping("/addAccount")
//    public String addAccount() {
//        return "admin/account/add_customer";
//    }
//
//    @GetMapping("/profile")
//    public String profile() {
//        return "admin/account/profile";
//    }




//Manager Brand

    @GetMapping("/brand")
    public String allBrand() {
        return "admin/brand/all_brand";
    }

    @GetMapping("/addBrand")
    public String addBrand() {
        return "admin/brand/add_brand";
    }

//Manager Category

//    @GetMapping("/category")
//    public String allCategory() {
//        return "admin/category/all_category";
//    }
//
//    @GetMapping("/addCategory")
//    public String addCategory() {
//        return "admin/category/add_category";
//    }

//Manager Product

    @GetMapping("/product")
    public String allProduct() {
        return "admin/product/all_product";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "admin/product/add_product";
    }

    //Manager MemberCard

    @GetMapping("/memberCard")
    public String allMemberCard() {
        return "admin/memberCard/all_memberCard";
    }

    @GetMapping("/addMemberCard")
    public String addMemberCard() {
        return "admin/memberCard/add_memberCard";
    }


    //Manager Order

    @GetMapping("/order")
    public String allOrder() {
        return "admin/order/all_order";
    }

    @GetMapping("/addOrder")
    public String addOrder() {
        return "admin/order/add_order";
    }


    //Manager Order

    @GetMapping("/invoice")
    public String allInvoice() {
        return "admin/invoice/all_invoice";
    }

    @GetMapping("/addInvoice")
    public String addInvoice() {
        return "admin/invoice/add_invoice";
    }



    //Manager Rating and Comment

    @GetMapping("/comment")    public String allComment() {
        return "admin/comment/all_comment";
    }

    @GetMapping("/addComment")
    public String addComment() {
        return "admin/comment/add_comment";
    }

    //Manager Shipping

    @GetMapping("/shipping")
    public String allShipping() {
        return "admin/shipping/all_shipping";
    }



}
