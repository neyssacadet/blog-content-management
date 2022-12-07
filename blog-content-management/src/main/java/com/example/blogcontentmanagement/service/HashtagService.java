/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.service;

import com.example.blogcontentmanagement.models.Hashtag;
import com.example.blogcontentmanagement.repositories.HashtagRepository;
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
public class HashtagService {
    
    @Autowired
    private HashtagRepository hashtagRepository;
    
    
    
}
