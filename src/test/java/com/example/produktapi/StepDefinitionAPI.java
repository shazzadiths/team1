package com.example.produktapi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitionAPI {
    private static RequestSpecification request;
    private static Response response;

    //Emma Dahl
    @When("User make GET-request to {string}")
    public void user_make_get_request_to(String endpoint) {
        baseURI = endpoint;
        request = given();
        response = request.request(Method.GET,"");
    }
    //Emma Dahl
    @Then("HTTP respons status code should be {int}")
    public void http_respons_status_code_should_be(Integer expectedStatusCode) {
        int actualStatusCode = response.statusCode();

        assertEquals(expectedStatusCode,actualStatusCode, "The status code is not correct");
    }
}
