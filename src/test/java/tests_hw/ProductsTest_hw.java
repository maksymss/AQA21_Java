package tests_hw;

import baseEntities_hw.BaseTest_hw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_hw.LoginPage_hw;
import pages_hw.ProductsPage_hw;
import pages_hw.ShoppingCartPage_hw;
import utils.configuration.ReadProperties;

public class ProductsTest_hw extends BaseTest_hw {

    @Test
    public void successAddToCartTest() {

        ProductsPage_hw productsPage_hw = new ProductsPage_hw(driver);
        productsPage_hw.getHeaderTitle().isDisplayed();
        productsPage_hw.getAddToCartLocator().click();
        productsPage_hw.getShoppingCartLocator().click();
        Assert.assertTrue(new ShoppingCartPage_hw(driver).isPageOpened());
    }

}