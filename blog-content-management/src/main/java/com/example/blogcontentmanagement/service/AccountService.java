/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.service;

import com.example.blogcontentmanagement.models.Account;
import com.example.blogcontentmanagement.repositories.AccountRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author 18437
 */
@Service
public class AccountService {
    
   @Autowired
   private PasswordEncoder passwordEncoder; 
    
   @Autowired
   private AccountRepository accountRepository;
   
   public Account save(Account account) {
       account.setPassword(passwordEncoder.encode(account.getPassword()));
       return accountRepository.save(account);
   }
   
   public Optional<Account> findByEmail(String email){
       return accountRepository.findOneByEmail(email);
   }
   
}
