package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure examples") // Adds hierarchy to our test reporting Epic -> Feature -> Story (can be 2 stories)
@Feature("Advanced Annotations") // Adds feature description to the report
public class Allure1Test {

    @Test
    @Story("AQA21 - 5678") // Adds a story description to the report
    public void testNAme_4() {
        Assert.assertTrue(true);
    }

}
