/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.models;
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
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hashtagId;
    
    @Column(columnDefinition = "TEXT")
    private String hashtagName;
    
    @NotNull
    @ManyToMany(mappedBy = "hashtags")
    List<Article> articles;
    
    @Override
    public String toString() {
        return "Hashtag{" +
            " hashtagId=" +  hashtagId +
            ", hashtagName='" + hashtagName  +
        "}";
    }
}
