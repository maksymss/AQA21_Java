package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.configuration.ReadProperties;

public class ProductsPage_hw extends BasePage_hw {
    private final static String pagePath = "/inventory.html";

    //Locators description for elements
    @FindBy (className = "title")
    public WebElement headerTitle;
    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addToCartButton;
    @FindBy (id = "shopping_cart_container")
    public WebElement shoppingCart;

    //Initialization block
    public ProductsPage_hw(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.className("title");
    }

    //Unit methods block


    //Complex block methods

}
