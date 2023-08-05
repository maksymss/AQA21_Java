package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utils.configuration.ReadProperties;

public class BaseTest_hw {
    protected WebDriver driver;
    protected LoginPage loginPage_;
    protected ProductsPage productsPage_;
    protected ShoppingCartPage shoppingCartPage_;
    protected CheckoutInfoPage checkoutInfoPage_;
    protected CheckoutOverviewPage checkoutOverviewPage_;
    protected CheckoutCompletePage checkoutCompletePage_;

    @BeforeClass
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginPage_ = new LoginPage(driver);
        productsPage_ = new ProductsPage(driver);
        shoppingCartPage_ = new ShoppingCartPage(driver);
        checkoutInfoPage_ = new CheckoutInfoPage(driver);
        checkoutOverviewPage_ = new CheckoutOverviewPage(driver);
        checkoutCompletePage_ = new CheckoutCompletePage(driver);

        driver.get(ReadProperties.getUrl());

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
