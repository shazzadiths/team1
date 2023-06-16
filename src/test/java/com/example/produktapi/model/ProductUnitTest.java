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
    //Shazzad
    void CheckProductTitle() {
    product.setTitle("Powerboots Original Stövlar");
    String newtitle = product.getTitle();
    Assertions.assertEquals( newtitle,"Powerboots Original Stövlar");

    }
    //Anjhana
    @Test
    void CheckProductDescription() {
        product.setDescription("Automatiserad testning och testverktyg");
        String newDesc = product.getDescription();
        Assertions.assertEquals( newDesc,"Automatiserad testning och testverktyg");
    }
    @Test
    //EmmaDahl 
    void CheckGetCategory(){
    product.setCategory("Girl's Jewelery");
    String getCategory = product.getCategory();
    Assertions.assertEquals(getCategory, "Girl's Jewelery");
    }

    @Test
//Somayeh
    public void testGetPrice(){

        product.setPrice(200.00);
        double price = product.getPrice();
        Assertions.assertEquals(200.00, price);
    }
   
//Vijaya
    @Test
    public void testGetID(){
        product.setId(101);
        Assertions.assertEquals(Integer.valueOf(101),product.getId());
    }
    @Test
    public void testGetImage(){
        product.setImage("https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg");
        Assertions.assertEquals("https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg",product.getImage());
    }
}



   


