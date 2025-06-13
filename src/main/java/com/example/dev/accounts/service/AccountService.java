package com.example.dev.accounts.service;

import com.example.dev.accounts.dto.AccountDto;

import java.util.Optional;

public interface AccountService {

    Optional<String> createAccount(AccountDto account);

    Optional<AccountDto> getAccountById(String accountId);

    Optional<AccountDto> updateAccount(AccountDto account);
}
