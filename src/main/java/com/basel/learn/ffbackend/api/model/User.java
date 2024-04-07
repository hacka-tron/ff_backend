package com.basel.learn.ffbackend.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;
    
    private String name;
    
    private String email;
}
