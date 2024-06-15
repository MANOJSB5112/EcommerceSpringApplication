package com.example.ecommercespringapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
   private String title;
    private Double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
