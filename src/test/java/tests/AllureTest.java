package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure examples")
@Feature("Basic Annotations")
public class AllureTest {

    @Test
    @Description("Some detailed test description.") //Adds a description field to the test report
    public void testNAme_1() {
        Assert.assertTrue(true);
    }
    @Test(description = "Human-readable test name") //Substitutes test method name for readable test description
    @Description("Some detailed test description.")
    public void testNAme_2() {
        Assert.assertTrue(true);
    }
    @Test
    @Severity(SeverityLevel.MINOR) //This annotation adds severity level to test report
    public void testNAme_3() {
        Assert.assertTrue(true);
    }
    @Test
    @Story("AQA21 - 1234")
    @Severity(SeverityLevel.MINOR) //This annotation adds story description to test report
    public void testNAme_4() {
        Assert.assertTrue(true);
    }
    @Test
    @Issue("BUG-1") //This annotation adds issue to test report
    public void testNAme_5() {
        Assert.assertTrue(true);
    }
    @Test
    @TmsLink("TestCase-17")
     //This annotation adds TMS link to test report
    public void testNAme_6() {
        Assert.assertTrue(true);
    }
    @Test
    @Link("https://exaple.org")
    @Link(name = "allureLink", type = "myLink", url = "https://exaple.org")
     //This annotation adds TMS link to test report
    public void testNAme_7() {
        Assert.assertTrue(true);
    }


}
