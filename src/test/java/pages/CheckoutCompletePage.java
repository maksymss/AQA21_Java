package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    private final static String pagePath = "/checkout-complete.html";

    //Locators description for elements
    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    public WebElement headerCheckoutCompleteTitle;
    @FindBy (className = "complete-header")
    public WebElement thanYouMessage;
    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    //Initialization block
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return By.id("back-to-products");
    }

    //Unit methods block

}
