package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }
}