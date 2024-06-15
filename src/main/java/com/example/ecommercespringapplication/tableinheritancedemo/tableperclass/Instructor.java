package com.example.ecommercespringapplication.tableinheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class Instructor extends User {
    private Double avgRating;
    private String company;
    private String favStudent;
}
