package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage_hw {
    private final static String pagePath = "/inventory.html";

    //Locators description for elements
    private final By headerTitleLocator = By.className("title");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-bike-light");
    private final By shoppingCartLocator = By.id("shopping_cart_container");

    //Initialization block
    public ProductsPage(WebDriver driver) {
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

    public WebElement getAddToCart() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getShoppingCart() {
        return driver.findElement(shoppingCartLocator);
    }

    //Complex block methods
    public ProductsPage clickAddToCart() {
        getAddToCart().click();
        return this;
    }

    public ShoppingCartPage clickShoppingCart() {
        getShoppingCart().click();
        return new ShoppingCartPage(driver);
    }
}