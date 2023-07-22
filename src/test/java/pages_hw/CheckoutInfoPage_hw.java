package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class CheckoutInfoPage_hw extends BasePage_hw {

    private final static String pagePath = "/inventory.html";

    //Locators description for elements
    private final By headerCheckoutInfoLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");
    private final By submitLocator = By.id("continue");

    //Initialization block
    public CheckoutInfoPage_hw(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return submitLocator;
    }
    //Unit methods block
    public WebElement getHeaderCheckoutInfo() {
        return driver.findElement(headerCheckoutInfoLocator);
    }
    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }
    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }
    public WebElement getZipCodeInput() {
        return driver.findElement(zipCodeInputLocator);
    }
    public WebElement getSubmit() {
        return driver.findElement(submitLocator);
    }
}
