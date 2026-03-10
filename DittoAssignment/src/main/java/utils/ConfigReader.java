package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    // Static block runs only once when class loads
    static {
        try {
            FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to get property value
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}