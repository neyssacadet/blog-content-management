/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.controller;

import com.example.blogcontentmanagement.models.Account;
import com.example.blogcontentmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 18437
 */
@Controller
public class RegisterController {
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }
    
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        accountService.save(account);
        
        return "redirect:/";
        
    }
}
