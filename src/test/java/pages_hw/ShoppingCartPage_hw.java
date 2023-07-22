package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class ShoppingCartPage_hw extends BasePage_hw {

    private final static String pagePath = "/cart.html";

    //Locators description for elements
    private final By headerShoppingCartTitleLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By checkoutButtonLocator = By.id("checkout");

    //Initialization block
    public ShoppingCartPage_hw(WebDriver driver) {
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
}
