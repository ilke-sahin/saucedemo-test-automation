package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (FileInputStream fis = new FileInputStream("configuration.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration.properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}