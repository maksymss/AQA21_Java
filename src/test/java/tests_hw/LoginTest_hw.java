package tests_hw;

import baseEntities_hw.BaseTest_hw;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages_hw.LoginPage_hw;
import pages_hw.ProductsPage_hw;
import utils.configuration.ReadProperties;

public class LoginTest_hw extends BaseTest_hw {
    @Test
    public void successLoginTest() {

        LoginPage_hw loginPage_hw = new LoginPage_hw(driver);
        loginPage_hw.setEmail(ReadProperties.username());
        loginPage_hw.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage_hw.getLogInButton().click();
        Assert.assertTrue(new ProductsPage_hw(driver).isPageOpened());
    }

}