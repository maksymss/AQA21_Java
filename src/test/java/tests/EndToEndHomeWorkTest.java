package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest {

    @Test(description = "Login to the testing website test")
    @Description("Login to the testing website flow")
    @Severity(SeverityLevel.CRITICAL)
    public void successLoginTest() {

        loginPage_.setEmail(ReadProperties.username());
        loginPage_.passwordInput.sendKeys(ReadProperties.password());
        loginPage_.logInButton.click();
    }

    @Test(dependsOnMethods = "successLoginTest", description = "Adding product to shopping cart test")
    @Description("Adding product to shopping cart flow")
    @Severity(SeverityLevel.CRITICAL)
    public void successAddToCartTest() {

        productsPage_.headerTitle.isDisplayed();
        productsPage_.addToCartButton.click();
        productsPage_.shoppingCart.click();
    }

    @Test(dependsOnMethods = "successAddToCartTest", description = "Checkout product test")
    @Description("Checkout product flow")
    @Severity(SeverityLevel.CRITICAL)
    public void successCheckoutTest() {

        shoppingCartPage_.headerShoppingCartTitle.isDisplayed();
        shoppingCartPage_.checkoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutTest", description = "Client's credentials test")
    @Description("Client's credentials flow")
    @Severity(SeverityLevel.TRIVIAL)
    public void successCheckoutInfoTest() {

        checkoutInfoPage_.headerCheckoutInfo.isDisplayed();
        checkoutInfoPage_.firstNameInput.sendKeys("Maksym");
        checkoutInfoPage_.lastNameInput.sendKeys("Sudarikov");
        checkoutInfoPage_.zipCodeInput.sendKeys("11235");
        checkoutInfoPage_.submit.click();
    }

    @Test(dependsOnMethods = "successCheckoutInfoTest", description = "Purchase overview test")
    @Description("Purchase overview flow")
    @Severity(SeverityLevel.MINOR)
    public void successCheckoutOverviewTest() {

        checkoutOverviewPage_.headerCheckoutOverview.isDisplayed();
        checkoutOverviewPage_.finishCheckoutButton.click();
    }

    @Test(dependsOnMethods = "successCheckoutOverviewTest", description = "Complete checkout and return to the product page test")
    @Description("Complete checkout and return to the product page flow")
    @Severity(SeverityLevel.MINOR)
    public void checkoutCompleteTest() {

        checkoutCompletePage_.headerCheckoutCompleteTitle.isDisplayed();
        checkoutCompletePage_.thanYouMessage.isDisplayed();
        checkoutCompletePage_.backHomeButton.click();
        Assert.assertTrue(new ProductsPage(driver).isPageOpened() == false);
    }
}
