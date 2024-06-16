package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product getSingleProduct(Long id);

    public List<Product> getAllProduct();
    Product replaceProduct(Long id,Product product);

    List<String> getAllCategories();

    List<Product> getInCategory(String name);

    Product deleteProduct(Long id);

    void addNewProduct(Product product);
    void updateProduct(Long id,Product product);

}