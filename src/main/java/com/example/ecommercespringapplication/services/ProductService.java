package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public Product getSingleProduct(Long id);
}