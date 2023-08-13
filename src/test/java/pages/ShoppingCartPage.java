package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    private final static String pagePath = "/cart.html";

    //Locators description for elements
    private final By headerShoppingCartTitleLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By checkoutButtonLocator = By.id("checkout");

    //Initialization block
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    //Unit methods block
    public WebElement getHeaderShoppingCartTitle() {
        return driver.findElement(headerShoppingCartTitleLocator);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }

    public CheckoutInfoPage clickCheckout() {
        getCheckoutButton().click();
        return new CheckoutInfoPage(driver);
    }
}
