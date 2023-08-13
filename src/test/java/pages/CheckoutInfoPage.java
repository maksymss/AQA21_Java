package pages;

import baseEntities.BasePage;
import models.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends BasePage {

    private final static String pagePath = "/inventory.html";

    //Locators description for elements
    private final By headerCheckoutInfoLocator = By.xpath("//*[@id='header_container']/div[2]/span");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipCodeInputLocator = By.id("postal-code");
    private final By submitLocator = By.id("continue");

    //Initialization block
    public CheckoutInfoPage(WebDriver driver) {
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

    public CheckoutInfoPage getFirstName() {
        getFirstNameInput().sendKeys("Maksym");
        return this;
    }

    public CheckoutInfoPage geLastName() {
        getLastNameInput().sendKeys("Sudarikov");
        return this;
    }

    public CheckoutInfoPage getZipCode() {
        getZipCodeInput().sendKeys("12345");
        return this;
    }

    public CheckoutOverviewPage clickSubmit() {
        getSubmit().click();
        return new CheckoutOverviewPage(driver);
    }

    public void getCheckoutInfo(UserInfo userInfo) {
        getFirstNameInput().sendKeys(userInfo.getFirstName());
        getLastNameInput().sendKeys(userInfo.getLastName());
        getZipCodeInput().sendKeys(userInfo.getZipCode());
        getSubmit().click();
    }


}
