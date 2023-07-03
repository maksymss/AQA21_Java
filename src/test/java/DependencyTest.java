import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void stepb() {
        System.out.println("stepb...");
    }
    @Test(dependsOnMethods = "stepb")
    public void stepa2() {
        System.out.println("stepa2...");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "stepa2", alwaysRun = true)
    public void stepa11() {
        System.out.println("stepa11...");
    }
    @Test(dependsOnMethods = {"stepb", "stepa2"})
    public void step12() {
        System.out.println("step12...");
    }

}
