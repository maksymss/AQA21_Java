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
        loginPage_hw.passwordInput.sendKeys(ReadProperties.password());
        loginPage_hw.logInButton.click();
    }

    @Test(dependsOnMethods = "successLoginTest")
    public void successAddToCartTest() {

        productsPage_hw.headerTitle.isDisplayed();
        productsPage_hw.addToCartButton.click();
        productsPage_hw.shoppingCart.click();
    }

    @Test(dependsOnMethods = "successAddToCartTest")
    public void successCheckoutTest() {

        shoppingCartPage_hw.headerShoppingCartTitle.isDisplayed();
        shoppingCartPage_hw.checkoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutTest")
    public void successCheckoutInfoTest() {

        checkoutInfoPage_hw.headerCheckoutInfo.isDisplayed();
        checkoutInfoPage_hw.firstNameInput.sendKeys("Maksym");
        checkoutInfoPage_hw.lastNameInput.sendKeys("Sudarikov");
        checkoutInfoPage_hw.zipCodeInput.sendKeys("11235");
        checkoutInfoPage_hw.submit.click();
    }

    @Test(dependsOnMethods = "successCheckoutInfoTest")
    public void successCheckoutOverviewTest() {

        checkoutOverviewPage_hw.headerCheckoutOverview.isDisplayed();
        checkoutOverviewPage_hw.finishCheckoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutOverviewTest")
    public void checkoutCompleteTest() {

        checkoutCompletePage_hw.headerCheckoutCompleteTitle.isDisplayed();
        checkoutCompletePage_hw.thanYouMessage.isDisplayed();
        checkoutCompletePage_hw.backHomeButton.click();
        Assert.assertTrue(new ProductsPage_hw(driver).isPageOpened());
    }
}
