package com.example.produktapi.model;

import com.example.produktapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    public Product product1;
    public Product product2;
    public Product product3;
    public Product product4;


    @BeforeEach

    public void setUp() {
        productRepository.deleteAll();
        product1 = new Product("TV", 0.0, "Electronic", "", "");
        product2 = new Product("Laptop", 0.0, "Electronic", "", "");
        product3 = new Product("T-shirt", 0.0, "Clothing", "", "");
        product4 = new Product("ring", 0.0, "Jewelery", "", "");

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));
    }


    @Test
    //Somayeh
    public void testFindCategory() {


        List<Product> myProductList = productRepository.findByCategory("Electronic");

        assertEquals(2, myProductList.size());
        assertEquals("TV", myProductList.get(0).getTitle());
        assertEquals("Laptop", myProductList.get(1).getTitle());


    }
}
