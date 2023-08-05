package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage_hw {

    private final static String pagePath = "/checkout-step-two.html";

    //Locators description for elements
    private final By headerCheckoutOverviewLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By finishCheckoutButtonLocator = By.id("finish");

    //Initialization block
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return finishCheckoutButtonLocator;
    }

    //Unit methods block
    public WebElement getHeaderCheckoutOverview() {
        return driver.findElement(headerCheckoutOverviewLocator);
    }

    public WebElement getFinishCheckoutButton() {
        return driver.findElement(finishCheckoutButtonLocator);
    }

    public CheckoutCompletePage clickFinishCheckout() {
        getFinishCheckoutButton().click();
        return new CheckoutCompletePage(driver);
    }
}
