package tests;

import baseEntities.BaseTest;
import factory.BrowserFactory;
import helper_hw.DataHelper;
import models.User;
import org.openqa.selenium.WebDriver;
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
        User user = new User();
        user.setEmail("asdasd");
        user.setPassword(ReadProperties.password());

        Assert.assertTrue(
                loginStep.successLogin(DataHelper.getUser()).isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        Assert.assertEquals(
                loginStep.negativeLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    @Test
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword("123456");

        Assert.assertEquals(
                loginStep.negativeLogin(user).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

}


