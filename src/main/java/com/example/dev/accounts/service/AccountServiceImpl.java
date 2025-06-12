package com.example.dev.accounts.service;

import com.example.dev.accounts.dto.AccountDto;
import com.example.dev.accounts.model.Account;
import com.example.dev.accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String createAccount(AccountDto account) {
        Optional<Account> existingAccount = accountRepository.findByEmail((account.getEmail()));
        if(existingAccount.isPresent()){

        }

        return accountRepository.save(model)
    }

    @Override
    public AccountDto getAccountById(String accountId) {
        // Implementation for retrieving an account by ID
        return new AccountDto();
    }

    @Override
    public AccountDto updateAccount(String accountId, AccountDto account) {
        // Implementation for updating an account
        return new AccountDto();
    }

    @Override
    public void deleteAccount(String accountId) {
        // Implementation for deleting an account
    }
}
