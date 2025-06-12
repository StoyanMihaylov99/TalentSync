package com.example.dev.accounts.service;

import com.example.dev.accounts.dto.AccountDto;

public interface AccountService {

    String createAccount(AccountDto account);

    AccountDto getAccountById(String accountId);

    AccountDto updateAccount(String accountId, AccountDto account);

    void deleteAccount(String accountId);
}
