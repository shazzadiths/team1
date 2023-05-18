package com.example.produktapi.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebShopSeleniumTests {
    BaseClass baseClass = new BaseClass();

    @BeforeAll

    static void beforeTest()
        {
          BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
        }

    @Test
    public void verifyWebshopTitle(){  //Shazzad
        String pageTitle=  BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
    }
    @Test
    void verifyWebShopHeaderVisible(){    //Shazzad

        WebElement header = BaseClass.driver.findElement(By.cssSelector("a.d-flex"));
        String h1 =header.getText();
        assertEquals( "\uD83D\uDECD️ The Shop", h1 );
    }

    @Test
    void verifyShopButtonNavigateToAllProductsPage(){   //Shazzad

        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));
        shop.click();
        BaseClass.waitVisibilityOfElementByCss("a[onclick=\"renderProducts('all')");
        WebElement all = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('all')"));
        String pagetext =all.getText();
        assertEquals("All", pagetext);

    }
    @Test
    void verifyAllProductsList(){  //Shazzad

        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));  //tag.class[attribute=value]
        shop.click();
        BaseClass.waitVisibilityOfElementByCss("a[onclick=\"renderProducts('all')");   //tagName[attribute=‘attribute_Value’]
        List<WebElement> allproductsList = BaseClass.driver.findElements(By.cssSelector("div.col"));  //tag.classname
        assertEquals(20, allproductsList.size(), "Antalet Program har andrät ...");  //
    }
    @Test
    void verifyHomeButtonFromOtherPage(){ //Shazzad

        verifyShopButtonNavigateToAllProductsPage();
        WebElement home = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"index.html\"]"));
        home.click();
        WebElement homeH2 = BaseClass.driver.findElement(By.cssSelector("h2.lh-1")); //tag.classname
        assertEquals("This shop is all you need", homeH2.getText());

    }











    @AfterAll
    static void afterTest() {
        BaseClass. driver.quit();
    }
}
