package driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tools.internal.ReportManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverFactory {


    private static WebDriver driver;  // single static instance
    private static String orangeHrmCookieValue;

    private DriverFactory() {
    }

    // Initialize WebDriver
    public static void initDriver() {
        if (driver != null) return; // already initialized

        String browser = System.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        long implicit = Long.parseLong(System.getProperty("implicitWait", "10"));

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new org.openqa.selenium.firefox.FirefoxDriver();
                break;
            case "edge":
                driver = new org.openqa.selenium.edge.EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
        try {
            driver.manage().window().maximize();
        } catch (Exception ignored) {
        }

        ReportManager.setDriver(driver);
    }

    // Get WebDriver
    public static WebDriver getDriver() {
        return driver;
    }

    // Quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
            driver = null;
        }
    }

    // Capture and store the orangehrm cookie value
    public static void captureOrangeHRMCookie() {
        Cookie cookie = driver.manage().getCookieNamed("orangehrm");
        if (cookie != null) {
            orangeHrmCookieValue = cookie.getValue();
            System.out.println("✅ Captured Cookie: ");
        } else {
            throw new RuntimeException("❌ orangehrm cookie not found!");
        }
    }

    // Retrieve the stored cookie value
    public static String getOrangeHRMCookieValue() {
        return orangeHrmCookieValue;
    }

    public static void clearCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            System.out.println("✅ All browser cookies cleared successfully.");
        }
    }
}
