package tests;

import baseEntities.BaseTest;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.configuration.ReadProperties;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {

       Assert.assertTrue(
               loginStep.successLogin(
                       ReadProperties.username(),
                       ReadProperties.password()
                       ).isPageOpened()


       );

    }
    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin("asdasd", ReadProperties.password()).errorText.getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "123456").errorFieldText.getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
    @Test
    public void screenShotTest() {
        Assert.assertTrue(false);
    }

    /*@Test
    public void shortPswLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "123").getErrorFieldTextElement().getText(),
                "Password is too short (5 characters required).",
                "Неверное сообщение об ошибке");
    }*/

}


