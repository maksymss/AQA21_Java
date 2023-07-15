import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import java.util.concurrent.TimeUnit;

public class HomeWorkCssSelectorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    //I've tried several many times to find all commented elements but, unfortunately, could not succeed
    //I'd like to discuss it during the class
    @Test
    public void HomeWorkCssSelectorsTest() {
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Search by id
        Assert.assertTrue(driver.findElement(By.cssSelector("#root")).isDisplayed());
        //alternative
        Assert.assertTrue(driver.findElement(By.id("root")).isDisplayed());

        //Search by class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".footer")).isDisplayed());
        //Alternative
        Assert.assertTrue(driver.findElement(By.className("footer")).isDisplayed());

        //  Search by several values in class attribute *No such combination found on the testing website
        //Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        // Search by tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("select")).isDisplayed());
        //   alternative
        Assert.assertTrue(driver.findElement(By.tagName("select")).isDisplayed());

        //  Search by tag and class attribute
        Assert.assertTrue(driver.findElement(By.cssSelector("div.app_logo")).isDisplayed());

        // Поиск по id и значению из аттрибута class
        //Assert.assertEquals(6, driver.findElements(By.cssSelector("btn btn_primary btn_small btn_inventory")).size());

        //  Search for all elements with tag option or span
        Assert.assertEquals(7, driver.findElements(By.cssSelector("option, span")).size());

        //  Search for all elements with tag a who has parent with tag div
        Assert.assertEquals(13, driver.findElements(By.cssSelector("div > a")).size());

        //  Search for all elements with tag div, that come right after  the element with tag button
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div + button")).size());

        //  Search for all elements with tag div that are sibling to element with tag button
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div ~ button")).size());

        //  Search all elements that contain attribute data-test
        Assert.assertEquals(7, driver.findElements(By.cssSelector("[data-test]")).size());

        //  Search for all elements with attribute style with particular value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='height: 100%;']")).size());

        //  Search for all elements with attribute id that ends with some value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ot']")).size());

        //  Search for all elements with attribute id that begins with some value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id ^=ro]")).size());

        //  Search for all elements with attribute id with value that begins with some word
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=root]")).size());

        //  Search for all elements that have attribute title with the value that contains the full word
        //Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        //  Search for all elements that have attribute data-test with the value containing some text.
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[data-test*=product]")).size());

        //  Search for all disabled elements * On the testing website no disabled elements found
        //Assert.assertEquals(0, driver.findElements(By.cssSelector(":disabled")).size());

        //  Search for all enabled elements
        Assert.assertEquals(13, driver.findElements(By.cssSelector(":enabled")).size());

        //  Search for all checked elements
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":checked")).size());

        //  Search for all elements wit empty body
        Assert.assertEquals(21, driver.findElements(By.cssSelector(":empty")).size());

        //  Search for element with tag option that is first child element
        Assert.assertEquals(1, driver.findElements(By.cssSelector("option:first-child")).size());

        //  Search for element with tag option that is last child element
        Assert.assertEquals(1, driver.findElements(By.cssSelector("option:last-child")).size());

        //  Search for element with tag option that is n-th child element
        Assert.assertEquals(1, driver.findElements(By.cssSelector("option:nth-child(3)")).size());

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
