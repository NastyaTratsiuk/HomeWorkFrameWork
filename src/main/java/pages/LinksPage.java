package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import utils.BaseBrowser;

public class LinksPage extends BasePage {

    private final int indexWindow0 = 0;
    private final int indexWindow1 = 1;

    private Button homeBtn;

    public LinksPage() {
        super(new Label(By.xpath("//div[@class = 'main-header']")));
        homeBtn = new Button(By.id("simpleLink"));
    }

    @Override
    public boolean isDisplay() {
        return getBaseElement().isVisible("checkPageHeaderMain");
    }

    public void clickHomeBtn() {
        homeBtn.click("homeBtn");
    }

    public void switchLinks() {
        BaseBrowser.switchWindow(indexWindow1);
        BaseBrowser.switchWindow(indexWindow0);
    }

    public void switchHomePage() {
        BaseBrowser.switchWindow(indexWindow1);
    }

}
