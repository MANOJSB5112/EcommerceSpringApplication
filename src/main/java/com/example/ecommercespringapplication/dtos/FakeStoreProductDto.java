package com.example.ecommercespringapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    Long id;
    String title;
    Double price;
    String category;
    String description;
    String image;
}
