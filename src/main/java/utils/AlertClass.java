package utils;

import org.openqa.selenium.NoAlertPresentException;

public class AlertClass {

    public boolean isAlertPresent() {
        try {
            SingletonBrowserClass.initialize().switchTo().alert();
            Logger.info("Alert open");
            return true;
        } catch (NoAlertPresentException Ex) {
            Logger.error(("Alert close"));
            return false;
        }
    }

    public String alertMessage() {
        Logger.info("Alert open");
        return SingletonBrowserClass.initialize().switchTo().alert().getText();

    }

    public void clickOkAlert() {
        SingletonBrowserClass.initialize().switchTo().alert().accept();
        Logger.info("Click OK Alert");
    }

    public void sendKeys(String text) {
        SingletonBrowserClass.initialize().switchTo().alert().sendKeys(text);
    }
}
