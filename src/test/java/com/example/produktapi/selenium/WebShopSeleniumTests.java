package com.example.produktapi.selenium;

import jdk.jfr.Timespan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
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
    public void verifyWebShopTitle() {  //Shazzad
        String pageTitle = BaseClass.driver.getTitle();
        assertEquals("Webbutiken", pageTitle);
    }

    @Test
    void verifyWebShopHeaderVisible() {    //Shazzad

        WebElement header = BaseClass.driver.findElement(By.cssSelector("a.d-flex"));
        String h1 = header.getText();
        assertEquals("\uD83D\uDECD️ The Shop", h1);
    }

    @Test
    void verifyShopButtonNavigateToAllProductsPage() {   //Shazzad

        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href='products.html']"));  //"a.text-white[href=\"products.html\"]"
        BaseClass.waitVisibilityOfElementByCss("a.text-white[href='products.html']");
        BaseClass.javaScriptClick(shop);


        BaseClass.waitVisibilityOfElementByCss("a[onclick=\"renderProducts('all')\"]");
        WebElement all = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('all')\"]"));
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pagetext = all.getText();
        assertEquals("All", pagetext);

    }

    @Test
    void verifyAllProductsList()  {  //Shazzad

         WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));  //a.text-white[href="products.html"]
         BaseClass.waitUntilElementIsClickableCSS("a.text-white[href=\"products.html\"]");
         BaseClass.javaScriptClick(shop);
        BaseClass.waitVisibilityOfElementByCss("a[onclick=\"renderProducts('all')\"]");   //tagName[attribute=‘attribute_Value’]
        List<WebElement> allproductsList = BaseClass.driver.findElements(By.cssSelector("div.col"));  //tag.classname
        assertEquals(20, allproductsList.size(), "Antal produkter har andrät ...");  //
    }

    @Test
    void verifyHomeButtonFromOtherPage() { //Shazzad

        verifyShopButtonNavigateToAllProductsPage();
        WebElement home = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"index.html\"]")); //tag.class[attribute=value]
        BaseClass.javaScriptClick(home);
        WebElement homeH2 = BaseClass.driver.findElement(By.cssSelector("h2.lh-1")); //tag.classname
        assertEquals("This shop is all you need", homeH2.getText());
    }

    @Test
    void verifyNumberOfCategoriesInShop() { //Emma

        verifyShopButtonNavigateToAllProductsPage();

        List<WebElement> categoryItems = BaseClass.driver.findElements(By.className("link-body-emphasis"));
        assertEquals(5, categoryItems.size(), "The number of categories does not match");
    }

    @Test
    void verifyButtonMensClothing() { //Emma

        verifyShopButtonNavigateToAllProductsPage();

        WebElement mensClothingButton = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('men')"));
        String mensLinkText = mensClothingButton.getText();
        assertEquals("Men's clothing",mensLinkText, "Text does not match");

    }



    @Test
    void checkWomanClothingLinkText() { //Emma

        verifyShopButtonNavigateToAllProductsPage();
        WebElement womanClothes = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('women')"));
        String womanLinkText = womanClothes.getText();
        assertEquals("Women's clothing", womanLinkText, "Text does not match");
    }

    @Test
    void verifyCheckOutButton() { //Emma
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement validateText = BaseClass.driver.findElement(By.cssSelector("body > main > div.py-5.text-center > h2"));
        assertEquals("Checkout form", validateText.getText());
    }

    @Test
    void checkIfJewelryLinkTextIsDisplayed() { //Emma

        verifyShopButtonNavigateToAllProductsPage();
        WebElement jewelryLink = BaseClass.driver.findElement(By.cssSelector("body > div.container.mt-5 > div > ul > li:nth-child(4) > a"));
        boolean jewelryLinkText = jewelryLink.isDisplayed();
        assertTrue(jewelryLinkText, "Text is not visible");
    }

    @Test
    void verifyProductCategoryList() {   //Shazzad

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
    void validateCheckoutButtonUpdatedWithURL() {  //Vijaya
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        String actualURL = BaseClass.driver.getCurrentUrl();
        String expectedURL = "https://webshop-agil-testautomatiserare.netlify.app/checkout.html";
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void verifySearchBar() {   //Vijaya
        verifyShopButtonNavigateToAllProductsPage();
        WebElement search = BaseClass.driver.findElement(By.xpath("//*[@id=\"search\"]"));
        search.clear();
        search.click();
        search.sendKeys("Mens Casual Premium Slim Fit T-Shirts");
        search.submit();
        WebElement S = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3"));
        String actual = S.getText();
        String expected = "Mens Casual Premium Slim Fit T-Shirts";
        // assertEquals(expected,actual);
    }

    @Test
        //vijaya
    void verifyTheAddToCartButtonIsEnabled() {
        verifyShopButtonNavigateToAllProductsPage();
        WebElement addToCartButton = BaseClass.driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div/button"));
        assertTrue(addToCartButton.isEnabled());
        assertTrue(addToCartButton.isDisplayed());
    }

    @Test
        //vijaya
    void verifyCheckOutButtonIsEnabled() {
        verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        assertTrue(checkoutButton.isEnabled());
        assertTrue(checkoutButton.isDisplayed());
    }

    @Test
        //vijaya
    void verifyTheTotalProductsOfWomensClothing() {
        verifyShopButtonNavigateToAllProductsPage();
        BaseClass.driver.findElement(By.linkText("Women's clothing")).click();
        BaseClass.waitPageLoad();
        List<WebElement> countOfWomensProducts = BaseClass.driver.findElements(By.cssSelector("div.col"));
        int actualCount = countOfWomensProducts.size();
        assertEquals(6, actualCount);
    }

    @Test
    void verifyTheTotalProductsOfMensClothing() {
        verifyShopButtonNavigateToAllProductsPage();
        BaseClass.waitPageLoad();
        BaseClass.driver.findElement(By.linkText("Men's clothing")).click();

        BaseClass.waitVisibilityOfElementByCss("div.col");
        List<WebElement> countofMensProducts = BaseClass.driver.findElements(By.cssSelector("div.col"));
        int actualCount = countofMensProducts.size();
        assertEquals(4,actualCount);
    }


    @Test
        //Emma
    void checkFirstNameFieldIsEnabled() {
        verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        assertTrue(firstNameField.isEnabled());
        assertTrue(firstNameField.isDisplayed());
    }

    //Somayeh
    @Test
    public void verify_Main_Page_Logo() {
        assertTrue(BaseClass.driver.findElement(By.className("d-flex")).isDisplayed());
    }

    @Test
    public void get_Shop_Text() {
        String text = BaseClass.driver.findElement(By.className("d-flex")).findElement(By.tagName("h1")).getText();
        assertEquals("\uD83D\uDECD️ The Shop", text.trim());
    }


    @Test
    public void verify_If_Home_Shop_Checkout_About_Is_Visible_And_Has_Correct_Text() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> links = BaseClass.driver.findElements(By.cssSelector(".justify-content-end li"));
        assertEquals("Home", links.get(0).getText());
        assertEquals("Shop", links.get(1).getText());
        assertEquals("Checkout", links.get(2).getText());
        assertEquals("About", links.get(3).getText());
    }

    @Test
    public void get_Home_Link_Text() {

        WebElement homeLink = BaseClass.driver.findElement(By.partialLinkText("Home"));
        assertTrue(homeLink.isDisplayed());
        WebElement linkText = homeLink.findElement(By.xpath("//a[contains(text(),'Home')]"));
        assertEquals("Home", linkText.getText());
        assertTrue(linkText.isDisplayed());

    }

    @Test
    public void test_Get_Title_Text_For_First_Product_In_Jewelery() throws InterruptedException {

        WebElement shop = BaseClass.driver.findElement(By.cssSelector("a.text-white[href=\"products.html\"]"));  //tag.class[attribute=value]
       BaseClass.javaScriptClick(shop);
        Thread.sleep(2000);
        WebElement jewelery = BaseClass.driver.findElement(By.cssSelector("a[onclick=\"renderProducts('jewelery')\"]"));
        BaseClass.javaScriptClick(jewelery);
        Thread.sleep(2000);
        WebElement firstTitle = BaseClass.driver.findElement(By.xpath("/html/body/main/div[1]/div/div/h3"));  //Shazzad ändrat till xpath
        firstTitle.isEnabled();
        assertEquals("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", firstTitle.getText());
    }

    @Test
        //Emma
    void verifyWritingInFirstNameField() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        firstNameField.sendKeys("Birgitta");
        firstNameField.submit();
        String val = firstNameField.getAttribute("value");
        assertEquals("Birgitta", val, "Text does not match");
    }

    @Test
        //Emma
    void verifyErrorMessageInFirstNameField() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement firstNameField = BaseClass.driver.findElement(By.cssSelector("input[id='firstName']"));
        firstNameField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText, "Error message is not visible");
    }

    @Test  //Vijaya
    void checkLastNameFieldIsEnabled(){
      //  verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement lastNameField =  BaseClass.driver.findElement(By.cssSelector("input[id='lastName']"));
        assertTrue(lastNameField.isEnabled());
        assertTrue(lastNameField.isDisplayed());
    }

    @Test  //Vijaya
    void verifyLastNameField(){
        verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement lastNameField =  BaseClass.driver.findElement(By.cssSelector("input[id='lastName']"));
        lastNameField.sendKeys("Little Prince");
        lastNameField.submit();
        String actual = lastNameField.getAttribute("value");
        assertEquals("Little Prince",actual,"Name does not match");
    }
    @Test   //Vijaya
    void verifyLastNameFieldErrorMessage() {
       // verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement lastNameField = BaseClass.driver.findElement(By.cssSelector("input[id='lastName']"));
        lastNameField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
    }
    @Test  //Vijaya
    void emailIDFieldIsEnabled(){
       // verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement EmailField =  BaseClass.driver.findElement(By.cssSelector("input[id='email']"));
        assertTrue(EmailField.isEnabled());
        assertTrue(EmailField.isDisplayed());
    }
    @Test  //Vijaya
    void verifyEmailIdField() {
       // verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement EmailField = BaseClass.driver.findElement(By.cssSelector("input[id='email']"));
        EmailField.sendKeys("aaass@sdf.com");
        EmailField.submit();
        String actual= EmailField.getAttribute("value");
        assertEquals("aaass@sdf.com",actual,"email is not matching");
    }
    @Test   //Vijaya
    void verifyEmailIDFieldErrorMessage() {
     //   verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement emailIDField = BaseClass.driver.findElement(By.cssSelector("input[id='email']"));
        emailIDField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
    }
    @Test   //Vijaya
    void verifyAddressFieldErrorMessage() {
      //  verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement addressField = BaseClass.driver.findElement(By.id("address"));
        addressField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
    }
    @Test
    void addressFieldIsEnabled(){
      //  verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement addressField =  BaseClass.driver.findElement(By.id("address"));
        assertTrue(addressField.isEnabled());
        assertTrue(addressField.isDisplayed());
    }
    @Test
    void verifyAddressField() {
       // verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement addressField = BaseClass.driver.findElement(By.xpath("//*[@id=\"address\"]"));
        addressField.sendKeys("Monvägen24");
        addressField.submit();
        String actual= addressField.getAttribute("value");
        assertEquals("Monvägen24",actual,"email is not matching");
    }
    @Test
    void countryFieldIsEnabled(){
       // verifyShopButtonNavigateToAllProductsPage();
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement countryField =  BaseClass.driver.findElement(By.xpath("//*[@id=\"country\"]"));
        assertTrue(countryField.isEnabled());
        assertTrue(countryField.isDisplayed());
    }
    @Test
    void verifyCountryField()  {
        //verifyShopButtonNavigateToAllProductsPage();

        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        BaseClass.waitVisibilityOfElementByClassName("btn-warning");

        checkoutButton.click();

        WebElement countryField = BaseClass.driver.findElement(By.xpath("//*[@id=\"country\"]"));
        countryField.sendKeys("Sweden");
        countryField.submit();
       String actual =  countryField.getAttribute("value");
       assertEquals("Sweden", actual,"country name is not same");
    }
    @Test   //Vijaya
    void verifyCountryFieldErrorMessage() {
        //verifyShopButtonNavigateToAllProductsPage();          idag
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement countryField = BaseClass.driver.findElement(By.id("country"));
        countryField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.className("invalid-feedback"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
    }
    @Test
    void cityFieldIsEnabled(){
      //  verifyShopButtonNavigateToAllProductsPage();          idag
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement cityField =  BaseClass.driver.findElement(By.xpath("//*[@id=\"city\"]"));
        assertTrue(cityField.isEnabled());
        assertTrue(cityField.isDisplayed());
    }
    @Test
    void verifyCityField() {
        //verifyShopButtonNavigateToAllProductsPage();    idag
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        BaseClass.waitVisibilityOfElementByClassName("btn-warning");
        checkoutButton.isDisplayed();
        checkoutButton.click();
        WebElement cityField = BaseClass.driver.findElement(By.id("city"));
        cityField.sendKeys("Eskilstuna");
        cityField.submit();
        String actual = cityField.getAttribute("value");
        assertEquals("Eskilstuna", actual,"City name is not same");
    }

    @Test
    void zipCodeFieldIsEnabled(){

        WebElement checkoutButton = BaseClass.driver.findElement(By.cssSelector("a.btn-warning"));

        BaseClass.waitUntilElementIsClickableCSS("a.btn-warning");
        BaseClass.javaScriptClick(checkoutButton);

        WebElement zipCodeField =  BaseClass.driver.findElement(By.cssSelector("input[id='zip']"));
        BaseClass.scrollToElement(zipCodeField);

        assertTrue(zipCodeField.isEnabled());
        assertTrue(zipCodeField.isDisplayed());
    }


    @Test
    void verifyZipCodeField() {
       // verifyShopButtonNavigateToAllProductsPage();  idag
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        BaseClass.waitVisibilityOfElementByClassName("btn-warning");
        checkoutButton.click();
        WebElement zipCodeField = BaseClass.driver.findElement(By.id("zip"));
        zipCodeField.sendKeys("12345");
        zipCodeField.submit();
        String actual = zipCodeField.getAttribute("value");
        assertEquals("12345",actual,"Zip code does not match");
    }

    @Test //Emma
    void verifyCreditCheckbox(){
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        BaseClass.waitVisibilityOfElementByClassName("btn-warning");
        checkoutButton.click();
        BaseClass.pageLoadWait(5000);
        WebElement creditCheckbox = BaseClass.driver.findElement(By.id("credit"));

        BaseClass.scrollToElement(creditCheckbox);

        creditCheckbox.click();
        assertTrue(creditCheckbox.isEnabled());
        assertTrue(creditCheckbox.isDisplayed());
        assertTrue(creditCheckbox.isSelected());
    }

    @Test //Emma
    void verifyDebitCardCheckbox() {

        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        BaseClass.waitVisibilityOfElementByClassName("btn-warning");

        checkoutButton.click(); //element click intercepted: Element is not clickable at point
        BaseClass.waitVisibilityOfElementByCss("input[id='debit']");
        WebElement debitCheckbox = BaseClass.driver.findElement(By.cssSelector("input[id='debit']"));

        BaseClass.scrollToElement(debitCheckbox);

        debitCheckbox.click();
        assertTrue(debitCheckbox.isEnabled());
        assertTrue(debitCheckbox.isDisplayed());
        assertTrue(debitCheckbox.isSelected());
    }

    @Test //Emma
    void verifyPayPalCheckbox() throws InterruptedException {

        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement paypalCheckbox = BaseClass.driver.findElement(By.id("paypal"));
        Thread.sleep(5000);

        int deltaY = paypalCheckbox.getRect().y;
        new Actions(BaseClass.driver)
                .scrollByAmount(0, deltaY)
                .perform();

        paypalCheckbox.click();
        assertTrue(paypalCheckbox.isEnabled());
        assertTrue(paypalCheckbox.isDisplayed());
        assertTrue(paypalCheckbox.isSelected());
    }

    @Test //Emma
    void verifyWritingInNameOfCardField() {
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        nameOfCardField.sendKeys("Name");
        nameOfCardField.submit();
        String val = nameOfCardField.getAttribute("value");
        assertEquals("Name", val, "Text does not match");
    }

    @Test //Emma
    void checkNameOnCardFieldIsEnabled(){
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        assertTrue(nameOfCardField.isEnabled());
        assertTrue(nameOfCardField.isDisplayed());
    }

    @Test //Emma
    void verifyErrorMessageInNameOfCardField(){
        WebElement checkoutButton = BaseClass.driver.findElement(By.className("btn-warning"));
        checkoutButton.click();
        WebElement nameOfCardField = BaseClass.driver.findElement(By.id("cc-name"));
        nameOfCardField.submit();
        WebElement errorMessage = BaseClass.driver.findElement(By.cssSelector("div[class='invalid-feedback']"));
        boolean errorMessageText = errorMessage.isDisplayed();
        assertTrue(errorMessageText,"Error message is not visible");
    }

    @AfterAll
   static void afterTest() {

       BaseClass.driver.quit();
    }

}
