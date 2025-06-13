package com.example.dev.accounts.service;

import com.example.dev.accounts.dto.AccountDto;
import com.example.dev.accounts.model.Account;
import com.example.dev.accounts.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<String> createAccount(AccountDto account) {
        Optional<Account> existingAccount = accountRepository.findByEmail((account.getEmail()));
        if (existingAccount.isPresent()) {
            return Optional.empty();
        }
        Account savedAccount = accountRepository.save(modelMapper.map(account, Account.class));
        return Optional.of(savedAccount.getId());
    }

    @Override
    public Optional<AccountDto> getAccountById(String accountId) {
        return accountRepository.findById(accountId).map(account -> modelMapper.map(account, AccountDto.class));
    }

    @Override
    public Optional<AccountDto> updateAccount(AccountDto account) {
        Optional<Account> existingAccount = accountRepository.findById(account.getId());
        if (existingAccount.isPresent()) {
            Account newAccount = modelMapper.map(account, Account.class);
            accountRepository.save(newAccount);
        }
        return Optional.empty();
    }

}
