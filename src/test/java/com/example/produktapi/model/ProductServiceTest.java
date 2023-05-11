package com.example.produktapi.model;


import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import com.example.produktapi.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
 class ProductServiceTest {

    @Autowired
    ProductRepository repository;
    ProductService productService;
    List<Product> productsList;
    List<String> categoriesList;
    List<String> availableCategories = List.of("electronics", "jewelery", "men's clothing", "women's clothing");
    List<Integer> availableCategoriesSize = List.of(6, 4, 4, 6);
   // Product product;

    @BeforeEach
    void setup() {
        productService = new ProductService(repository);
        productsList = productService.getAllProducts();
        categoriesList = productService.getAllCategories();
    }

    @Test
    void checkProductNotNull() {
        Assert.assertTrue(productsList.size() > 0);
        Assert.assertNotNull(productsList);
    }

    @Test
    void checkMaxProduct() {
        Assert.assertEquals(productsList.size(), 20);
    }

    @Test
    void checkCategoriesNotNull() {
        Assert.assertTrue(categoriesList.size() > 0);
        Assert.assertNotNull(categoriesList);
    }

    @Test
    void checkMaxCategories() {
        Assert.assertEquals(categoriesList.size(), 4);
        Assert.assertEquals(categoriesList, availableCategories);
    }

    @Test
    void verifyEachCategorySize() {
        int index = 0;
        for (String category : availableCategories) {
            int categorySize = availableCategoriesSize.get(index);
            Assert.assertNotNull(productService.getProductsByCategory(category));
            Assert.assertEquals(productService.getProductsByCategory(category).size(), categorySize);
            index++;
        }
    }

    @Test
    void verifyInvalidCategory() {
        Assert.assertEquals(productService.getProductsByCategory("test").size(), 0);
        Assert.assertTrue(productService.getProductsByCategory("test").isEmpty());
    }

    @Test
    void verifyEmptyCategory() {
        Assert.assertEquals(productService.getProductsByCategory(" ").size(), 0);
        Assert.assertTrue(productService.getProductsByCategory(" ").isEmpty());
    }

    @Test
    void verifyNullCategory() {
        Assert.assertEquals(productService.getProductsByCategory(null).size(), 0);
        Assert.assertTrue(productService.getProductsByCategory(null).isEmpty());
    }



}
