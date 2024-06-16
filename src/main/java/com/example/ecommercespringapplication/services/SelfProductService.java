package com.example.ecommercespringapplication.services;

import com.example.ecommercespringapplication.models.Product;
import com.example.ecommercespringapplication.repos.ProductServiceRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service("selfProductService")
@Qualifier
public class SelfProductService implements ProductService{
     ProductServiceRepo productServiceRepo;
     @Autowired
     SelfProductService(ProductServiceRepo productServiceRepo)
     {
         this.productServiceRepo=productServiceRepo;
     }

    @Override
    public Product getSingleProduct(Long id) {
        //return productServiceRepo.getSingleProduct(id);
        Optional<Product> savedProduct= productServiceRepo.findById(id);
        if(savedProduct.isEmpty())
        {
            throw new RuntimeException("Product Not found By this ID"+id);
        }
        Product product= savedProduct.get();
        return product;
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

    @Override
    public void saveProduct(Product product) {
       Product newProduct=new Product();
       newProduct.setTitle(product.getTitle());
       newProduct.setDescription(product.getDescription());
       newProduct.setImage(product.getImage());
       newProduct.setPrice(product.getPrice());
       productServiceRepo.save(newProduct);
    }

    @Override
    public void updateProduct(Long id,Product product) {
      Optional<Product> savedProduct=productServiceRepo.findById(id);
      if(savedProduct.isPresent())
      {
         Product existingProduct=savedProduct.get();
         existingProduct.setTitle(product.getTitle());
         existingProduct.setPrice(product.getPrice());
         existingProduct.setDescription(product.getDescription());
         existingProduct.setImage(product.getImage());
         productServiceRepo.save(existingProduct);
      }else
      {
          throw new RuntimeException("Product not found with the ID "+id);
      }
    }
}
