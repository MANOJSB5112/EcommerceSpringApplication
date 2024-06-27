package com.example.ecommercespringapplication.controllers;

import com.example.ecommercespringapplication.commons.AuthenticationCommons;
import com.example.ecommercespringapplication.models.Product;
import com.example.ecommercespringapplication.repos.ProductServiceRepo;
import com.example.ecommercespringapplication.services.ProductService;
import com.example.ecommercespringapplication.services.SelfProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/products")
public class SelfProductController {
    private SelfProductService selfProductService;
    private final ProductServiceRepo productServiceRepo;
    private AuthenticationCommons authenticationCommons;

    @Autowired
    SelfProductController(SelfProductService selfProductService,
                          ProductServiceRepo productServiceRepo,
                          AuthenticationCommons authenticationCommons)
    {

        this.selfProductService=selfProductService;
        this.productServiceRepo = productServiceRepo;
        this.authenticationCommons=authenticationCommons;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable Long id)
    {
//        if(authenticationCommons.validateToken(token)==null)
//        {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
        Product product = selfProductService.getSingleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(@RequestHeader("Authentication") String token)
    {
        if(authenticationCommons.validateToken(token)==null)
        {
           return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Product> products = selfProductService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping()
    public void addNewProduct(@RequestBody Product product)
    {
         selfProductService.addNewProduct(product);
    }
    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
        selfProductService.updateProduct(id,product);
    }
}

