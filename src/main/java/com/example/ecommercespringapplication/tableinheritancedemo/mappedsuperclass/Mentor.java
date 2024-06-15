package com.example.ecommercespringapplication.tableinheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
public class Mentor extends User{
    private String company;
    private String favStudent;

}
