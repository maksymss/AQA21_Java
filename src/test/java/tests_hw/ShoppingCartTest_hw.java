package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.CheckoutInfoPage_hw;
import pages_hw.LoginPage_hw;
import pages_hw.ShoppingCartPage_hw;
import utils.configuration.ReadProperties;

public class ShoppingCartTest_hw extends BaseTest_hw {
    @Test
    public void successCheckoutTest() {

        ShoppingCartPage_hw shoppingCartPage_hw = new ShoppingCartPage_hw(driver);
        shoppingCartPage_hw.getHeaderShoppingCartTitle().isDisplayed();
        shoppingCartPage_hw.getCheckoutButton().click();
        Assert.assertTrue(new CheckoutInfoPage_hw(driver).isPageOpened());
    }
}