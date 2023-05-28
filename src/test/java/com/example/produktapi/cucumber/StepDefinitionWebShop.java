package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Scenario;

import java.util.List;

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
    @When("User visits products page")
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
    @When("User clicks on Women's clothing link")
    public void user_clicks_on_women_s_clothing_link() {
        WebElement womensClothing = BaseClass.driver.findElement(By.linkText("Women's clothing"));
        womensClothing.click();
    }

    @Then("User can verify the total count of women's clothing products are {int}")
    public void user_can_verify_the_total_count_of_women_s_clothing_products_are(Integer count) {
        BaseClass.driver.findElement(By.linkText("Women's clothing")).click();
        List<WebElement> countOfWomensProducts = BaseClass.driver.findElements(By.cssSelector("div.col"));
        int actualCount = countOfWomensProducts.size();
        assertEquals(count, actualCount);
        BaseClass.driver.quit();
    }
    @When("User clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
    }

    @When("User sumit the last name field without entering any value")
    public void user_sumit_the_last_name_field_without_entering_any_value() {
        WebElement lastNameField = BaseClass.driver.findElement(By.cssSelector("input[id='lastName']"));
        lastNameField.submit();
    }

    @Then("User can see error message indicating the missing last name")
    public void user_can_see_error_message_idicating_the_missing_last_name() {
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
        BaseClass.driver.quit();
    }
    @Then("User should see the email id Field enabled and displayed")
    public void user_should_see_the_email_id_field_enabled_and_displayed() {
        WebElement EmailField =  BaseClass.driver.findElement(By.cssSelector("input[id='email']"));
        assertTrue(EmailField.isEnabled());
        assertTrue(EmailField.isDisplayed());
        BaseClass.driver.quit();
    }

}
