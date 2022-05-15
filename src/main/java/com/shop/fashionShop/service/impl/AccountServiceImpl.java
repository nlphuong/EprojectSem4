package com.shop.fashionShop.service.impl;

import com.shop.fashionShop.model.Account;
import com.shop.fashionShop.repository.AccountRepository;
import com.shop.fashionShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }
}
