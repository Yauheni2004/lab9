package epam.testing;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AtlasBusTest {
    private static WebDriver driver;
    private NewestPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Before
    public void openPages() {
        page = new NewestPage(driver);
        page.open();
        page.setMaxPrice("20");
        page.clickOnCatElement();
    }

    @Test
    public void verifyPricesNotExceedMaxPrice() throws InterruptedException {
        List<Integer> prices = page.getPrices();
        for (Integer price : prices) {
            Assert.assertTrue("Price exceeds the maximum allowed price", price <= 20);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
