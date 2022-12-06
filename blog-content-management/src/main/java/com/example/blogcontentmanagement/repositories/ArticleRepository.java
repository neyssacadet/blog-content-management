/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.repositories;

import com.example.blogcontentmanagement.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 18437
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
