package com.example.ecommercespringapplication.controllertest;

import com.example.ecommercespringapplication.controllers.SelfProductController;
import com.example.ecommercespringapplication.models.Category;
import com.example.ecommercespringapplication.models.Product;
import com.example.ecommercespringapplication.services.ProductService;
import com.example.ecommercespringapplication.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@SpringBootTest
//public class SelfProductControllerTest {
//
//    @MockBean
//    private SelfProductService selfProductService;
//
//    @Autowired
//    private SelfProductController selfProductController;

//    @Test
//    public void testSingleProduct() {
//
//        Product p1 = new Product();
//        p1.setId(1L);
//        p1.setImage("Image1");
//        p1.setPrice(1000.00);
//        p1.setTitle("Iphone1");
//        p1.setDescription("new iPhone");
//        p1.setCategory(new Category());
//
//        when(selfProductService.getSingleProduct(1L)).thenReturn(p1);
//
//       // Product response = selfProductController.getSingleProduct(1L);
//
//        assertEquals(p1, response);
//    }
//}
