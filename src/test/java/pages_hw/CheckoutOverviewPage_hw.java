package pages_hw;

import baseEntities_hw.BasePage_hw;
import baseEntities_hw.BaseTest_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.configuration.ReadProperties;

public class CheckoutOverviewPage_hw extends BasePage_hw {

    private final static String pagePath = "/checkout-step-two.html";

    //Locators description for elements
    @FindBy (xpath = "//*[@id='header_container']/div[2]/span")
    public WebElement headerCheckoutOverview;
    @FindBy (id = "finish")
    public WebElement finishCheckoutButton;

    //Initialization block
    public CheckoutOverviewPage_hw(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return By.id("finish");
    }

    //Unit methods block

}
