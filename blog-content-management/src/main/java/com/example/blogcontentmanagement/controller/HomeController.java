/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.controller;

import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author 18437
 */
@Controller
public class HomeController {
    
    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/")
    public String home(Model model){
        List<Article> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "home";
    }
    
}
