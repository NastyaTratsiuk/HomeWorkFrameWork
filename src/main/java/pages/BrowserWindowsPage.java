package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import utils.JavaScriptClass;

public class BrowserWindowsPage extends BasePage {

    private final Button newTabBtn;
    private final Button elementsBtn;
    private final Button linksBtn;

    public BrowserWindowsPage() {
        super(new Label(By.xpath("//div[@class = 'main-header']")));
        newTabBtn = new Button(By.id("tabButton"));
        elementsBtn = new Button(By.xpath("//div[text() = 'Elements']"));
        linksBtn = new Button(By.xpath("//span [text() = 'Links']"));
    }

    @Override
    public boolean isDisplay() {
        return getBaseElement().isVisible("checkPageHeaderMain");
    }

    public String getCheckPageHeaderMain() {
        return getBaseElement().getText("checkPageHeaderMain");
    }

    public void clickNewTabBtn() {
        newTabBtn.click("newTabBtn");
    }

    public void clicklinksBtn() {
        JavaScriptClass.javaScriptScroll();
        linksBtn.click("linksBtn");
    }

    public void clickElementsBtn() {
        elementsBtn.click(" elementsBtn");
    }

}
