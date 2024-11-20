package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {

    // private static WebDriver driver = null;

    private static BrowserManager instance = null; // Single instance
    private WebDriver driver;

    // Private constructor to prevent external instantiation
    private BrowserManager() {
        var browserName = "Chrome";
        switch (browserName) {
            case "Chrome" -> driver = new ChromeDriver();
            case "FireFox" -> driver = new FirefoxDriver();
            case "Edge" -> driver = new EdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
    }

    // Public method to get the single instance
    public static BrowserManager getInstance() {
        if (instance == null) {
            synchronized (BrowserManager.class) { // Thread-safe initialization
                if (instance == null) {
                    instance = new BrowserManager();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    // Clean up the WebDriver instance
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null; // Reset the singleton instance
        }
    }

}
