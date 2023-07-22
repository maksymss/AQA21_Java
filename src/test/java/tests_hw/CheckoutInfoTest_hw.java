package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.CheckoutInfoPage_hw;
import pages_hw.CheckoutOverviewPage_hw;
import pages_hw.LoginPage_hw;
import utils.configuration.ReadProperties;

public class CheckoutInfoTest_hw extends BaseTest_hw {
    @Test
    public void successCheckoutOverviewTest() {
        CheckoutOverviewPage_hw checkoutOverviewPage_hw = new CheckoutOverviewPage_hw(driver);
        checkoutOverviewPage_hw.getHeaderCheckoutOverview().isDisplayed();
        checkoutOverviewPage_hw.getFinishCheckoutButton().click();
        Assert.assertTrue(new CheckoutOverviewPage_hw(driver).isPageOpened());
    }
}