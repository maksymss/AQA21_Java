package tests;

import baseEntities.BaseTest_hw;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest_hw {

    @Test
    public void successLoginTest() {

        loginPage_.setEmail(ReadProperties.username());
        loginPage_.passwordInput.sendKeys(ReadProperties.password());
        loginPage_.logInButton.click();
    }

    @Test(dependsOnMethods = "successLoginTest")
    public void successAddToCartTest() {

        productsPage_.headerTitle.isDisplayed();
        productsPage_.addToCartButton.click();
        productsPage_.shoppingCart.click();
    }

    @Test(dependsOnMethods = "successAddToCartTest")
    public void successCheckoutTest() {

        shoppingCartPage_.headerShoppingCartTitle.isDisplayed();
        shoppingCartPage_.checkoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutTest")
    public void successCheckoutInfoTest() {

        checkoutInfoPage_.headerCheckoutInfo.isDisplayed();
        checkoutInfoPage_.firstNameInput.sendKeys("Maksym");
        checkoutInfoPage_.lastNameInput.sendKeys("Sudarikov");
        checkoutInfoPage_.zipCodeInput.sendKeys("11235");
        checkoutInfoPage_.submit.click();
    }

    @Test(dependsOnMethods = "successCheckoutInfoTest")
    public void successCheckoutOverviewTest() {

        checkoutOverviewPage_.headerCheckoutOverview.isDisplayed();
        checkoutOverviewPage_.finishCheckoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutOverviewTest")
    public void checkoutCompleteTest() {

        checkoutCompletePage_.headerCheckoutCompleteTitle.isDisplayed();
        checkoutCompletePage_.thanYouMessage.isDisplayed();
        checkoutCompletePage_.backHomeButton.click();
        Assert.assertTrue(new ProductsPage(driver).isPageOpened());
    }
}
