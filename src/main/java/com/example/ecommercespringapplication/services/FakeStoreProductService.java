package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.dtos.FakeStoreProductDto;
import com.example.ecommercespringapplication.models.Category;
import com.example.ecommercespringapplication.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate resttemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.resttemplate=restTemplate;
    }

    public Product convertFakeStoreToProducts(FakeStoreProductDto productdto)
    {
        Product product=new Product();
        product.setId(productdto.getId());
        product.setPrice(productdto.getPrice());
        product.setTitle(productdto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(productdto.getCategory());
        product.getCategory().setId(productdto.getId());
        product.setDescription(productdto.getImage());
        product.setImage(productdto.getImage());
        return product;
    }
    @Override
    public  Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = resttemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        assert productDto != null;
        return convertFakeStoreToProducts(productDto);
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] response=resttemplate.getForObject(
                "https://fakestoreapi.com/products",FakeStoreProductDto[].class
        );
        List<Product> answer=new ArrayList<>();
        for(FakeStoreProductDto fsd:response)
        {
            answer.add(convertFakeStoreToProducts(fsd));
        }
        return answer;
    }
}