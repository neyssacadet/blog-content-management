package com.example.blogcontentmanagement.config;

import com.example.blogcontentmanagement.models.Account;
import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.service.AccountService;
import com.example.blogcontentmanagement.service.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class SeedData implements CommandLineRunner {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private AccountService accountService;
    
    @Override
    public void run(String... args) throws Exception {
        List<Article> articles = articleService.getAll();
        
        if(articles.size() == 0) {
            Account account1 = new Account();
            Account account2 = new Account();
            
            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");
            
            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");
            
            accountService.save(account1);
            accountService.save(account2);
            
                 
                     
            
            Article article1 = new Article();
            article1.setTitle("Title 1");
            article1.setContent("Content 1");
            article1.setAccount(account1);
            
            Article article2 = new Article();
            article2.setTitle("Title 2");
            article2.setContent("Content 2");
            article2.setAccount(account2);
            
            articleService.save(article1);
            articleService.save(article2);
            
        }
        
    }
}
        

