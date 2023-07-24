package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

import java.util.List;

public class ActionTests extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitService.waitAllVisibleElementsLocatedBy(By.className("figure"));

        actions
                .moveToElement(targetElements.get(0))
                .click(waitService.waitForVisibilityLocatedBy(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
        Assert.assertTrue(waitService.waitForElementInvisible(targetElements.get(0)));
    }
    @Test
    public void uploadFileTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitService waitService = new WaitService(driver);

        WebElement fileUploadElement = waitService.waitForExist(By.xpath("//form/input[@type='file']"));
        String pathToFile =
    }
}
