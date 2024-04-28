package epam.testing;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteTest {
    private static WebDriver driver;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private TicketPage productPage;
    private String searchProduct;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Before
    public void openPages() throws InterruptedException {
        mainPage = new MainPage(driver);
        searchProduct = "Мини-фигурки Genshin Impact (8 см)";
        mainPage.open();
        mainPage.search(searchProduct);

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnProduct();

        productPage = new TicketPage(driver);
    }

    @Test
    public void shouldBeRedirectedToProductsPage() throws InterruptedException {
        String productName = productPage.getProductName();
        Assert.assertEquals(searchProduct, productName);
    }

    @Test
    public void shouldBeRedirectedToTheSameProductPage() throws InterruptedException {
        String href = searchResultPage.getHref();
        Assert.assertEquals(href, driver.getCurrentUrl());
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
