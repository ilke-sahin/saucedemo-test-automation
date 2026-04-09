package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private DriverManager() {}

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static WebDriver getDriver() {   // Get driver method will be used by multiple threads.
        if (driverPool.get() == null) {
            String targetBrowser = (browserName.get() != null) ? browserName.get() : ConfigReader.getProperty("browser");

            switch (targetBrowser.toLowerCase()) {
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                    driverPool.set(new ChromeDriver(getChromeOptions()));
            }

            driverPool.get().manage().window().maximize();
        }
        return driverPool.get();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled", "--incognito");
        return options;
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
            browserName.remove();
        }
    }
}