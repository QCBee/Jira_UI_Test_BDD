package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void createInstance(String browserName) {

        DesiredCapabilities capability = null;
        WebDriver driver;

        if (browserName.toLowerCase()
                .contains("firefox")) {
            WebDriverManager.firefoxdriver()
                    .setup();
            driver = new FirefoxDriver();
        } else if (browserName.toLowerCase().contains("internet")) {
            WebDriverManager.iedriver()
                    .setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.toLowerCase()
                .contains("chrome")) {
            WebDriverManager.chromedriver()
                    .setup();
            driver = new ChromeDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage()
                .window()
                .maximize();
        webDriver.set(driver);
    }
}
