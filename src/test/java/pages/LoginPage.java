package pages;

import baseEntities.BasePage;
import helpers.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class LoginPage extends BasePage {

    //Locators description for elements
    private final By emailInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    //Initialization block

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }
    //Unit methods block

    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }


    //Complex block methods
    public void login(String username, String password) {
        setEmail(ReadProperties.username());
        getPasswordInput().sendKeys(ReadProperties.password());
        getLogInButton().click();
    }


}

