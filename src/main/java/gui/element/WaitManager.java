package gui.element;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitManager {

    private final WebDriver driver;


    public WaitManager(WebDriver driver) {
        this.driver = driver;

    }

    private <T> T fluentWait(Function<WebDriver, T> condition) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .until(condition);
    }

    @Step("Wait for element visible: {locator}")
    public void waitForVisible(By locator) {
         fluentWait(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Wait for element clickable: {locator}")
    public void waitForClickable(By locator) {
         fluentWait(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Wait for element present in DOM: {locator}")
    public void waitForPresence(By locator) {
         fluentWait(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Wait for title contains: {title}")
    public void waitForTitleContains(String title) {
         fluentWait(ExpectedConditions.titleContains(title));
    }

    @Step("Wait for text to be present: {locator}, text: {text}")
    public void waitForText(By locator, String text) {
         fluentWait(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

}
