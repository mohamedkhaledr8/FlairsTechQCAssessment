package element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ElementActions {
    private final WebDriver driver;
    private final ElementWaitingManager waitingManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        waitingManager = new ElementWaitingManager(driver);

    }

    public void clickElementUsingJavaScript(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitingManager.waitElementVisibility(locator);
        waitingManager.waitElementToBeClickable(locator);
        WebElement element = driver.findElement((locator));
        js.executeScript("arguments[0].click();", element);
    }

    public void clickElement(By locator) {
        waitingManager.waitElementVisibility(locator);
        waitingManager.waitElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public void typeText(By locator, String txt) {
        waitingManager.waitElementVisibility(locator);
        driver.findElement(locator).sendKeys(txt);
    }

    public void submit(By locator) {
        waitingManager.waitElementVisibility(locator);

        driver.findElement(locator).submit();
    }

    public String getElementText(By locator) {
        waitingManager.waitElementVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public List<WebElement> getElements(By locator) {
        waitingManager.waitElementVisibility(locator);

        return driver.findElements(locator);
    }


}
