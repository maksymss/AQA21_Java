package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.configuration.ReadProperties;

import java.time.Duration;

public class LoginPage extends BasePage {

    //Block describing locators for element
    @FindBy (id = "name")
    public WebElement  emailInput;
    @FindBy (id = "password")
    public WebElement pswInput;
    @FindBy (id = "button_primary")
    public WebElement  logInButton;
    @FindBy (className = "error-text")
    public WebElement errorText;
    @FindBy (className = "loginpage-message")
    public WebElement errorFieldText;



    //Initialization block
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("button_primary");
    }


    //Block unit methods (specific methods)



    //Block complex methods
    public void login(String username, String password) {
        emailInput.sendKeys(username);
        pswInput.sendKeys(ReadProperties.password());
        logInButton.click();
    }

}
