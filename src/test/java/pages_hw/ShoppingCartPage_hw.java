package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.configuration.ReadProperties;

public class ShoppingCartPage_hw extends BasePage_hw {

    private final static String pagePath = "/cart.html";

    //Locators description for elements
    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    public WebElement headerShoppingCartTitle;
    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    //Initialization block
    public ShoppingCartPage_hw(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("checkout");
    }

    //Unit methods block

}
