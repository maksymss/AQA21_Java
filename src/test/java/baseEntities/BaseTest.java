package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import steps.LoginStep;
import utils.configuration.ReadProperties;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage_;
    protected ProductsPage productsPage_;
    protected ShoppingCartPage shoppingCartPage_;
    protected CheckoutInfoPage checkoutInfoPage_;
    protected CheckoutOverviewPage checkoutOverviewPage_;
    protected CheckoutCompletePage checkoutCompletePage_;

    @BeforeClass
    public void setUp(ITestContext iTestContext ) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        //driver.get(ReadProperties.getUrl());

        loginPage_ = new LoginPage(driver);
        productsPage_ = new ProductsPage(driver);
        shoppingCartPage_ = new ShoppingCartPage(driver);
        checkoutInfoPage_ = new CheckoutInfoPage(driver);
        checkoutOverviewPage_ = new CheckoutOverviewPage(driver);
        checkoutCompletePage_ = new CheckoutCompletePage(driver);

        driver.get(ReadProperties.getUrl());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
