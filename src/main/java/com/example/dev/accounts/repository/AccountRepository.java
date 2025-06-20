package com.example.dev.accounts.repository;

import com.example.dev.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findByEmail(String email);
}
