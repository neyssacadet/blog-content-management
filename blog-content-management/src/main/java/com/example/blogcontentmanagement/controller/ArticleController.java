/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.controller;

import com.example.blogcontentmanagement.models.Account;
import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.service.AccountService;
import com.example.blogcontentmanagement.service.ArticleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 18437
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/articles/{articleId}")
    public String getArticle(@PathVariable Long articleId, Model model) {
      // find post by id
      Optional<Article> optionalArticle = articleService.getById(articleId);
      // if post exists add it to the model
      if (optionalArticle.isPresent()){
          Article article = optionalArticle.get();
          model.addAttribute("article", article);
          return "article";
                  
      } else{
          return "404";
      }
    }
    @GetMapping("/articles/new")
    public String createNewArticle(Model model){
       Optional<Account> optionalAccount = accountService.findByEmail("user.user@domain.com");
       if (optionalAccount.isPresent()){
           Article article = new Article();
           article.setAccount(optionalAccount.get());
           model.addAttribute("article", article);
           return "article_new";
           
    } else {
           return "404";
       }
}
    @PostMapping("/articles/new")
    public String saveNewArticle(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:/articles/" + article.getArticleId();
    }
    
}
