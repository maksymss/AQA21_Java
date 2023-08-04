package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import utils.configuration.ReadProperties;

public class WrappersTest extends BaseTest {

    @Test
    public void testName() {
    driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes input"));

    }

    @Test
    public void tableTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();

    }
}
