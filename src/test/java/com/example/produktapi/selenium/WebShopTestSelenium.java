package com.example.produktapi.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebShopTestSelenium {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;
    @BeforeAll
    static void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        actions = new Actions(driver);
        String pageUrl = "https://webshop-agil-testautomatiserare.netlify.app/";
        driver.get(pageUrl);

    }

    @Test
    public void verifyTitle(){
        String websiteHeading = driver.getTitle();
        String pageTitle = "Webbutiken";
        Assertions.assertEquals(pageTitle,websiteHeading,  "title not matching...");
    }

    @AfterAll
    static void afterTest() {
        driver.quit();
    }
}
