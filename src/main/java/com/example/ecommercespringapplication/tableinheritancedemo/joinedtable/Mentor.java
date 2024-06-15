package com.example.ecommercespringapplication.tableinheritancedemo.joinedtable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
    private String company;
    private String favStudent;

}
