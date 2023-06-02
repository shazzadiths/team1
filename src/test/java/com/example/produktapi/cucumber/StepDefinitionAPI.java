package com.example.produktapi.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.common.assertion.Assertion;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.client.response.DefaultResponseCreator;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitionAPI {
    private static RequestSpecification request;
    private static Response response;
    private static String id;
    private static String title;
    private static String price;
    private static String category;
    private static String description;
    private static String image;

    @BeforeEach
    public void before(){
        baseURI = "https://produktapi.herokuapp.com";
    }

//Emma Dahl


    @When("User make GET-request to {string}")
    public void user_make_get_request_to(String endpoint) {
        baseURI = endpoint;
        request = given();
        response = request.request(Method.GET, "");
    }

    @Then("HTTP response status code should be {int}")
    public void http_response_status_code_should_be(Integer expectedStatusCode) {
        int actualStatusCode = response.statusCode();

        assertEquals(expectedStatusCode, actualStatusCode, "The status code is not correct");
    }

//somayeh


    @When("user makes a GET request to {string}")
    public void userDoAGetRequestTo(String url) {
        baseURI = url;
        response = RestAssured.given().get();
    }

    @And("user should see a list of all products with size={int}")
    public void userShouldSeeAListOfAllProducts(int productsCount) {
        List<Object> products = response.getBody().jsonPath().getList("products");
        assertNotNull(products);
        assertEquals(productsCount, products.size());
    }

    @And("the response should contain {int} categories")
    public void the_Response_Should_Contain_All_Categories(int expectedCategoryCount) {
        int categorySize = response.getBody().jsonPath().getList("").size();
        assertEquals(expectedCategoryCount, categorySize);
    }

    @And("the first category should be {string} and the last category should be {string}")
    public void theFirstCategoryShouldBe(String expectedFirstCategory, String expectedLastCategory) {
        String firstCategory = response.getBody().jsonPath().getList("").get(0).toString();
        String lastCategory = response.getBody().jsonPath().getList("").get(3).toString();
        assertEquals(expectedFirstCategory, firstCategory);
        assertEquals(expectedLastCategory, lastCategory);
    }


    @And("it should contains the following attributes:")
    public void it_Should_Contain_The_Following_Attributes(DataTable dataTable) {

        dataTable.asMap(String.class, String.class).forEach((attribute, expectedValue) -> {
            switch (attribute.toLowerCase()) {
                case "id" -> {
                    id = response.jsonPath().getString("id");
                    assertEquals(expectedValue, id);
                }
                case "title" -> {
                    title = response.jsonPath().getString("title");
                    assertEquals(expectedValue, title);
                }
                case "price" -> {
                    price = response.jsonPath().getString("price");
                    assertEquals(expectedValue, price);
                }
                case "category" -> {
                    category = response.jsonPath().getString("category");
                    assertEquals(expectedValue, category);
                }
                case "description" -> {
                    description = response.jsonPath().getString("description");
                    assertEquals(expectedValue, description);
                }
                case "image" -> {
                    image = response.jsonPath().getString("image");
                    assertEquals(expectedValue, image);
                }
                default -> fail("Invalid attribute: " + attribute);
            }
        });
    }


    //Vijaya
    @When("User make a GET-request to {string}")
    public void user_make_a_get_request_to(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the endpoin result should be {string}")
    public void the_endpoin_result_should_be(String endpoint) {
        String actualEndPoint = "/products/categories/electronics";
        assertEquals(endpoint,actualEndPoint);
    }

    @Then("page has to upload with {int} electronic products")
    public void page_has_to_upload_with_electronic_products(Integer count) {
        int actualCount = response.getBody().jsonPath().getList("products").size();
        assertEquals(count,actualCount,"Count Does not match");
    }

    @When("User make a GET-request to navigate Men's Clothing {string}")
    public void user_make_a_get_request_to_navigate_men_s_clothing(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the endpoint result should be {string}")
    public void the_endpoint_result_should_be(String endpoint) {
        String actualEndPoint = "/products/categories/men's clothing";
        assertEquals(endpoint,actualEndPoint);
    }

    @Then("page has to upload with {int} men's clothing products")
    public void page_has_to_upload_with_men_s_clothing_products(Integer count) {
        int actualCount = response.getBody().jsonPath().getList("products").size();
        assertEquals(count,actualCount,"Count Does not match");
    }

    @When("User make a GET-request to navigate women's Clothing {string}")
    public void user_make_a_get_request_to_navigate_women_s_clothing(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the endpoint result should be {string} for navigate women's clothing")
    public void the_endpoint_result_should_be_for_navigate_women_s_clothing(String endpoint) {
        String actualEndPoint = "/products/categories/women's clothing";
        assertEquals(endpoint,actualEndPoint);
    }

    @Then("page has to upload with {int} Women's clothing products")
    public void page_has_to_upload_with_women_s_clothing_products(Integer count) {
        int actualCount = response.getBody().jsonPath().getList("products").size();
        assertEquals(count,actualCount,"Count Does not match");
    }



}
