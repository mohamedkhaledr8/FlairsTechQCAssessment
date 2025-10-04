package gui.browser;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import tools.internal.ReportManager;

public class BrowserActions {

    private final WebDriver driver;

    public BrowserActions(WebDriver driver)
    {
        this.driver=driver;
    }
    @Step("Navigate to URL: {url}")
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

}
