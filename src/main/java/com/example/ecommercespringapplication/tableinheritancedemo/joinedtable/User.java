package com.example.ecommercespringapplication.tableinheritancedemo.joinedtable;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}
