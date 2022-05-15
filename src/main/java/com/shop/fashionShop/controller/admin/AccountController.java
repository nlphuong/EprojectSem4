package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.model.Account;
import com.shop.fashionShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/listAccount")
    public String account(Model model) {
        model.addAttribute("list", accountService.getAllAccount());
        return "admin/account/all_customer";
    }

    @GetMapping("/addAccount")
    public String addAccount(Model model) {
        model.addAttribute("account", new Account());
        return "admin/account/add_customer";
    }

    @PostMapping("saveAccount")
    public String save(@ModelAttribute("account") Account account){
        accountService.saveAccount(account);
        return "redirect:/admin/category";
    }

    @GetMapping("deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        accountService.deleteAccount(id);
        return "redirect:/admin/category";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "admin/account/profile";
    }

}
