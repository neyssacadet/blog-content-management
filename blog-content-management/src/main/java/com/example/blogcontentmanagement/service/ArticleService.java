/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.service;


import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.repositories.ArticleRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author 18437
 */

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    // return one article by post id
    public Optional<Article> getById(Long articleId){
       return articleRepository.findById(articleId); 
    }
    
    // return all articles
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
    
    // save article
    public Article save (Article article){
        if (article.getArticleId() == null) {
            article.setArticleCreated(LocalDateTime.now());
        }
        
        return articleRepository.save(article);
    }
    
}
