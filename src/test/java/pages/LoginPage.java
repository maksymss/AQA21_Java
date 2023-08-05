package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.configuration.ReadProperties;

import java.time.Duration;

public class LoginPage extends BasePage {

    //Block describing locators for element
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");



    //Initialization block

    public LoginPage(WebDriver driver) {
        super(driver);


    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }


    //Block unit methods (specific methods)

    public WebElement getEmailInput() {
        return waitService.waitForExist(emailInputLocator);
    }

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }

    public WebElement getErrorFieldTextElement() {
        return driver.findElement(errorFieldTextLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }



    //Block complex methods
    public void login(User user) {
        setEmail(user.getEmail());
        getPswInput().sendKeys(user.getPassword());
        getLogInButton().click();
    }

}
