package com.example.ecommercespringapplication.tableinheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")
public class Instructor extends User{
    private Double avgRating;
    private String company;
    private String favStudent;
}
