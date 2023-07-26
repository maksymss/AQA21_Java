package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

import java.util.concurrent.TimeUnit;

public class AlertTests extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
    }

    @Test
    public void confirmAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.dismiss();
    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WaitService waitService = new WaitService(driver);
        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("Hello");
        alert.accept();

    }
}
