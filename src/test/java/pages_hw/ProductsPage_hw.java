package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class ProductsPage_hw extends BasePage_hw {
    private final static String pagePath = "/inventory.html";

    //Locators description for elements
    private final By headerTitleLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-bike-light");
    private final By shoppingCartLocator = By.id("shopping_cart_container");

    //Initialization block
    public ProductsPage_hw(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocator;
    }

    //Unit methods block
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLocator);
    }

    public WebElement getAddToCartLocator() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getShoppingCartLocator() {
        return driver.findElement(shoppingCartLocator);
    }

    //Complex block methods

}
