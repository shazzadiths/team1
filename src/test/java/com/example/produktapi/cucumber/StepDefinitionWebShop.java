package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitionWebShop {  //Shazzad

    //Test1: Webshop's webpage should work properly & showing correct title
    @Given("Chrome web driver in available")
    public void chrome_web_driver_in_available() {
        BaseClass.GetChromeDriver();
    }
    @When("User visits webpage")
    public void user_visits_webpage() {
       BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
    }
    @Then("Title should be {string}")
    public void title_should_be(String string) {
        String pageTitle=  BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
    }


}
