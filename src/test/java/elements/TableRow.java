package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TableRow {
    private UIElement uiElement;
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
        this.driver = driver;
    }

    public TableRow(WebDriver driver, UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public TableCell getCell(int index) {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.tagName("td"));
        return new TableCell(driver, list.get(index));
    }
}
