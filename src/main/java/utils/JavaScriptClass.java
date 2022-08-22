package utils;

import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptClass {

    public static void javaScriptScroll() {
        JavascriptExecutor js = (JavascriptExecutor) SingletonBrowserClass.initialize();
        js.executeScript("window.scrollBy(0,300)");
    }
}
