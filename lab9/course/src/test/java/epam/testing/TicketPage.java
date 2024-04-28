package epam.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/h1")
    private WebElement product;

    public TicketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() throws InterruptedException {
        return product.getText();
    }
}