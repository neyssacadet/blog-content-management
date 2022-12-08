package com.example.blogcontentmanagement.config;

import com.example.blogcontentmanagement.models.Account;
import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.models.Authority;
import com.example.blogcontentmanagement.repositories.AuthorityRepository;
import com.example.blogcontentmanagement.service.AccountService;
import com.example.blogcontentmanagement.service.ArticleService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class SeedData implements CommandLineRunner {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private AuthorityRepository authorityRepository;
    
    @Override
    public void run(String... args) throws Exception {
        List<Article> articles = articleService.getAll();
        
        if(articles.size() == 0) {
            
            Authority user = new Authority();
            user.setAuthorityName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setAuthorityName("ROLE_ADMIN");
            authorityRepository.save(admin);
            
            Account account1 = new Account();
            Account account2 = new Account();
            
            account1.setFirstName("user_first");
            account1.setLastName("user_last");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);
            
            account2.setFirstName("admin_first");
            account2.setLastName("admin_last");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");
            
            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);
            
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
        

