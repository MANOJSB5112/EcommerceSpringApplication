package com.example.ecommercespringapplication.repos;

import com.example.ecommercespringapplication.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepo extends JpaRepository<Product,Long> {

}
