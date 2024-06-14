package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.dtos.FakeStoreProductDto;
import com.example.ecommercespringapplication.models.Categories;
import com.example.ecommercespringapplication.models.Category;
import com.example.ecommercespringapplication.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product getSingleProduct(Long id);

    public List<Product> getAllProduct();
    Product replaceProduct(Long id,Product product);

    List<Categories> getAllCategories();

    List<Product> getInCategory(String name);
}