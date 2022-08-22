package elements;

import org.openqa.selenium.By;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class Input extends BaseElement {

    public Input(By by) {
        super(by);
    }

    public void clearAndType(String text, String name) {
        WaitClass.waitForElementToVisibility(by);
        this.logAction("Clear and Type" + text, name);
        SingletonBrowserClass.initialize().findElement(by).clear();
        SingletonBrowserClass.initialize().findElement(by).sendKeys(text);
    }

}
