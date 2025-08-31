package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Config file not found!");
        }
    }

    public static String get(String key) {
        // If passed from TestNG parameter → override config.properties
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        }
        return properties.getProperty(key);
    }
}
