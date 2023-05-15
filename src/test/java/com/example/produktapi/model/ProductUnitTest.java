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
// Test commit
    }
    @Test
    void CheckProductDescription() {
        product.setDescription("Automatiserad testning och testverktyg");
        String newDesc = product.getDescription();
        Assertions.assertEquals( newDesc,"Automatiserad testning och testverktyg");
    }
    @Test
    //EmmaDahl
    void CheckGetCategory(){
    product.setCategory("Jewelery");
    String getCategory = product.getCategory();
    Assertions.assertEquals(getCategory, "Jewelery");
    }

    @Test
//Somayeh
    public void testGetPrice(){

        product.setPrice(200.00);
        double price = product.getPrice();
        Assertions.assertEquals(200.00, price);
    }

    @Test
    void verifyGetDescription(){
        product.setDescription("Original and certified");
        String description = product.getDescription();
        Assertions.assertEquals("Original and certified", description);
    }

    @Test
    void verifyImage(){
        product.setImage("https://www.google.se/search?q=st%C3%B6vlar+earrings&tbm=isch&ved=2ahUKEwi-uey4rO_-AhXDxCoKHRX9C7AQ2-cCegQIABAA&oq=st%C3%B6vlar+earrings&gs_lcp=CgNpbWcQAzoECCMQJzoFCAAQgAQ6BggAEAcQHjoECAAQHjoGCAAQBRAeOgYIABAIEB5QnAJY3xRg-RZoAHAAeACAAUuIAawFkgECMTCYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=zPZdZL6jI8OJqwGV-q-ACw&bih=753&biw=1536#imgrc=hosFOBPchvEXnM");
        String Image = product.getImage();
        Assertions.assertEquals("https://www.google.se/search?q=st%C3%B6vlar+earrings&tbm=isch&ved=2ahUKEwi-uey4rO_-AhXDxCoKHRX9C7AQ2-cCegQIABAA&oq=st%C3%B6vlar+earrings&gs_lcp=CgNpbWcQAzoECCMQJzoFCAAQgAQ6BggAEAcQHjoECAAQHjoGCAAQBRAeOgYIABAIEB5QnAJY3xRg-RZoAHAAeACAAUuIAawFkgECMTCYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=zPZdZL6jI8OJqwGV-q-ACw&bih=753&biw=1536#imgrc=hosFOBPchvEXnM", Image);
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



   


