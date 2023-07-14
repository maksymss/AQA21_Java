import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class CssSelectorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get("file:/Users/maksymsudarikov/IdeaProjects/AQA21_Java/src/test/resources/index.html");

        //Search by id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());
        //alternative
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());

        //Search by class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        //Alternative
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());

        //  Search by several values in class attribute
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        // Search by tag name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
        //   alternative
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        //  Search by tag and class attribute
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        // Поиск по id и значению из аттрибута class
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());

        //  Search for all elements with tag h1 or p
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        //  Search for all elements with tag size p who has parent with tag div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        //  Search for all elements with tag p, that come right after  the element with tag ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        //  Search for all elements with tag div that are sibling to element with tag p
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p ~ div")).size());

        //  Search all elements that contain attribute title
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title]")).size());

        //  Search for all elements with attribute style with particular value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        //  Search for all elements with attribute id that ends with some value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        //  Search for all elements with attribute id that begins with some value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        //  Search for all elements with attribute id with value that begins with some word
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        //  Search for all elements that have attribute title with the value that contains the full word
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        //  Search for all elements that have attribute title with the value containing some text.
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

        //  Search for all disabled elements
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        //  Search for all enabled elements
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        //  Search for all checked elements
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        //  Search for all elements wit empty body
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        //  Search for element with tag p that is first child element
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        //  Search for element with tag p that is last child element
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        //  Search for element with tag p that is n-th child element
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());



    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
