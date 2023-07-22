package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class CheckoutCompletePage_hw extends BasePage_hw {

    private final static String pagePath = "/checkout-complete.html";

    //Locators description for elements
    private final By headerCheckoutCompleteTitleLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By thanYouMessageLocator = By.className("complete-header");
    private final By backHomeButtonLocator = By.id("back-to-products");

    //Initialization block
    public CheckoutCompletePage_hw(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }

    //Unit methods block
    public WebElement getHeaderCheckoutCompleteTitle() {
        return driver.findElement(headerCheckoutCompleteTitleLocator);
    }

    public WebElement getThanYouMessage() {
        return driver.findElement(thanYouMessageLocator);
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }
}
