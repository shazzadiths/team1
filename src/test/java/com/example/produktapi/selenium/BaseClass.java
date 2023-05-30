package com.example.produktapi.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class BaseClass {                    //Shazzad

    public static WebDriver driver;

    private static ChromeOptions GetChromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);

        return options;
    }

    private static EdgeOptions GetEdgeOptions() {
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        // options.addArguments("--incognito");
        // options.addArguments("headless");
        return options;
    }


    public  static  WebDriver GetChromeDriver(){
        driver = new ChromeDriver(GetChromeOptions() );
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        return driver;
    }
    public   static  WebDriver GetEdgeDriver(){
        driver = new EdgeDriver(GetEdgeOptions());
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        return driver;
    }
    public static void NavigatePage(String url){
       GetChromeDriver().get(url);
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //Can use for Edge browser
       // GetEdgeDriver().get(url);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void waitVisibilityOfElementByCss(String url){
        WebDriverWait wait1 = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(15));
        wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(url)));
    }



}
