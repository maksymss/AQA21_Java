import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {
    protected Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class....");
        calculator = new Calculator();
        calculator.setLevel(this.getClass().toString());
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups....");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest...");

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod...");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class....");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Groups....");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite...");
    }
}
