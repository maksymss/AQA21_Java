package pages;

import baseEntities.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.configuration.ReadProperties.password;

public class LoginPage extends BasePage_hw {

    //Locators description for elements
    @FindBy (id = "user-name")
    public WebElement emailInput;
    @FindBy (id = "password")
    public WebElement passwordInput;
    @FindBy (id = "login-button")
    public WebElement logInButton;

    //Initialization block

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("login-button");
    }
    //Unit methods block


    public void setEmail(String value) {
        emailInput.sendKeys(value);
    }


    //Complex block methods
    public void login() {
        emailInput.sendKeys(password());
        passwordInput.sendKeys(password());
        logInButton.click();
    }


}
