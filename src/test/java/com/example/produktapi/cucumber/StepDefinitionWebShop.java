package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;

import io.cucumber.java.AfterAll;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepDefinitionWebShop {

    @AfterAll
    public static void tearDown() {
        BaseClass.driver.close();
        BaseClass.driver.quit();
    }


    //Shazzad

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
    
    //Somayeh

    @Then("user should see logo")
    public void userShouldSeeLogo() {
        assertTrue(BaseClass.driver.findElement(By.className("d-flex")).isDisplayed());
    }

    @Then("Webpage title should be {string}")
    public void webpageTitleShouldBe(String expectedTitle) {
        String text = BaseClass.driver.findElement(By.className("d-flex")).findElement(By.tagName("h1")).getText();
        assertEquals(expectedTitle, text.trim());
    }

    @Then("User should see the four links {string}")
    public void user_Should_See_The_Four_Links(String expectedLinksText) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> links = BaseClass.driver.findElements(By.cssSelector(".justify-content-end li"));
        assertEquals(expectedLinksText,links.get(0).getText()+","+links.get(1).getText()+","+links.get(2).getText()+","+links.get(3).getText());

    }

    @Then("User should see the link {string} with correct text")
    public void user_Should_See_The_Link_With_Correct_Text(String expectedLinkText) throws InterruptedException {
        Thread.sleep(2000);

        WebElement linkText = BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        assertEquals(expectedLinkText, linkText.getText());
        assertTrue(linkText.isDisplayed());

    }

    @Then("User should see the last product in jewelery with visible title {string}")
    public void user_Should_See_The_Last_Product_In_Jewelery_With_Visible_Title(String expectedTitle) throws InterruptedException {
        Thread.sleep(2000);

        WebElement shopLink = BaseClass.driver.findElement(By.cssSelector(".text-white"));
        shopLink.click();

        BaseClass.driver.get("https://webshop-agil-testautomatiserare.netlify.app/products.html");
        BaseClass.driver.findElement(By.linkText("Jewelery")).click();

        WebElement firstTitle = BaseClass.driver.findElement(By.cssSelector(".card-title"));
        firstTitle.isDisplayed();

        assertEquals(expectedTitle, firstTitle.getText());
    }


    //Emma
    @When("User navigates to all products page by shop button")
    public void user_navigates_to_all_products_page_by_shop_button() {
        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));
        shop.click();
    //Emma
    }
    @Then("Number of categories should be {int}")
    public void number_of_categories_should_be(Integer int1) {
        List<WebElement> categoryItems = BaseClass.driver.findElements(By.className("link-body-emphasis"));
        assertEquals(5, categoryItems.size(), "The number of categories does not match");
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Category link text should be {string}")
    public void category_link_text_should_be(String expectedText) {
        WebElement mensClothingButton = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('men')"));
        String mensLinkText = mensClothingButton.getText();
        assertEquals(expectedText,mensLinkText, "Text does not match");
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Link text should be {string}")
    public void link_text_should_be(String expectedText) {
        WebElement womanClothes = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('women')"));
        String womanLinkText = womanClothes.getText();
        assertEquals(expectedText, womanLinkText, "Text does not match");
        BaseClass.driver.quit();
    }
    //Emma
    @When("User clicks on check out button")
    public void user_clicks_on_check_out_button() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
    }
    //Emma
    @Then("Page would show text {string}")
    public void page_would_show_text(String expectedText) {
        WebElement validateText = BaseClass.driver.findElement(By.cssSelector("body > main > div.py-5.text-center > h2"));
        assertEquals(expectedText, validateText.getText());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Jewelry link text should be displayed")
    public void jewelry_link_text_should_be_displayed() {
        WebElement jewelryLink = BaseClass.driver.findElement(By.cssSelector("body > div.container.mt-5 > div > ul > li:nth-child(4) > a"));
        boolean jewelryLinkText = jewelryLink.isDisplayed();
        assertTrue(jewelryLinkText, "Text is not visible");
        BaseClass.driver.quit();
    }
    //Emma
    @When("User adds one item to cart")
    public void user_adds_one_item_to_cart() {
        WebElement addToCart = BaseClass.driver.findElement(By.className("btn-primary"));
        addToCart.click();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
    }
    //Emma
    @Then("Product in cart should be {int}")
    public void product_in_cart_should_be(Integer int1) {
        WebElement oneProductInCart = BaseClass.driver.findElement(By.xpath("//*[@id=\"buttonSize\"]"));
        assertEquals("1", oneProductInCart.getText());
        BaseClass.driver.quit();
    }
    //Emma
    @And("User removes item")
    public void user_removes_item() {
        WebElement removeOneProduct = BaseClass.driver.findElement(By.cssSelector("button[onclick='removeItem(1)']"));
        removeOneProduct.click();
    }
    //Emma
    @Then("Item in cart should be {int}")
    public void item_in_cart_should_be(Integer int1) {
        WebElement yourCart = BaseClass.driver.findElement(By.id("cartSize"));
        assertEquals("0", yourCart.getText());
        BaseClass.driver.quit();
    }
    //Emma
    @When("User navigates to check out form by clicking on check out button")
    public void user_navigates_to_check_out_form_by_clicking_on_check_out_button() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
    }
    //Emma
    @Then("First name field should be enabled")
    public void first_name_field_should_be_enabled() {
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        assertTrue(firstNameField.isEnabled());
    }
    //Emma
    @Then("First name field should be displayed")
    public void first_name_field_should_be_displayed() {
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        assertTrue(firstNameField.isDisplayed());
        BaseClass.driver.quit();
    }
    //Emma
    @When("User writes name in first name field")
    public void user_writes_name_in_first_name_field() {
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        firstNameField.sendKeys("Birgitta");
        firstNameField.submit();
    }
    //Emma
    @Then("Text should be {string}")
    public void text_should_be(String expectedName) {
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        String val = firstNameField.getAttribute("value");
        assertEquals(expectedName, val, "Text does not match");
        BaseClass.driver.quit();
    }
    //Emma
    @When("User does not enter a name")
    public void user_does_not_enter_a_name() {
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        firstNameField.submit();
    }
    //Emma
    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText, "Error message is not visible");
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Credit check box should be enabled")
    public void credit_check_box_should_be_enabled() {
        WebElement creditCheckbox = BaseClass.driver.findElement(By.id("credit"));
        creditCheckbox.click();
        assertTrue(creditCheckbox.isEnabled());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Credit check box should be displayed")
    public void credit_check_box_should_be_displayed() {
        WebElement creditCheckbox = BaseClass.driver.findElement(By.id("credit"));
        creditCheckbox.click();
        assertTrue(creditCheckbox.isDisplayed());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Credit check box should be selected")
    public void credit_check_box_should_be_selected() {
        WebElement creditCheckbox = BaseClass.driver.findElement(By.id("credit"));
        creditCheckbox.click();
        assertTrue(creditCheckbox.isSelected());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Debit check box should be displayed")
    public void debit_check_box_should_be_displayed() {
        WebElement debitCheckbox = BaseClass.driver.findElement(By.cssSelector("input[id='debit']"));
        assertTrue(debitCheckbox.isDisplayed());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Paypal check box should be displayed")
    public void paypal_check_box_should_be_displayed() {
        WebElement paypalCheckbox = BaseClass.driver.findElement(By.id("paypal"));
        assertTrue(paypalCheckbox.isDisplayed());
        BaseClass.driver.quit();
    }
    //Emma
    @When("User writes name in name of card field")
    public void user_writes_name_in_name_of_card_field() {
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        nameOfCardField.sendKeys("Name");
        nameOfCardField.submit();
    }
    //Emma
    @Then("The text should be {string}")
    public void the_text_should_be(String expectedName) {
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        String val = nameOfCardField.getAttribute("value");
        assertEquals(expectedName, val, "Text does not match");
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Name of card field should be enabled")
    public void name_of_card_field_should_be_enabled() {
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        assertTrue(nameOfCardField.isEnabled());
        BaseClass.driver.quit();
    }
    //Emma
    @Then("Name of card field should be displayed")
    public void name_of_card_field_should_be_displayed() {
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        assertTrue(nameOfCardField.isDisplayed());
        BaseClass.driver.quit();
    }
    //Emma
    @When("User does not write anything in name of card field")
    public void user_does_not_write_anything_in_name_of_card_field() {
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        nameOfCardField.submit();
    }
    //Emma
    @Then("Error message should be visible")
    public void error_message_should_be_visible() {
        WebElement errorMessage = BaseClass.driver.findElement(By.cssSelector("div[class='invalid-feedback']"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
        BaseClass.driver.quit();
    }


    }











