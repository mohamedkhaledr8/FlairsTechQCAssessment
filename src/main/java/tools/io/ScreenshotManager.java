package tools.io;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import tools.internal.LoggingManager;
import tools.internal.ReportManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotManager {
    private final WebDriver driver;
    private final String outDir = "";

    public ScreenshotManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Capture screenshot, save file and attach to Allure.
     * Returns the saved File.
     */
    public void takeScreenshot(String name) {
        try {
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String fileName = outDir + sanitize(name) + "_" + ts + ".png";
            File folder = new File(outDir);
            if (!folder.exists()) folder.mkdirs();
            File target = new File(fileName);
            FileUtils.writeByteArrayToFile(target, bytes);

            // attach to Allure
            ReportManager.attachScreenshotFile(name, target);

        } catch (WebDriverException | IOException e) {
            LoggingManager.error("Failed to take screenshot: " + name, e);
        }
    }

    private String sanitize(String s) {
        return s.replaceAll("[^a-zA-Z0-9_\\-\\.]", "_");
    }
}
