/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author 18437
 */

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @Column
    private LocalDateTime articleCreated;
    
    @Column
    private LocalDateTime articleUpdated;
    
    @Column
    LocalDate articleExpired;
    
    @Column
    boolean approved;
    
    @ManyToMany
    @JoinTable(name = "ArticleHashtag",
            joinColumns = {@JoinColumn(name = "articleId")},
            inverseJoinColumns = {@JoinColumn(name = "hashtagId")})
    private List<Hashtag> hashtags;
    
    public LocalDate getExpiryDate() {
        return articleExpired;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.articleExpired = articleExpired;
    }
    
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean Approved) {
        this.approved = Approved;
    }
    
    @ManyToOne
    @JoinColumn(name = "Id", nullable =false)
    private Account account;
    
    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", title='" + title + "'" +
            ", content='" + content + "'" +
            ", articleCreated='" + articleCreated + "'" +
            ", articleUpdated=" + articleUpdated +
        "}";
   
    }
     
    
    
    
}
