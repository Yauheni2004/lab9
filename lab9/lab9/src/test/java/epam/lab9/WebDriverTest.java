package epam.lab9;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        String href = linkToProductPage.getAttribute("href");
        driver.get(href);

        Thread.sleep(2000);
        driver.quit();
    }
}
