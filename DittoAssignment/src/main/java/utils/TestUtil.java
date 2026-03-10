package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class TestUtil extends BaseTest {

	static WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	// Screenshot Method
	 public static String takeScreenshot(String testName) {

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

	        File dest = new File(path);

	        try {
	            FileHandler.copy(src, dest);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return path;
	    }

	// Wait for element
	public void waitForElement(WebElement element) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed(), "Element not visible");
			takeScreenshot("waitElement");
		} catch (Exception e) {
			takeScreenshot("waitElementFailed");
			Assert.fail("Element not found: " + e.getMessage());
		}
	}

	public static void moveToElement(WebDriver driver, WebElement element, String elementName) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOf(element));

			Actions actions = new Actions(driver);

			actions.moveToElement(element).perform();

		} catch (Exception e) {

			System.out.println("Failed to move to element: " + elementName);

			takeScreenshot("waitElementFailed");

			e.printStackTrace();
		}
	}

	// Click element
	public void clickElement(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));

			waitForElement(element);
			element.click();
			takeScreenshot("clickElement");

		} catch (Exception e) {
			takeScreenshot("clickFailed");
			Assert.fail("Unable to click element: " + e.getMessage());
		}
	}

	public void verifyText(WebElement element, String text, String elementName) {

		try {
			waitForElement(element);

			String actualText = element.getText().trim();
			System.out.println("actual Text :"+actualText);
			String expectedText = text.trim();
			System.out.println("Expected text: "+expectedText);

			Assert.assertEquals(actualText, expectedText);

			takeScreenshot("verifyTextSuccess");

		} catch (Exception e) {

			takeScreenshot("verifyTextFailed");

			Assert.fail("Text verification failed for " + elementName);
		}
	}

	public void jsClick(WebElement element) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait until element is clickable
			wait.until(ExpectedConditions.elementToBeClickable(element));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			System.out.println("PASS: Element clicked successfully");

		} catch (Exception e) {

			System.out.println("FAIL: Element click failed");
			e.printStackTrace();

		}
	}

	// Check visibility
	public void checkElementVisible(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			boolean status = element.isDisplayed();
			Assert.assertTrue(status, "Element not visible");

			takeScreenshot("elementVisible");
		} catch (Exception e) {
			takeScreenshot("visibilityFailed");
			Assert.fail("Visibility check failed");
		}
	}

	public void selectFromDropdown(WebDriver driver, WebElement dropdown, String value) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait and click dropdown
			wait.until(ExpectedConditions.visibilityOf(dropdown));
			dropdown.click();

			// Select option
			WebElement option = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + value + "']")));

			option.click();

			System.out.println("PASS: Selected value -> " + value);

		} catch (Exception e) {

			System.out.println("FAIL: Unable to select value -> " + value);
			e.printStackTrace();

		}
	}

	// Scroll to element
	public void scrollToElement(WebElement element) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			takeScreenshot("scrollElement");
		} catch (Exception e) {
			takeScreenshot("scrollFailed");
			Assert.fail("Scroll failed");
		}
	}

	// Double click
	public void doubleClick(WebElement element) {

		try {
			actions.doubleClick(element).perform();
			takeScreenshot("doubleClick");
		} catch (Exception e) {
			takeScreenshot("doubleClickFailed");
			Assert.fail("Double click failed");
		}
	}

	// Slider drag
	public void moveSlider(WebElement slider, int xOffset, String elementName) {
		try {
			waitForElement(slider);

			Actions actions = new Actions(driver);
			actions.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();

			takeScreenshot("SliderMoved");

		} catch (Exception e) {
			takeScreenshot("SliderMoveFailed");
			Assert.fail("Slider movement failed: " + elementName);
		}
	}

	// Mouse hover
	public void mouseHover(WebElement element) {

		try {
			actions.moveToElement(element).perform();
			takeScreenshot("mouseHover");
		} catch (Exception e) {
			takeScreenshot("hoverFailed");
			Assert.fail("Mouse hover failed");
		}
	}

	// Mouse right click
	public void mouseRightClick(WebElement element) {

		try {
			actions.contextClick(element).perform();
			takeScreenshot("rightClick");
		} catch (Exception e) {
			takeScreenshot("rightClickFailed");
			Assert.fail("Right click failed");
		}
	}

	// Drag and Drop
	public void dragAndDrop(WebElement source, WebElement target) {

		try {
			actions.dragAndDrop(source, target).perform();
			takeScreenshot("dragDrop");
		} catch (Exception e) {
			takeScreenshot("dragDropFailed");
			Assert.fail("Drag drop failed");
		}
	}

	// Capture list of elements
	public void captureElements(List<WebElement> elements) {

		try {
			Assert.assertTrue(elements.size() > 0, "No elements found");

			for (WebElement el : elements) {
				System.out.println(el.getText());
			}

			takeScreenshot("elementsList");
		} catch (Exception e) {
			takeScreenshot("listCaptureFailed");
			Assert.fail("Unable to capture elements list");
		}
	}

	public String getOtpFromYopmail(WebDriver driver, WebElement EnterEmail, WebElement gobutton, WebElement otpElement)
			throws FileNotFoundException {

		// Store current tab
		String parentTab = driver.getWindowHandle();

		// Open new tab
		((JavascriptExecutor) driver).executeScript("window.open()");

		// Switch to new tab
		Set<String> tabs = driver.getWindowHandles();
		for (String tab : tabs) {
			if (!tab.equals(parentTab)) {
				driver.switchTo().window(tab);
			}
		}

		// Navigate to Yopmail
		String url = ConfigReader.getProperty("yopmailurl");
		String YopmailID = ConfigReader.getProperty("email");
		driver.get(url);
		// Wait until element text is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(EnterEmail));
		EnterEmail.sendKeys(YopmailID);
		gobutton.click();
		// Wait until element text is visible
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(otpElement));

		// Get text from WebElement
		String text = otpElement.getText();

		// Remove all alphabets
		String otp = text.replaceAll("[a-zA-Z]", "").replaceAll("\\s+", "");

		// Close Yopmail tab
		driver.close();

		// Switch back to original tab
		driver.switchTo().window(parentTab);

		return otp;
	}
}