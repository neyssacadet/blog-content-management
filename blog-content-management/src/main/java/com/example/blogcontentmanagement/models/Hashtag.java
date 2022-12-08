/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.models;
import com.example.blogcontentmanagement.models.Article;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 *
 * @author 18437
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
        
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hashtagId;
    
    @Column(columnDefinition = "TEXT")
    private String hashtagName;
    
    
    @ManyToMany(mappedBy = "hashtags")
    List<Article> articles;
    
    /*@Override
    public String toString() {
        return "Hashtag{" +
            " hashtagId=" +  hashtagId +
            ", hashtagName='" + hashtagName  +
        "}";
    }
    
    public int getId() {
        return hashtagId;
    }

    public void setId(int hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getName() {
        return hashtagName;
    }

    public void setName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.hashtagId;
        hash = 89 * hash + Objects.hashCode(this.hashtagName);
        hash = 89 * hash + Objects.hashCode(this.articles);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hashtag other = (Hashtag) obj;
        if (this.hashtagId != other.hashtagId) {
            return false;
        }
        if (!Objects.equals(this.hashtagName, other.hashtagName)) {
            return false;
        }
        if (!Objects.equals(this.articles, other.articles)) {
            return false;
        }
        return true;
    }*/
  
    
}
