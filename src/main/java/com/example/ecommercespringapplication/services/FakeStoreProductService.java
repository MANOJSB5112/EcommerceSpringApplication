package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.dtos.FakeStoreProductDto;
import com.example.ecommercespringapplication.models.Category;
import com.example.ecommercespringapplication.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
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
//    public Product convertFakeStoreToCategory(FakeStoreProductDto productdto)
//    {
//        Product product=new Product();
//        product.setId(productdto.getId());
//        product.setPrice(productdto.getPrice());
//        product.setTitle(productdto.getTitle());
//        product.setCategory(new Category());
//        product.getCategory().setName(productdto.getCategory());
//        product.setDescription(productdto.getImage());
//        product.setImage(productdto.getImage());
//        return product;
//    }
//    public String convertFakeStoreToCategories(Categories fakeStoreCategoriesDto)
//    {
//        Categories categories=new Categories();
//        categories.setName(fakeStoreCategoriesDto.getName());
//        return categories.getName();
//    }
    @Override
    public  Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        assert productDto != null;
        return convertFakeStoreToProducts(productDto);
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        List<Product> answer = new ArrayList<>();
        for (FakeStoreProductDto fsd : response) {
            answer.add(convertFakeStoreToProducts(fsd));
        }
        return answer;
    }

    @Override
    public Product replaceProduct(Long id,Product product) {
        //FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreToProducts(response);
    }

    @Override
    public List<String> getAllCategories() {
        //FakeStoreCategoriesDto[] response=resttemplate.getForObject("https://fakestoreapi.com/products/categories", FakeStoreCategoriesDto[].class);
        String[] response = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);

        List<String> answer= new ArrayList<>();
        for(String string:response)
        {
            answer.add(string);
        }
        return answer;
    }

    @Override
    public List<Product> getInCategory(String name) {
        String url = "https://fakestoreapi.com/products/category/" + name;
        FakeStoreProductDto[] response = restTemplate.getForObject(url, FakeStoreProductDto[].class);
        List<Product> answer =new ArrayList<>();
        //assert response != null;
        for(FakeStoreProductDto fakeStoreProductDto:response)
        {
            answer.add(convertFakeStoreToProducts(fakeStoreProductDto));
        }
        return answer;
    }
 public Product deleteProduct(Long id)
 {
     String url="'https://fakestoreapi.com/products/6"+id;
     FakeStoreProductDto reponce=restTemplate.getForObject(url,FakeStoreProductDto.class);
     return convertFakeStoreToProducts(reponce);
 }

    @Override
    public void addNewProduct(Product product) {

    }

    @Override
    public void updateProduct(Long id, Product product) {

    }

}