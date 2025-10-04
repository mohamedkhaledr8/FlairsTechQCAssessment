package tools.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesManager {
    public static void loadPropertiesToSystem() {
        Properties properties = new Properties();
        String packageName = "properties";
        try {
            // Get a list of all resource URLs in the specified package
            Enumeration<URL> resources = PropertiesManager.class.getClassLoader().getResources(packageName);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File folder = new File(resource.getFile());

                // Iterate over each file in the directory
                for (File file : folder.listFiles()) {
                    if (file.isFile() && file.getName().endsWith(".properties")) {
                        try (InputStream inputStream = new FileInputStream(file)) {
                            Properties tempProperties = new Properties();
                            tempProperties.load(inputStream);

                            // Merge properties into the main properties object
                            properties.putAll(tempProperties);
                        } catch (IOException e) {
                            System.err.println("Failed to load properties file: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }

            // Set each property into System Properties
            properties.forEach((key, value) -> System.setProperty(key.toString(), value.toString()));
            System.out.println("All properties loaded into System Properties.");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from package: " + packageName, e);
        }
    }
}
