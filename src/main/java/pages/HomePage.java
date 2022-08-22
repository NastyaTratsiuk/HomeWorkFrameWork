package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import utils.JavaScriptClass;

public class HomePage extends BasePage {

    private Button alertsFrameWindowsBtn;
    private Button elementsBtn;
    private Label homePage;

    public HomePage() {
        super(new Label(By.xpath("//div[@id ='javascriptAlertsWrapper']")));
        alertsFrameWindowsBtn = new Button(By.xpath("//div[@class = 'card-body']/h5[text() ='Alerts, Frame & Windows']"));
        elementsBtn = new Button(By.xpath("//div[@class = 'card-body']/h5[text() ='Elements']"));
        homePage = new Label(By.xpath("//div[@class = 'home-banner']"));
    }

    @Override
    public boolean isDisplay() {
        return homePage.isDisplayed("homePage");
    }

    public void ckickAlertsFrameWindowsBtn() {
        JavaScriptClass.javaScriptScroll();
        alertsFrameWindowsBtn.click(" alertsFrameWindowsBtn");
    }

    public void ckickElementsBtn() {
        JavaScriptClass.javaScriptScroll();
        elementsBtn.click(" elementsBtn");
    }

    public boolean isPageOpen() {
        return homePage.isDisplayed("homePage");
    }
}
