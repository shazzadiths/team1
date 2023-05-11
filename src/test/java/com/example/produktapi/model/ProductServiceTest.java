package com.example.produktapi.model;

import com.example.produktapi.repository.ProductRepository;
import com.example.produktapi.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    //Somayeh
    public void testGetAllProducts() {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("TV", 0.0, "Electronic", "", ""));
        productList.add(new Product("Laptop", 0.0, "Electronic", "", ""));
        productList.add(new Product("T-shirt", 0.0, "Clothing", "", ""));
        productList.add(new Product("ring", 0.0, "Jewelery", "", ""));

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> resultList = productService.getAllProducts();

        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(4, resultList.size());
        Assertions.assertTrue(resultList.size() >= 1);


    }
    @Test
    public void testGetAllCategories() {
        List<String> categoryList = new ArrayList<>();
        categoryList.add("Electronic");
        categoryList.add("Jewelery");
        categoryList.add("Clothing");

        Mockito.when(productRepository.findAllCategories()).thenReturn(categoryList);
        List<String> resultCategoriList = productService.getAllCategories();
        Assertions.assertNotNull(resultCategoriList);
        Assertions.assertEquals(3, resultCategoriList.size());
        Assertions.assertTrue(resultCategoriList.size() >= 1);


    }


}
