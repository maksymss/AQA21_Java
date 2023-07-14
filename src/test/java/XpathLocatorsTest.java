import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class XpathLocatorsTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicXpathLocatorsTest() {
        driver.get(ReadProperties.getUrl());

        // Absolute xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        //  All the elements on a page starting from HTML
        driver.findElements(By.xpath("//*"));

        //  Alternative search by tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //  Alternative parent div and one level down p1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        //  Alternative parent div and on any level down div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        //  Search for the element with tag div that has attribute id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        //  Search for the element that has attribute id with value top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class= 'noSel newsletter']")).isDisplayed());

        //  Search for the element that has attribute method with value and attribute target with value
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang='it' and @title='Hello beautiful']")).isDisplayed());

        //  Search for the element that starts with
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@title, 'Hello')]")).isDisplayed());

        //  Search for the element which attribute value contains substring
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@title, 'Hello')]")).isDisplayed());

        //  Search for the element in which text value contains equal sign | Two options:
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Name:']")).isDisplayed());
        // First option works more accurate!!!
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        //  Search for the element in which text value contains substring
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        //  Search element by index
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());
    }

    @Test
    public void axesXPathTest() {
        driver.get(ReadProperties.getUrl());

        //  Search for a parent of the element with tag h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        //  Search for all ancestors with of the element with a tag h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        //  Using child - all child elements with tag a from div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        // Selects everything in the document after closing tag of current nod
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //  Using following -sibling - Selects all nods of the same level after the current nod.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        // Using preceding - Selects all nods, that are appear before the current not in a document
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //  Using preceding-sibling - Selects all nods of the same level up to the current nod
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }

}
