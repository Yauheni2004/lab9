package epam.lab9;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertNotNull;

public class WebDriverUnitTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchAndNavigateToProductPage() throws InterruptedException {
        driver.get("https://atlas.by/");

        By searchInputSelector = By.xpath("//input[@name='q']");
        By searchButtonSelector = By.xpath("//button[@type='submit']");

        WebElement searchInput = driver.findElement(searchInputSelector);
        WebElement searchButton = driver.findElement(searchButtonSelector);

        searchInput.sendKeys("гриппомикс");
        searchButton.click();

        Thread.sleep(5000);

        By linkToProductPageSelector = By.xpath("//a[contains(@href, 'product')]");
        WebElement linkToProductPage = driver.findElement(linkToProductPageSelector);
        assertNotNull(linkToProductPage);

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);

        Thread.sleep(2000);
        // Example assertion, you may need to adjust it according to your requirements
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
