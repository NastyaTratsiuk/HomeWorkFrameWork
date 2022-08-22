package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import utils.AlertClass;
import utils.FrameClass;
import utils.JavaScriptClass;

public class AlertsFrameWindowsPage extends BasePage {

    private final int indexFrameChild = 0;
    String randomText;
    private Button alertsBtn;
    private Button nestedFramesBtn;
    private Label checkNestedFrameText;
    private Label checkFrameText;
    private Button framesBtn;
    private Button browserWindowsBtn;
    private Button clickButtonToSeeAlert;
    private Button onButtonClickConfirmBoxWillAppear;
    private Label youSelectedOK;
    private Button onButtonClickPromptBoxWillAppear;
    private Label checkRandomText;

    public AlertsFrameWindowsPage() {
        super(new Label(By.xpath("//div[@class = 'main-header']")));
        alertsBtn = new Button(By.xpath("//div[@class ='element-list collapse show']//li[@id = 'item-1']"));
        nestedFramesBtn = new Button(By.xpath("//div[@class ='element-list collapse show']//li[@id = 'item-3']"));
        checkNestedFrameText = new Label(By.xpath("//html/body"));
        checkFrameText = new Label(By.xpath("//html/body/h1"));
        framesBtn = new Button(By.xpath("//div[@class ='element-list collapse show']//li[@id = 'item-2']"));
        browserWindowsBtn = new Button(By.xpath("//div[@class ='element-list collapse show']//li[@id = 'item-0']"));
        clickButtonToSeeAlert = new Button(By.xpath("//button[@id = 'alertButton']"));
        onButtonClickConfirmBoxWillAppear = new Button(By.xpath("//button[@id = 'confirmButton']"));
        youSelectedOK = new Label(By.id("confirmResult"));
        onButtonClickPromptBoxWillAppear = new Button(By.xpath("//button[@id = 'promtButton']"));
        checkRandomText = new Label(By.id("promptResult"));
    }

    public void clickAlertBtn() {
        JavaScriptClass.javaScriptScroll();
        alertsBtn.click("alertsBtn");
    }

    @Override
    public boolean isDisplay() {
        return getBaseElement().isVisible("checkPageHeaderMain");
    }

    public String getCheckPageHeaderMain() {
        return getBaseElement().getText("checkPageHeaderMain");
    }

    public void clickNestedFramesBtn() {
        JavaScriptClass.javaScriptScroll();
        nestedFramesBtn.click("nestedFramesBtn");
    }

    public String parentFrameText() {
        FrameClass.switchToFrameName("frame1");
        return checkNestedFrameText.getText("checkNestedFrameText");
    }

    public String childFrameText() {
        FrameClass.switchToFrameIndex(indexFrameChild);
        return checkNestedFrameText.getText("checkNestedFrameText");
    }

    public void clickFrameBtn() {
        FrameClass.switchToParentFrame();
        FrameClass.switchToDefaultContentFrame();
        JavaScriptClass.javaScriptScroll();
        framesBtn.click("framesBtn");
    }

    public String upperFrameText() {
        FrameClass.switchToFrameName("frame1");
        return checkFrameText.getText("checkFrameText");
    }

    public String lowerFrameText() {
        FrameClass.switchToDefaultContentFrame();
        FrameClass.switchToFrameName("frame1");
        return checkFrameText.getText("checkFrameText");
    }

    public void clickClikButtonToSeeAlert() {
        clickButtonToSeeAlert.click("clickButtonToSeeAlert");
    }

    public void clickOnButtonClickConfirmBoxWillAppear() {
        onButtonClickConfirmBoxWillAppear.click("onButtonClickConfirmBoxWillAppear");
    }

    public String checkYouSelectedOK() {
        return youSelectedOK.getText("youSelectedOK");
    }

    public void clickOnButtonClickPromptBoxWillAppear() {
        JavaScriptClass.javaScriptScroll();
        onButtonClickPromptBoxWillAppear.click("onButtonClickPromptBoxWillAppear");
    }

    public String checkRandomText() {
        return checkRandomText.getText("checkRandomText");
    }

    public void inputRandomTextInAlert(String text) {
        AlertClass alertPage = new AlertClass();
        setRandomText(text);
        alertPage.sendKeys(text);
    }

    public void clickBrowserWindowsBtn() {
        JavaScriptClass.javaScriptScroll();
        browserWindowsBtn.click("browserWindowsBtn");
    }

    public String getRandomText() {
        return randomText;
    }

    public void setRandomText(String randomText) {
        this.randomText = randomText;
    }

}
