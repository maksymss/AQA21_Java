import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HWSmokeTestWithAsterisk {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void laminateCalculator() {

        driver.get("https://calc.by/building-calculators/laminate.html");


        WebElement roomLengthInput = driver.findElement(By.id("ln_room_id"));
        WebElement roomWidthInput = driver.findElement(By.id("wd_room_id"));
        WebElement laminateLengthInput = driver.findElement(By.id("ln_lam_id"));
        WebElement laminateWidthInput = driver.findElement(By.id("wd_lam_id"));
        WebElement selectDirectionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        selectDirectionLaminate.click();
        WebElement calcButton = driver.findElement(By.className("calc-btn"));


        roomLengthInput.clear();
        roomLengthInput.sendKeys("500");
        roomWidthInput.clear();
        roomWidthInput.sendKeys("400");
        laminateLengthInput.clear();
        laminateLengthInput.sendKeys("2000");
        laminateWidthInput.clear();
        laminateWidthInput.sendKeys("200");
        calcButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement laminateRequiredResult = driver.findElement(By.className("calc-result"));
        Assert.assertEquals(laminateRequiredResult.getAttribute("value"), "53");

        WebElement numLaminateRequiredResult = driver.findElement(By.className("calc-result"));
        Assert.assertEquals(numLaminateRequiredResult.getAttribute("value"), "7");


    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
