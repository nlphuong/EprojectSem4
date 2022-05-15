package com.shop.fashionShop.service;

import com.shop.fashionShop.model.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    List<Account> getAllAccount();
    Account getAccountById(int id);
    void deleteAccount(int id);
}
