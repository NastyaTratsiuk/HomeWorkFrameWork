package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {

    private static WebDriverWait wait = new WebDriverWait(SingletonBrowserClass.initialize(), GsonParse.parse().getWait());

    public static void waitForElementToClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
