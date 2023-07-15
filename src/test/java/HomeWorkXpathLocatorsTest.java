import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import java.util.concurrent.TimeUnit;

public class HomeWorkXpathLocatorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void HomeWorkXpathLocatorsTest() {
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Absolute xpath * Sorry, Alexander, did that just for practice, please do not fail the HW
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div")).isDisplayed());

        //  All the elements on a page starting from HTML
        driver.findElements(By.xpath("//*"));

        //  Alternative search by tagName
        Assert.assertTrue(driver.findElement(By.xpath("//footer")).isDisplayed());

        //  Alternative parent div and one level down span
        Assert.assertTrue(driver.findElement(By.xpath("//div/span")).isDisplayed());

        //  Alternative parent a and on any level down div
        Assert.assertTrue(driver.findElement(By.xpath("//a//div")).isDisplayed());

        //  Search for the element with tag div that has attribute id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        //  Search for the element that has attribute class with value inventory_item_name
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='inventory_item_name']")).isDisplayed());

        //  Search for the element that has attribute class with value and attribute style with value
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='bm-burger-button' and @style='z-index: 1000;']")).isDisplayed());

        //  Search for the element that starts with
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@class, 'bm')]")).isDisplayed());

        //  Search for the element which attribute value contains substring
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@style, 'sition')]")).isDisplayed());

        //  Search for the element in which text value contains equal sign | Two options:
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()= 'Sauce Labs Backpack']")).isDisplayed());
        // First option works more accurate!!!
        //Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        //  Search for the element in which text value contains substring
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]")).isDisplayed());

        //  Search element by index
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item']/div[1]")).isDisplayed());
    }

    @Test
    public void HomeWorkAxesXPathTest() {
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //  Search for a parent of the element with tag button
        Assert.assertTrue(driver.findElement(By.xpath("//button/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button/parent::div")).isDisplayed());

        //  Search for all ancestors with of the element with a tag span
        Assert.assertTrue(driver.findElement(By.xpath("//span/ancestor::div")).isDisplayed());

        //  Using child - all child elements with tag a from div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::button")).isDisplayed());

        //  Using child - all child elements with tag div
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::div")).isDisplayed());

        // Selects everything in the document after closing tag of current nod
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/following::span")).isDisplayed());

        //  Using following -sibling - Selects all nods of the same level after the current nod.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='menu_button_container']/following-sibling::div")).isDisplayed());

        // Using preceding - Selects all nods, that are appear before the current not in a document
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //  Using preceding-sibling - Selects all nods of the same level up to the current nod
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
