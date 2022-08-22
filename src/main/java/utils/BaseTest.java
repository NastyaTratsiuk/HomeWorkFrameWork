package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void startDriver() {
        Logger.info(String.format("Open: %s", GsonParse.parse().getUrl()));//,
        SingletonBrowserClass.initialize();
    }

    @AfterClass
    public void closeDriver() {
        Logger.info(String.format("Close url '%s'", GsonParse.parse().getUrl()));
        SingletonBrowserClass.quit();
    }
}
