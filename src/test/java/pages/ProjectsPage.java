package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    //Block describing locators for element
    private final By headerTitleLabelLocator = By.className("content-header-title page_title");
    private final By projectsTableLocator = By.cssSelector("#content-inner table");



    //Initialization block
    public ProjectsPage(WebDriver driver) {
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


    //Block complex methods

}
