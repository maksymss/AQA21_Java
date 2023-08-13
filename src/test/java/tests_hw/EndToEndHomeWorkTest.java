package tests_hw;

import baseEntities.BaseTest;
import helpers.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.configuration.ReadProperties;

public class EndToEndHomeWorkTest extends BaseTest {
    Logger logger = LogManager.getLogger(EndToEndHomeWorkTest.class);

    @Test
    public void endToEndTest() {

        loginPage_.login(ReadProperties.username(), ReadProperties.password());
        productsPage_.clickAddToCart();
        productsPage_.clickShoppingCart();
        shoppingCartPage_.clickCheckout();
        checkoutInfoPage_.getCheckoutInfo(DataHelper.getUserInfo());
        checkoutOverviewPage_.clickFinishCheckout();
        checkoutCompletePage_.getThanYouMessage();
        checkoutCompletePage_.clickHomeButton();

        Assert.assertTrue(new ProductsPage(driver).isPageOpened());

        logger.info("Message");

    }

}