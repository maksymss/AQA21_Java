package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest_hw {
    @Test
    public void endToEndTest() {

        new LoginPage(driver)
                .setEmail(ReadProperties.username())
                .setPassword(ReadProperties.password())
                .clickLogIn()
                .clickAddToCart()
                .clickShoppingCart()
                .clickCheckout()
                .getFirstName()
                .geLastName()
                .getZipCode()
                .clickSubmit()
                .clickFinishCheckout()
                .thankYouMessage()
                .clickHomeButton();

        Assert.assertTrue(new ProductsPage(driver).isPageOpened());


    }
}