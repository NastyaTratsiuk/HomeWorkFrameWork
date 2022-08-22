package pages;

import elements.Label;
import org.openqa.selenium.By;
import utils.BaseBrowser;

public class SamplePage extends BasePage {

    private final int indexWindow0 = 0;
    private final int indexWindow1 = 1;

    public SamplePage() {
        super(new Label(By.id("sampleHeading")));
    }

    @Override
    public boolean isDisplay() {
        BaseBrowser.switchWindow(indexWindow1);
        return getBaseElement().isVisible("sample");
    }

    public void closeSample() {
        BaseBrowser.switchWindow(indexWindow1);
        BaseBrowser.closeWindow();
        BaseBrowser.switchWindow(indexWindow0);
    }

}
