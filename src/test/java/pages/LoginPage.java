package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.configuration.ReadProperties;

public class LoginPage extends BasePage {

    //Block describing locators for element
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private static final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");



    //Initialization block

    public LoginPage(WebDriver driver) throws InterruptedException {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }


    //Block unit methods (specific methods)

    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);
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
    public void login(String username, String password) {
        setEmail(username);
        getPswInput().sendKeys(ReadProperties.password());
        getLogInButton().click();
    }

}
