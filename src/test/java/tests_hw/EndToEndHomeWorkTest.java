package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest_hw {

    @Test
    public void successLoginTest() {

        loginPage_hw.setEmail(ReadProperties.username());
        loginPage_hw.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage_hw.getLogInButton().click();
        Assert.assertTrue(new ProductsPage_hw(driver).isPageOpened());
    }
    @Test(dependsOnMethods = "successLoginTest")
    public void successAddToCartTest() {
        productsPage_hw.getHeaderTitle().isDisplayed();
        productsPage_hw.getAddToCartLocator().click();
        productsPage_hw.getShoppingCartLocator().click();
        Assert.assertTrue(new ShoppingCartPage_hw(driver).isPageOpened());
    }
    @Test(dependsOnMethods = "successAddToCartTest")
    public void successCheckoutTest() {

        shoppingCartPage_hw.getHeaderShoppingCartTitle().isDisplayed();
        shoppingCartPage_hw.getCheckoutButton().click();
        Assert.assertTrue(new CheckoutInfoPage_hw(driver).isPageOpened());
    }
    @Test(dependsOnMethods = "successCheckoutTest")
    public void successCheckoutInfoTest() {

        checkoutInfoPage_hw.getHeaderCheckoutInfo().isDisplayed();
        checkoutInfoPage_hw.getFirstNameInput().sendKeys("Maksym");
        checkoutInfoPage_hw.getLastNameInput().sendKeys("Sudarikov");
        checkoutInfoPage_hw.getZipCodeInput().sendKeys("11235");
        checkoutInfoPage_hw.getSubmit().click();
        Assert.assertTrue(new CheckoutOverviewPage_hw(driver).isPageOpened());
    }
    @Test(dependsOnMethods = "successCheckoutInfoTest")
    public void successCheckoutOverviewTest() {

        checkoutOverviewPage_hw.getHeaderCheckoutOverview().isDisplayed();
        checkoutOverviewPage_hw.getFinishCheckoutButton().click();
        Assert.assertTrue(new CheckoutCompletePage_hw(driver).isPageOpened());
    }
    @Test(dependsOnMethods = "successCheckoutOverviewTest")
    public void checkoutCompleteTest() {

        checkoutCompletePage_hw.getHeaderCheckoutCompleteTitle().isDisplayed();
        checkoutCompletePage_hw.getThanYouMessage().isDisplayed();
        checkoutCompletePage_hw.getBackHomeButton().click();
        Assert.assertTrue(new ProductsPage_hw(driver).isPageOpened());
    }
}
