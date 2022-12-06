/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.blogcontentmanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 18437
 */

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Authority implements Serializable {
    
    @Id
    @Column(length =16)
    private String name;
    
    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + "'" +
                "}";
    }
}
