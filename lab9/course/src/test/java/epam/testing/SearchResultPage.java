package epam.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@class='product-title']/a")
    private WebElement linkToProductPage;

    private String href = "";

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProduct() throws InterruptedException {
        String href = linkToProductPage.getAttribute("href");
        this.href = href;
        driver.get(href);
    }

    public String getHref() {
        return href;
    }
}
