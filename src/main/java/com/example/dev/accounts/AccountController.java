package com.example.dev.accounts;


import com.example.dev.accounts.dto.AccountDto;
import com.example.dev.accounts.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    ResponseEntity<String> createAccount(@RequestBody AccountDto account) {
        Optional<String> id = accountService.createAccount(account);
        if (id.isPresent()) {
            URI location = URI.create("/accounts/" + id.get());
            return ResponseEntity.created(location).body(id.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
