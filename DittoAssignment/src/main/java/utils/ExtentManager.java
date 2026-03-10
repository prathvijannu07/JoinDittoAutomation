package utils;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReport() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
			spark.config().setReportName("TestReport");
			spark.config().setDocumentTitle("MakeMyTrip");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		
		return extent;
		
	}
	
}
