package elements;

import org.openqa.selenium.By;
import utils.Logger;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class BaseElement {

    public By by;

    public BaseElement(By by) {
        this.by = by;
    }

    public boolean isVisible(String name) {
        this.logAction("Is visible", name);
        return SingletonBrowserClass.initialize().findElement(by).isDisplayed();
    }

    public void click(String name) {
        WaitClass.waitForElementToClick(by);
        this.logAction("Click", name);
        SingletonBrowserClass.initialize().findElement(by).click();
    }

    public String getText(String name) {
        WaitClass.waitForElementToVisibility(by);
        this.logAction("Label", name);
        return SingletonBrowserClass.initialize().findElement(by).getText();
    }

    protected void logAction(String action, String name) {
        Logger.trace(String.format("[%s] %s - %s",
                this.getClass().getSimpleName(),
                action,
                name))
        ;
    }
}
