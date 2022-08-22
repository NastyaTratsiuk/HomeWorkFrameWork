package elements;

import org.openqa.selenium.By;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class Label extends BaseElement {

    public Label(By by) {
        super(by);
    }

    public boolean isDisplayed(String name) {
        this.logAction("Label", name);
        WaitClass.waitForElementToVisibility(by);
        return SingletonBrowserClass.initialize().findElement(by)
                .isDisplayed();
    }

}
