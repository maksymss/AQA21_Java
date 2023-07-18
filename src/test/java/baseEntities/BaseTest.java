package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginStep;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
