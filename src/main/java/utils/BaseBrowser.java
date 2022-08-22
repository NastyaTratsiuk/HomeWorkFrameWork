package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseBrowser {

    public static void toUrl() {
        SingletonBrowserClass.initialize().navigate().to("https://userinyerface.com/");
    }

    public static void navigateBack() {
        SingletonBrowserClass.initialize().navigate().back();
    }

    public static void navigateFoward() {
        SingletonBrowserClass.initialize().navigate().forward();
    }

    public static void navigateRefresh() {
        SingletonBrowserClass.initialize().navigate().refresh();
    }

    public static void switchWindow(int numberWindow) {
        SingletonBrowserClass.initialize().switchTo().window(hundkesList().get(numberWindow));
    }

    public static void closeWindow() {
        SingletonBrowserClass.initialize().close();
    }

    public static List<String> hundkesList() {
        Set<String> handlesSet = SingletonBrowserClass.initialize().getWindowHandles();
        return new ArrayList<String>(handlesSet);
    }
}
