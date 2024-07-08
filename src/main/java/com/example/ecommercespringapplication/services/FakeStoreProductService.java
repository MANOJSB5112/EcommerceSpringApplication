package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.dtos.FakeStoreProductDto;
import com.example.ecommercespringapplication.models.Category;
import com.example.ecommercespringapplication.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeProductService")
@Qualifier
public class FakeStoreProductService implements ProductService {
    private final RestTemplate restTemplate;
    private final RedisTemplate<String, String> template;
    private final ObjectMapper objectMapper;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, String> template) {
        this.restTemplate = restTemplate;
        this.template = template;
        this.objectMapper = new ObjectMapper();
    }

    private static final String STRING_KEY_PREFIX = "redi2read:strings:";

    public Product convertFakeStoreToProducts(FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = new Category();
        category.setName(productDto.getCategory());
        category.setId(productDto.getId());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        return product;
    }

    @Override
    public Product getSingleProduct(Long id) {
        String redisKey = STRING_KEY_PREFIX + id;
        FakeStoreProductDto productDto = null;

        // Try to fetch the product from Redis
        String productJson = template.opsForValue().get(redisKey);
        if (productJson != null) {
            try {
                productDto = objectMapper.readValue(productJson, FakeStoreProductDto.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // If the product is not found in Redis, fetch it from the REST API
        if (productDto == null) {
            productDto = restTemplate.getForObject(
                    "https://fakestoreapi.com/products/" + id,
                    FakeStoreProductDto.class
            );
            assert productDto != null;  // Ensure that the product was successfully fetched from the API

            // Save the fetched product to Redis
            try {
                productJson = objectMapper.writeValueAsString(productDto);
                template.opsForValue().set(redisKey, productJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // Convert and return the product
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