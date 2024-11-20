package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ElementWaitingManager {

    private final WebDriverWait wait;

    public ElementWaitingManager(WebDriver driver) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void waitElementVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
