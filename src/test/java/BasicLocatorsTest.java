import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import java.util.List;

public class BasicLocatorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void basicLocatorsTest_1() {
        driver.get(ReadProperties.getUrl());

        //Find element by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        //Find element by name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        //Find element by Tag
        driver.findElement(By.tagName("button")).click();

    }

    @Test
    public void basicLocatorsTest_2() {
        driver.get(ReadProperties.getUrl());

        //Find element by LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        //Find element by ClassName
        driver.findElement(By.name("forgot_passwordpage-request-cancel")).click();

        //Find element by PartialLinkText
        driver.findElement(By.partialLinkText("your password?")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
