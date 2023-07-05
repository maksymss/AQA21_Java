import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkSmokeTest {
protected WebDriver driver;

@BeforeMethod
public void setUp() {
    BrowserFactory browserFactory = new BrowserFactory();
    driver = browserFactory.getDriver();
}
    @Test
    public void electricFloorCalc() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement widthInput = driver.findElement(By.id("el_f_width"));
        WebElement lengthInput = driver.findElement(By.id("el_f_lenght"));
        WebElement heatingLossesInput = driver.findElement(By.id("el_f_losses"));
        WebElement calcButton = driver.findElement(By.name("button"));

        WebElement selectWebElementOne = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElementOne);

        selectRoomType.selectByValue("2");
        Thread.sleep(Long.parseLong("2000"));

        WebElement selectWebElementTwo = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElementTwo);

        selectHeatingType.selectByValue("3");
        Thread.sleep(Long.parseLong("2000"));

        widthInput.sendKeys("20");
        lengthInput.sendKeys("20");
        heatingLossesInput.sendKeys("38");
        calcButton.click();

        WebElement floorCablePowResult = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(floorCablePowResult.getAttribute("value"), "21" );

        WebElement specCablePowResult = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specCablePowResult.getAttribute("value"), "0");

    }

    @AfterMethod
    public void tearDown() {
    driver.quit();
    }
}
