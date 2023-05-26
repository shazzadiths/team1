package com.example.produktapi.cucumber;

import com.example.produktapi.selenium.BaseClass;
import io.cucumber.java.AfterAll;
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
}
