package gui.element;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.internal.ReportManager;

import java.util.List;


public class ElementActions {
    private final WebDriver driver;
    private final WaitManager wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver);
    }


    @Step("Click element: {locator}")
    public void click(By locator) {
        wait.waitForVisible(locator);
         wait.waitForClickable(locator);
        driver.findElement(locator).click();

    }

    @Step("Type '{text}' into element: {locator}")
    public void type(By locator, String text) {
        wait.waitForVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @Step("Read text from element: {locator}")
    public String getText(By locator) {
        wait.waitForVisible(locator);
     return driver.findElement(locator).getText();
    }

    @Step("Get List pof element: {locator}")
    public List<WebElement> getElements(By locator) {
        wait.waitForVisible(locator);
        return driver.findElements(locator);
    }


}
