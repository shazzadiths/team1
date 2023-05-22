package com.example.produktapi.cucumber;

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
import org.objectweb.asm.TypeReference;
import org.springframework.test.web.client.response.DefaultResponseCreator;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitionAPI {
    private static RequestSpecification request;
    private static Response response;




    //Emma Dahl




    @When("User make GET-request to {string}")
    public void user_make_get_request_to(String endpoint) {
        baseURI = endpoint;
        request = given();
        response = request.request(Method.GET, "");
    }

    @Then("HTTP respons status code should be {int}")
    public void http_respons_status_code_should_be(Integer expectedStatusCode) {
        int actualStatusCode = response.statusCode();

        assertEquals(expectedStatusCode, actualStatusCode, "The status code is not correct");
    }

//somayeh
  
    @Given("the API is running")
    public void theAPIIsRunning() {
        //given().contentType(ContentType.JSON);
        baseURI = "http://localhost:8080";
    }

    @When("user do a Get-request to {string}")
    public void userDoAGetRequestTo(String endpoint) {
        response = RestAssured.get(endpoint);
        //when().get(String.format("http://localhost:8080/products/s", endpoint));

    }

    @Then("the endpoint should be {string} and user should see a list of all products")
    public void theEndpointIsAndUserShouldSeeAListOfAllProducts(String endpoint) {
        String actualEndpoint = "/products";
        assertEquals(actualEndpoint, endpoint, "correct endpoint");
    }

    @Then("the endpoint should be {string}")
    public void theEndpointShouldBe(String endpoint) {
        String actualEndpoint = "/products/categories";
        assertEquals(actualEndpoint, endpoint, "URL endpoint is correct");

    }



    @When("user do a Get-request to {string} to navigate to page jewelery")
    public void userDoAGetRequestToToNavigateToPageJewelery(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the filtered endpoint result should be {string}")
    public void theFilteredEndpointResultShouldBe(String endpoint) {
        String actualEndpoint = "/products/categories/jewelery";
        assertEquals(actualEndpoint, endpoint);
    }

    @And("user should see a list of {int} products in categories jewelery")
    public void userShouldSeeAListOfProductsBySelectedCategoryAndIdNumber(int selectedId) {
        int expectedId = 4;
        List<Product> productList = response.getBody().as(List.class);
        assertEquals( selectedId, expectedId, " here is all the products in categories jewelery ");
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

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
        int expectedCount = 6;
        List<Product> productList = response.getBody().as(List.class);
        assertEquals(expectedCount,count,"Count Does not match");
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
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
        int expectedCount = 4;
        List<Product> productList = response.getBody().as(List.class);
        assertEquals(expectedCount,count,"Count Does not match");
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
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
        int expectedCount = 6;
        List<Product> productList = response.getBody().as(List.class);
        assertEquals(expectedCount,count,"Count Does not match");
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }


}
