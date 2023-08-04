package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.configuration.ReadProperties;

public class CheckoutCompletePage_hw extends BasePage_hw {

    private final static String pagePath = "/checkout-complete.html";

    //Locators description for elements
    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    public WebElement headerCheckoutCompleteTitle;
    @FindBy (className = "complete-header")
    public WebElement thanYouMessage;
    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    //Initialization block
    public CheckoutCompletePage_hw(WebDriver driver) {
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
