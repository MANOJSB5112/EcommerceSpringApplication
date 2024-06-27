package com.example.ecommercespringapplication.controllers;


import com.example.ecommercespringapplication.models.Product;
import com.example.ecommercespringapplication.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.*;

@Getter
@Setter
@RestController
@RequestMapping("/storeproducts")
public class ProductController {

    private ProductService productService;
    @Autowired
    ProductController( @Qualifier("fakeProductService")     ProductService productService)
    {
        this.productService=productService;
    }


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authentication") String token)
    {
        ResponseEntity<List<Product>> response=new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id)
    {
        return productService.getSingleProduct(id);
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product)
    {
        Product p=new Product();
        p.setTitle("manoj");
        return p;
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }
    @PatchMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.replaceProduct(id,product);
    }

    //As, we are using third party api,the product is not going to delete but it sends back that product
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id)
    {
        return productService.deleteProduct(id);
    }
    @GetMapping("/categories")
    public List<String> getAllCategories()
    {

        return productService.getAllCategories();
    }

    @GetMapping("/category/{name}")
    public List<Product> getInCategory(@PathVariable String name) {
        return productService.getInCategory(name);
    }

}
