package com.example.ecommercespringapplication.controllers;

import com.example.ecommercespringapplication.models.Product;
import com.example.ecommercespringapplication.repos.ProductServiceRepo;
import com.example.ecommercespringapplication.services.ProductService;
import com.example.ecommercespringapplication.services.SelfProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@RestController
@RequestMapping("/selfproduct")
public class SelfProductController {
    private SelfProductService selfProductService;
    private final ProductServiceRepo productServiceRepo;

    @Autowired
    SelfProductController(SelfProductService selfProductService,
                          ProductServiceRepo productServiceRepo)
    {

        this.selfProductService=selfProductService;
        this.productServiceRepo = productServiceRepo;
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable Long id)
    {
        return selfProductService.getSingleProduct(id);
    }
    @PostMapping()
    public void saveProduct(@RequestBody Product product)
    {
         selfProductService.saveProduct(product);
    }
    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
        selfProductService.updateProduct(id,product);
    }
}

