package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Service("selfProductService")
@Qualifier
public class SelfProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        List<String> answer=new ArrayList<>();
        answer.add("Mobiles");
        answer.add("Laptop");
        answer.add("TV");
        answer.add("Home Appliances");
        return answer;
    }

    @Override
    public List<Product> getInCategory(String name) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
