package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.aventstack.extentreports.*;

import utils.ExtentManager;
import utils.ScreenshotUtil;
import utils.TestUtil;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getExtentReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		test.pass("Test Passed: " + testDescription);
		String path = TestUtil.takeScreenshot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver driver = ((base.BaseTest) testClass).driver;
		String testDescription = result.getMethod().getDescription();
		String path = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(path);
		test.fail(result.getThrowable());
		test.fail("Test Failed: " + testDescription);
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		String path = TestUtil.takeScreenshot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(path);
		System.out.println("Test Skipped: " + testDescription);
		System.out.println("Test Skipped: " + result.getName());
	}

	public void onConfigurationFailure(ITestResult result) {
		System.out.println("Config failed: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}