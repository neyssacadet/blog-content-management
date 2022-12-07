/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.repositories;

import com.example.blogcontentmanagement.models.Article;
import com.example.blogcontentmanagement.models.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 18437
 */
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    
}
