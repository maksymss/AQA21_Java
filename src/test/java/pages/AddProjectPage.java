package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

import static io.netty.handler.codec.http.HttpHeaders.setDate;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    //Block describing locators for element
    private final By headerTitleLabelLocator = By.xpath("//*[@id=\"content-header\"]/div/div[2]");


    //Initialization block
    public AddProjectPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    //Block unit methods (specific methods)
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }




}
