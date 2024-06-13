package com.example.ecommercespringapplication.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    Long id;
    String title;
    Double price;
    String description;
    String image;
    Category category;
}
