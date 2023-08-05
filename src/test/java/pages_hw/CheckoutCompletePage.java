package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage_hw {

    private final static String pagePath = "/checkout-complete.html";

    //Locators description for elements
    private final By headerCheckoutCompleteTitleLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By thanYouMessageLocator = By.className("complete-header");
    private final By backHomeButtonLocator = By.id("back-to-products");

    //Initialization block
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
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
    public CheckoutCompletePage thankYouMessage() {
        getThanYouMessage().isDisplayed();
        return this;
    }
    public CheckoutCompletePage clickHomeButton() {
        getBackHomeButton().click();
        return this;
    }
    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }
}
