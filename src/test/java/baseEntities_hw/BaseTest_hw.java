package baseEntities_hw;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages_hw.*;
import utils.configuration.ReadProperties;

public class BaseTest_hw {
    protected WebDriver driver;
    protected LoginPage_hw loginPage_hw;
    protected ProductsPage_hw productsPage_hw;
    protected ShoppingCartPage_hw shoppingCartPage_hw;
    protected CheckoutInfoPage_hw checkoutInfoPage_hw;
    protected CheckoutOverviewPage_hw checkoutOverviewPage_hw;
    protected CheckoutCompletePage_hw checkoutCompletePage_hw;

    @BeforeClass
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginPage_hw = new LoginPage_hw(driver);
        productsPage_hw = new ProductsPage_hw(driver);
        shoppingCartPage_hw = new ShoppingCartPage_hw(driver);
        checkoutInfoPage_hw = new CheckoutInfoPage_hw(driver);
        checkoutOverviewPage_hw = new CheckoutOverviewPage_hw(driver);
        checkoutCompletePage_hw = new CheckoutCompletePage_hw(driver);

        driver.get(ReadProperties.getUrl());

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
