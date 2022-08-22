package elements;

import org.openqa.selenium.By;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class Radio extends BaseElement {

    public Radio(By by) {
        super(by);
    }

    public void check(String name) {
        WaitClass.waitForElementToClick(by);
        this.logAction("Check", name);
        SingletonBrowserClass.initialize().findElement(by).click();
    }
}
