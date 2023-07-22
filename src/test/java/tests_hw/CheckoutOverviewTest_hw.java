package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.CheckoutCompletePage_hw;
import pages_hw.CheckoutOverviewPage_hw;
import pages_hw.LoginPage_hw;
import utils.configuration.ReadProperties;

public class CheckoutOverviewTest_hw extends BaseTest_hw {
    @Test
    public void successLoginTest() {
        driver.get(ReadProperties.getUrl());

        LoginPage_hw loginPage_hw = new LoginPage_hw(driver);
        loginPage_hw.setEmail(ReadProperties.username());
        loginPage_hw.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage_hw.getLogInButton().click();
        Assert.assertTrue(new CheckoutCompletePage_hw(driver).isPageOpened());
    }

}