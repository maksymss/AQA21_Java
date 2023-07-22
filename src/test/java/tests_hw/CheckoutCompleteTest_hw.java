package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.CheckoutCompletePage_hw;
import pages_hw.LoginPage_hw;
import pages_hw.ProductsPage_hw;
import utils.configuration.ReadProperties;

public class CheckoutCompleteTest_hw extends BaseTest_hw {
    @Test
    public void checkoutCompleteTest() {
        CheckoutCompletePage_hw checkoutCompletePage_hw = new CheckoutCompletePage_hw(driver);
        checkoutCompletePage_hw.getHeaderCheckoutCompleteTitle().isDisplayed();
        checkoutCompletePage_hw.getThanYouMessage().isDisplayed();
        checkoutCompletePage_hw.getBackHomeButton().click();
        Assert.assertTrue(new ProductsPage_hw(driver).isPageOpened());
    }

}