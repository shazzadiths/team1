package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    public void user_visits_webpage_with_chrome_driver() {
        BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Then("Title should be {string}")
    public void title_should_be(String string) {
        String pageTitle = BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
        BaseClass.driver.quit();
    }

    //Test 2: Webshop's Header should visible
    @Then("Heading should be {string}")
    public void heading_should_be(String string) {
        WebElement header = BaseClass.driver.findElement(By.cssSelector("a.d-flex"));
        String h1 = header.getText();
        assertEquals("\uD83D\uDECD️ The Shop", h1);
        BaseClass.driver.quit();
    }

    //Somayeh

    @Then("user should see logo")
    public void user_Should_See_Logo() {
        assertTrue(BaseClass.driver.findElement(By.className("d-flex")).isDisplayed());
    }

    @Then("Webpage title should be {string}")
    public void webpage_Title_Should_Be(String expectedTitle) {
        String text = BaseClass.driver.findElement(By.className("d-flex")).findElement(By.tagName("h1")).getText();
        assertEquals(expectedTitle, text.trim());
    }

    @Then("User should see the four links {string}")
    public void user_Should_See_The_Four_Links(String expectedLinksText) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> links = BaseClass.driver.findElements(By.cssSelector(".justify-content-end li"));
        assertEquals(expectedLinksText, links.get(0).getText() + "," + links.get(1).getText() + "," + links.get(2).getText() + "," + links.get(3).getText());

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

    @Then("{string} should be shown and visible")
    public void should_Be_Shown_And_Visible(String expectedText) throws InterruptedException {
        Thread.sleep(2000);
        WebElement text = BaseClass.driver.findElement(By.cssSelector("h2.display-4"));

        text.isDisplayed();
        assertEquals(expectedText, text.getText());


    }
    @When("User click shop link and should navigates to next page")
    public void user_Click_Shop_Link_And_Should_Navigates_To_Next_Page() {
        WebElement shopLink = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));
        shopLink.click();

    }
    @Then("User should be able to type in desired category")
    public void user_Should_Be_Able_To_Type_In_Desired_Category() {

        WebElement searchText = BaseClass.driver.findElement(By.cssSelector("input[type=search][id=search]"));
        searchText.clear();
        searchText.sendKeys("jewelery");
        searchText.click();
        searchText.isDisplayed();
        searchText.submit();

    }

    @Then("Webpage should be able to filter the result and show {int} products")
    public void webpage_Should_Be_Able_To_Filter_The_Result_And_Show_Products(int expectedProductsSize) {
        List<WebElement> products = BaseClass.driver.findElements(By.className("link-body-emphasis"));
        assertEquals(expectedProductsSize, products.size(), "Bug!");
    }


    @Then("Description text should be {string}")
    public void description_Text_Should_Be(String expectedDescriptionText) {
        BaseClass.driver.get("https://webshop-agil-testautomatiserare.netlify.app/products.html");
        BaseClass.driver.findElement(By.linkText("Electronics")).click();
        List<WebElement> elements = BaseClass.driver.findElements(By.cssSelector("main[id=main] div"));
        assertEquals(expectedDescriptionText, elements.get(elements.size() -1 ).findElement(By.cssSelector("p.card-text")).getText());

    }


}