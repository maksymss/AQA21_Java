import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import java.util.concurrent.TimeUnit;

public class HomeWorkBasicLocatorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void HomeWorkBasicLocatorsTest_1() {
        driver.get(ReadProperties.getUrl());

        // Six locators used, some of them I used twice for the test structure.

        //Find element by ID
        driver.findElement(By.id("username")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("loginButton")).click();

        //Find element by name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Find element by Tag
        driver.findElement(By.tagName("label")).isDisplayed();

        //Find element by LinkText
        driver.findElement(By.linkText("Forgot password?")).click();

        //Find element by ClassName
        driver.findElement(By.className("ForgotPasswordForm")).isDisplayed();

        //Find element by PartialLinkText
        driver.findElement(By.partialLinkText("Priv")).isDisplayed();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
