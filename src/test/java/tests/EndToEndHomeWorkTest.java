package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest {

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

        shoppingCartPage_hw.headerShoppingCartTitle.isDisplayed();
        shoppingCartPage_hw.checkoutButton.click();
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

    @Test
    public void builderTest() {
        Project project = new Project.Builder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .withAddProduct(true)
                .withShoppingCart(true)
                .withCheckout(true)
                .withFirstName("Maksym")
                .withLastName("Sudarikov")
                .withZipCode("12345")

                .build();

    }
}
