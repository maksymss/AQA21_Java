package baseEntities_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.configuration.ReadProperties;

public abstract class BasePage_hw {
    protected WebDriver driver;

    public BasePage_hw(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
    protected abstract By getPageIdentifier();
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }
}
