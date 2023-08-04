package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import services.WaitService;
import utils.configuration.ReadProperties;

public abstract class BasePage {
    private static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 30;
    protected WebDriver driver;
    protected WaitService waitService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitService = new WaitService(driver);

        PageFactory.initElements(driver, this);
    }
    public void openPageByUrl(String pagePath) {
    driver.get(ReadProperties.getUrl() + pagePath);
    }

    protected abstract By getPageIdentifier();
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void updateElements() {
        PageFactory.initElements(driver, this);
    }
        }
