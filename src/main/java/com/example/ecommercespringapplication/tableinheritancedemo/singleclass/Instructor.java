package com.example.ecommercespringapplication.tableinheritancedemo.singleclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private Double avgRating;
    private String company;
    private String favStudent;
}
