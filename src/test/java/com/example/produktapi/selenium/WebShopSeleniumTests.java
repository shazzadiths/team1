package com.example.produktapi.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebShopSeleniumTests {
    BaseClass baseClass = new BaseClass();

    @BeforeAll

    static void beforeTest()
        {
          BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
        }

    @Test
    public void verifyWebshopTitle(){
        String pageTitle=  BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
        BaseClass.driver.quit();
    }













    @AfterAll
    static void afterTest() {
        BaseClass. driver.quit();
    }
}
