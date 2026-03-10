package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

	public WebDriver driver;
	String URL = ConfigReader.getProperty("url");

	@BeforeMethod
	public void setup() {

		driver = DriverFactory.initDriver();
		driver.get(URL);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}