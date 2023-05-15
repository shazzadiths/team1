package com.example.produktapi.service;


import com.example.produktapi.exception.BadRequestException;
import com.example.produktapi.exception.EntityNotFoundException;
import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import com.example.produktapi.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


    @Test
    public void testGetProductById() {

        Product result = productService.getProductById(3);
        assertEquals("Mens Cotton Jacket", result.getTitle());

    }

    @Test
    public void testInvalidId() {
        Integer invalidId = 21;
        assertThrows(EntityNotFoundException.class, () -> {
            productService.getProductById(invalidId);
        });
    }

    @Test
    public void testAddProduct() {

        Product newAddedProduct = new Product();
        newAddedProduct.setTitle("new title");

        Product result = productService.addProduct(newAddedProduct);
        assertEquals(newAddedProduct.getTitle(), result.getTitle());
    }

    @Test
    void testAddProductProductAlreadyExists() {

        String existingTitle = "existing product";
        Product existingProduct = new Product();
        existingProduct.setTitle(existingTitle);
        repository.save(existingProduct);

        Product newProduct = new Product();
        newProduct.setTitle(existingTitle);


        BadRequestException exception = assertThrows(BadRequestException.class, () -> productService.addProduct(newProduct));
        assertEquals("En produkt med titeln: " + existingTitle + " finns redan", exception.getMessage());
    }


}

