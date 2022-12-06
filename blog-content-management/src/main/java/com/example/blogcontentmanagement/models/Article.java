/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
           
    private LocalDateTime articleCreated;
    
    private LocalDateTime articleUpdated;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "id", nullable =false)
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
