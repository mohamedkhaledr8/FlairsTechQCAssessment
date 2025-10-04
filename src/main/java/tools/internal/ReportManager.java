package tools.internal;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ReportManager {

    private static WebDriver driver;
    private ReportManager(){}

    public static void setDriver(WebDriver d)
    {
        driver=d;
    }


    public static void logStep(String message) {
        Allure.step(message);
    }

    public static void attachText(String name, String message) {
        if (message == null) message = "";
        Allure.addAttachment(name, "text/plain", new ByteArrayInputStream(message.getBytes()), ".txt");
    }


    public static void attachScreenshotFile(String name, File pngFile) {
        if (pngFile == null || !pngFile.exists()) return;
        try (FileInputStream fis = new FileInputStream(pngFile)) {
            Allure.addAttachment(name, "image/png", fis, ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void attachVideo(String testName, File videoFile) {
        if (videoFile == null || !videoFile.exists()) return;
        try (FileInputStream fis = new FileInputStream(videoFile)) {
            // prefer mp4 mime type (adjust extension/mime as needed)
            Allure.addAttachment("Video - " + testName, "video/mp4", fis, ".mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generateAndOpenReport() {
        try {
            // Path to Allure binary (relative to project root)
            String allurePath = "./tools/allure/bin/allure";

            // Check allure-results folder
            File resultsDir = new File("allure-results");
            if (!resultsDir.exists()) {
                System.out.println("⚠️ No allure-results folder found! Skipping report generation.");
                return;
            }

            // Build the command
            String command = allurePath + " serve allure-results";

            System.out.println("🚀 Generating Allure Report...");
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
            pb.inheritIO(); // attach to console output
            Process process = pb.start();
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("❌ Failed to generate Allure report automatically!");
        }
    }
}
