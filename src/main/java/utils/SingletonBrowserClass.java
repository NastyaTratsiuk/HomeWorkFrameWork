package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SingletonBrowserClass {

    private static WebDriver driver;

    public static WebDriver initialize() {
        if (driver == null) {
            switch (GsonParse.parse().getWebBrowser()) {
                case "chrome": {
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("incognito");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, option);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(capabilities);
                    driver.manage().window().maximize();
                    break;
                }
                case "firefox": {
                    DesiredCapabilities capabilitiesFF = DesiredCapabilities.firefox();
                    FirefoxOptions optionFF = new FirefoxOptions();
                    optionFF.addArguments("incognito");
                    capabilitiesFF.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionFF);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                }
                default:
                    System.out.println("Typo!");

            }
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

}

