package elements;

import org.openqa.selenium.By;
import utils.SingletonBrowserClass;
import utils.WaitClass;

public class Collection extends BaseElement {

    public Collection(By by) {
        super(by);
    }

    public int sizeCollection(String name) {
        WaitClass.waitForElementToVisibility(by);
        this.logAction("Size collection", name);
        return SingletonBrowserClass.initialize().findElements(by).size();
    }

}
