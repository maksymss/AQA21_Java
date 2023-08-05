package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    private final static String pagePath = "/cart.html";

    //Locators description for elements
    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    public WebElement headerShoppingCartTitle;
    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    //Initialization block
    public ShoppingCartPage(WebDriver driver) {
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
