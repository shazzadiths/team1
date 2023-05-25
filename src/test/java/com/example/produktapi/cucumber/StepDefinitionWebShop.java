package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitionWebShop {  //Shazzad

    //Test1: Webshop's webpage should work properly & showing correct title

    @Given("User visits webpage with chrome driver")
    public void user_visits_webpage_with_chrome_driver()  {
        BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
    }
    @Then("Title should be {string}")
    public void title_should_be(String string) {
        String pageTitle=  BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
        BaseClass.driver.quit();
    }
    //Test 2: Webshop's Header should visible
    @Then("Heading should be {string}")
    public void heading_should_be(String string) {
        WebElement header = BaseClass.driver.findElement(By.cssSelector("a.d-flex"));
        String h1 =header.getText();
        assertEquals( "\uD83D\uDECD️ The Shop", h1 );
        BaseClass.driver.quit();
    }
    @Given("User visits products page")
    public void user_visits_products_page() {
        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));
        shop.click();
    }
    @When("user look for the add to cart button")
    public void user_look_for_the_add_to_cart_button() {
       WebElement addToCartButton = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div/button"));
            }

    @Then("The add to cart button should be enabled and displayed")
    public void the_add_to_cart_button_should_be_enabled_and_displayed() {
        WebElement addToCartButton = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div/button"));
        assertTrue(addToCartButton.isEnabled());
        assertTrue(addToCartButton.isDisplayed());
        BaseClass.driver.quit();
    }
    @When("user look for the Checkout button")
    public void user_look_for_the_checkout_button() {
       WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
    }

    @Then("The Checkout button should be enabled and displayed")
    public void the_checkout_button_should_be_enabled_and_displayed() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        assertTrue(checkoutButton.isEnabled());
        assertTrue(checkoutButton.isDisplayed());
        BaseClass.driver.quit();
    }


}
