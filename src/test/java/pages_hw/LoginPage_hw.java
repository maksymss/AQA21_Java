package pages_hw;

import baseEntities_hw.BasePage_hw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.configuration.ReadProperties;

import static utils.configuration.ReadProperties.password;
import static utils.configuration.ReadProperties.username;

public class LoginPage_hw extends BasePage_hw {

    //Locators description for elements
    @FindBy (id = "user-name")
    public WebElement emailInput;
    @FindBy (id = "password")
    public WebElement passwordInput;
    @FindBy (id = "login-button")
    public WebElement logInButton;

    //Initialization block

    public LoginPage_hw(WebDriver driver) {
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
