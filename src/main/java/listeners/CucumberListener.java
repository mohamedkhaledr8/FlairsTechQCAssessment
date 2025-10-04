package listeners;

import driver.CookiesFactory;
import driver.DriverFactory;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tools.internal.LoggingManager;
import tools.internal.ReportManager;
import tools.io.PropertiesManager;
import tools.io.ScreenshotManager;

public class CucumberListener implements  ITestListener {

    private WebDriver driver;
    //private VideoManager videoManager;
    private boolean propertiesLoaded = false;

    @Override
    public void onStart(ITestContext context) {

        System.out.println(">>> Test Suite started: " + context.getName());
        if (!propertiesLoaded) {
            LoggingManager.info("loading properties files.....");
            PropertiesManager.loadPropertiesToSystem();
            propertiesLoaded = true;
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(">>> Test Suite finished: " + context.getName());
        CookiesFactory.clearCookies(DriverFactory.getDriver());
        DriverFactory.quitDriver();
        ReportManager.generateAndOpenReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>> Test Started: " + result.getName());
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">>> Test Passed: " + result.getName());
        CookiesFactory.clearCookies(DriverFactory.getDriver());
        DriverFactory.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> Test Failed: " + result.getName());

        // Attach screenshot
        new ScreenshotManager(driver).takeScreenshot(result.getName());

        // Attach log
        // ReportManager.attachScreenshotFile(result.getName());

        // Attach video (placeholder)
      /*  File fakeVideo = new File("target/videos/" + result.getName() + ".avi");
        if (fakeVideo.exists()) {
            VideoManager.attachVideo(result.getName(), fakeVideo);
        }
*/
        DriverFactory.clearCookies();
        DriverFactory.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(">>> Test Skipped: " + result.getName());
        CookiesFactory.clearCookies(DriverFactory.getDriver());
        DriverFactory.quitDriver();


    }
}




