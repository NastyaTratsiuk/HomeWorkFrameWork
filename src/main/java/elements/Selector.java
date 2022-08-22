package elements;

import org.openqa.selenium.By;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class Selector extends BaseElement {

    public Selector(By by) {
        super(by);
    }

    public void select(String option, String name) {
        WaitClass.waitForElementToClick(by);
        this.logAction("Select " + option, name);
        SingletonBrowserClass.initialize().findElement(by).sendKeys(option);
    }
}
