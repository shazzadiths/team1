package com.example.produktapi.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;


import java.util.List;


@SpringBootTest
public class ProductUnitTest {

    Product product = new Product();

    @Test
    public void testGetID(){
        product.setId(101);
        Assertions.assertEquals(Integer.valueOf(101),product.getId());
    }

}


   


