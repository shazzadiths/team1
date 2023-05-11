import org.junit.jupiter.api.BeforeAll;


public class Selenium {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    @BeforeAll
    static void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssrikris\\Anjhana\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        actions = new Actions(driver);
        String pageUrl = "https://webshop-agil-testautomatiserare.netlify.app/";
        driver.get(pageUrl);

    }

    @Test
    void verifyTitle() {
        String websiteHeading = driver.getTitle();
        String pageTitle = "The Shop";
        assertNotEquals(pageTitle, websiteHeading, "title not matching...");
    }

}