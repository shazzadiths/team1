package com.example.produktapi.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class WebShopSeleniumTests {
    BaseClass baseClass = new BaseClass();

    @BeforeAll

    static void beforeTest()
        {
          BaseClass.NavigatePage("https://webshop-agil-testautomatiserare.netlify.app/");
        }

    @Test
    public void verifyWebShopTitle(){  //Shazzad
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
    void verifyHomeButtonFromOtherPage() { //Shazzad

        verifyShopButtonNavigateToAllProductsPage();
        WebElement home = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"index.html\"]")); //tag.class[attribute=value]
        home.click();
        WebElement homeH2 = BaseClass.driver.findElement(By.cssSelector("h2.lh-1")); //tag.classname
        assertEquals("This shop is all you need", homeH2.getText());
    }
    @Test
    void verifyNumberOfCategoriesInShop(){ //Emma

        verifyShopButtonNavigateToAllProductsPage();
        List<WebElement> categoryItems = BaseClass.driver.findElements(By.className("link-body-emphasis"));
        assertEquals(5, categoryItems.size(),"The number of categories does not match");
    }
    @Test
    void verifyButtonMensClothing(){ //Emma

        verifyShopButtonNavigateToAllProductsPage();
        WebElement mensClothingButton = BaseClass.driver.findElement(By.cssSelector("body > div.container.mt-5 > div > ul > li:nth-child(2) > a"));
        mensClothingButton.click();
        WebElement all = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('all')"));
        String pagetext =all.getText();
        assertEquals("All", pagetext);
    }
    @Test
    void checkWomanClothingLinkText (){ //Emma

        verifyShopButtonNavigateToAllProductsPage();
        WebElement womanClothes = BaseClass.driver.findElement(By.cssSelector("body > div.container.mt-5 > div > ul > li:nth-child(3) > a"));
        String womanLinkText = womanClothes.getText();
        assertEquals("Women's clothing", womanLinkText, "Text does not match");
    }
    @Test
    void verifyCheckOutButton (){ //Emma
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement validateText = BaseClass.driver.findElement(By.cssSelector("body > main > div.py-5.text-center > h2"));
        assertEquals("Checkout form", validateText.getText());
    }
    @Test
    void checkIfJewelryLinkTextIsDisplayed(){ //Emma

        verifyShopButtonNavigateToAllProductsPage();
        WebElement jewelryLink = BaseClass.driver.findElement(By.cssSelector("body > div.container.mt-5 > div > ul > li:nth-child(4) > a"));
        boolean jewelryLinkText = jewelryLink.isDisplayed();
        assertTrue(jewelryLinkText, "Text is not visible");
    }
    @Test
    void verifyProductCategoryList(){   //Shazzad

        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));
        shop.click();
        BaseClass.waitVisibilityOfElementByCss("a[onclick=\"renderProducts('all')");
        List<WebElement> categoryItems = BaseClass.driver.findElements(By.className("link-body-emphasis"));
        assertAll(
                () -> assertEquals("All", categoryItems.get(0).getText(), "Failed, category does not match "),
                () -> assertEquals("Men's clothing", categoryItems.get(1).getText(), "Failed, category does not match "),
                () -> assertEquals("Women's clothing", categoryItems.get(2).getText(), "Failed, category does not match "),
                () -> assertEquals("Jewelery", categoryItems.get(3).getText(), "Failed, category does not match "),
                () -> assertEquals("Electronics", categoryItems.get(4).getText(), "Failed, category does not match ")
        );

    }




    @Test
    void validateCheckoutButtonUpdatedWithURL(){  //Vijaya
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        String actualURL = BaseClass.driver.getCurrentUrl();
        String expectedURL = "https://webshop-agil-testautomatiserare.netlify.app/checkout.html";
        assertEquals(expectedURL,actualURL);
    }
    @Test
    void verifySearchBar(){   //Vijaya
        verifyShopButtonNavigateToAllProductsPage();
        WebElement search =  BaseClass.driver.findElement(By.xpath("//*[@id=\"search\"]"));
        search.clear();
        search.click();
        search.sendKeys("Mens Casual Premium Slim Fit T-Shirts");
        search.submit();
        WebElement S = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3"));
        String actual = S.getText();
        String expected = "Mens Casual Premium Slim Fit T-Shirts";
       // assertEquals(expected,actual);
    }
    @Test    //vijaya
    void verifyTheAddToCartButtonIsEnabled()  {
        verifyShopButtonNavigateToAllProductsPage();
        WebElement addToCartButton = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div/button"));
        assertTrue(addToCartButton.isEnabled());
        assertTrue(addToCartButton.isDisplayed());
    }
    @Test     //vijaya
    void verifyCheckOutButtonIsEnabled(){
        verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        assertTrue(checkoutButton.isEnabled());
        assertTrue(checkoutButton.isDisplayed());
    }
   @Test        //vijaya
    void verifyTheTotalProductsOfWomensClothing()  {
        verifyShopButtonNavigateToAllProductsPage();
        BaseClass.driver.findElement(By.linkText("Women's clothing")).click();
        List<WebElement> countOfWomensProducts = BaseClass.driver.findElements(By.cssSelector("div.col"));
        int actualCount = countOfWomensProducts.size();
        assertEquals(6,actualCount);
}
    @Test
    void verifyTheTotalProductsOfMensClothing(){
        verifyShopButtonNavigateToAllProductsPage();
        BaseClass.driver.findElement(By.linkText("Men's clothing")).click();
        List<WebElement> countofMensProducts = BaseClass.driver.findElements(By.cssSelector("div.col"));
        int actualCount = countofMensProducts.size();
        assertEquals(4,actualCount);

    }








    @AfterAll
    static void afterTest() {
        BaseClass. driver.quit();
    }
}
