package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class LoginPage extends BasePage_hw {

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

    public LoginPage setPassword(String password) {
        getPasswordInput().sendKeys(password);
        return this;
    }

    public ProductsPage clickLogIn() {
        getLogInButton().click();
        return new ProductsPage(driver);
    }


    //Complex block methods
    public void login() {
        setEmail(ReadProperties.username());
        getPasswordInput().sendKeys(ReadProperties.password());
        getLogInButton().click();
    }

    }

