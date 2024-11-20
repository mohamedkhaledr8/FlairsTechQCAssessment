package listeners;

import Browser.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import projectSetup.PropertiesManager;

public class TestNGListener implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Cucumber Test Suite Started: " + context.getName());
        PropertiesManager.loadPropertiesToSystem();

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Cucumber Test Suite Finished: " + context.getName());
        BrowserManager.getInstance().getDriver().quit();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());


    }
}

