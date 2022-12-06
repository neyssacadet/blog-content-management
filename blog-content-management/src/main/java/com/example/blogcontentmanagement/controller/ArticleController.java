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
import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
      // find article by id
      Optional<Article> optionalArticle = articleService.getById(id);
      // if article exists add it to the model
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
        return "redirect:/articles/" + article.getId();
    }
    
    
    @GetMapping("/articles/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getArticleForEdit(@PathVariable Long id, Model model) {

        // find article by id
        Optional<Article> optionalArticle = articleService.getById(id);
        // if article exist put it in model
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            model.addAttribute("article", article);
            return "article_edit";
        } else {
            return "404";
        }
    }
    
    @PostMapping("/articles/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updateArticle(@PathVariable Long id, Article article, Model model) {
      
        Optional<Article> optionalArticle = articleService.getById(id);
        if (optionalArticle.isPresent()) {
            Article existingArticle = optionalArticle.get();
            existingArticle.setTitle(article.getTitle());
            existingArticle.setContent(article.getContent());
            
            articleService.save(existingArticle);
        } 
        
        return "redirect:/articles/" + article.getId();
    }
    
    

    @GetMapping("/articles/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteArticle(@PathVariable Long id) {

        // find article by id
        Optional<Article> optionalArticle = articleService.getById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();

            articleService.delete(article);
            return "redirect:/";
        } else {
            return "404";
        }
    }
    
}
