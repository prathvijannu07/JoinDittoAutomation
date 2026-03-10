package tests;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import listeners.TestListener;
import pages.HomPage;
import utils.ConfigReader;
import utils.TestUtil;

@Listeners(TestListener.class)

public class HomePageTest extends BaseTest {

	HomPage homepage;
	TestUtil util;
//	public String CoverAmount="₹50 L";

	@BeforeMethod
	public void init() {
		homepage = new HomPage(driver);
		util = new TestUtil(driver);
//		PageFactory.initElements(driver, this);
	}


	double sumAssured = Double.parseDouble(ConfigReader.getProperty("sumAssured"));
	double ratePerLaks184= Double.parseDouble(ConfigReader.getProperty("ratePerLaks184"));
	double ratePerLaks209= Double.parseDouble(ConfigReader.getProperty("ratePerLaks209"));


	/* This is a dummy base premium calculation used only for automation verification.
	  The actual premium is calculated using the application's business logic.*/
	public static String calculatePremium184(double coverAmount,double ratePerLaks) {

	    double ratePerLakh = ratePerLaks;   // correct rate
	    double coverInLakhs = coverAmount / 100000;
	    double premium = coverInLakhs * ratePerLakh;
	    DecimalFormat df = new DecimalFormat("#,##0.00");
	    return "₹" + df.format(premium);
	}
	
	public static String calculatePremium209(double coverAmount,double ratePerLaks) {

	    double ratePerLakh = ratePerLaks;   // correct rate
	    double coverInLakhs = coverAmount / 100000;
	    double premium = coverInLakhs * ratePerLakh;
	    DecimalFormat df = new DecimalFormat("#,##0.00");
	    return "₹" + df.format(premium);
	}

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class,description = "Veriy the HomePage components")
	public void HomePageVerification() throws FileNotFoundException {

		String HomapageTitle = driver.getTitle();
		System.out.println(HomapageTitle);
		util.checkElementVisible(HomPage.HDFCLife);
		util.clickElement(HomPage.HDFCLife);
		util.checkElementVisible(HomPage.Smart_Total_Elite_Protection);
		util.clickElement(HomPage.Next);
		util.clickElement(HomPage.Next);
		util.clickElement(HomPage.Continue);
	}

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class,dependsOnMethods = "HomePageVerification", description = "Verify  Tell Us About You page")
	public void TellUsAboutYouPage() throws FileNotFoundException, InterruptedException {
		HomePageVerification();	
		util.checkElementVisible(HomPage.TellUsAboutYou);
		util.checkElementVisible(HomPage.your_gender);
		util.checkElementVisible(HomPage.Your_DOB);
		util.checkElementVisible(HomPage.HaveYouSmocked);
		util.checkElementVisible(HomPage.You_diabetes);
		util.checkElementVisible(HomPage.YouNRI);
		util.clickElement(HomPage.male);
		HomPage.YourDOB_Field.sendKeys(ConfigReader.getProperty("Date_of_Birth"));
		util.clickElement(HomPage.HaveYouSmoked_No);
		util.clickElement(HomPage.You_diabete_No);
		util.clickElement(HomPage.YouNRI_No);
		util.clickElement(HomPage.NextStep);
	}

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class,dependsOnMethods = "TellUsAboutYouPage", description = "Verify  A Bit Of Your Life Page")

	public void ABitOfYourLifePage() throws FileNotFoundException, InterruptedException {
		TellUsAboutYouPage();	
		util.checkElementVisible(HomPage.ABitOfYourLifeStyle);
		util.checkElementVisible(HomPage.WhereDoYouLive);
		util.checkElementVisible(HomPage.Education);
		util.checkElementVisible(HomPage.Salaried);
		util.checkElementVisible(HomPage.Annual_Income);
		util.checkElementVisible(HomPage.Monthly_Expenses);
		HomPage.pincode.sendKeys(ConfigReader.getProperty("Pincode"));
		util.selectFromDropdown(driver, HomPage.EducationFeild,ConfigReader.getProperty("Education") );
		util.checkElementVisible(HomPage.Salaried);
		util.checkElementVisible(HomPage.Annual_Income);
		util.checkElementVisible(HomPage.Monthly_Expenses);
		util.clickElement(HomPage.SalariedYes);
		HomPage.AnnualIncomeField.sendKeys(ConfigReader.getProperty("AnnualIncome"));
		HomPage.MonthlyExpensesField.sendKeys(ConfigReader.getProperty("MonthlyExpenses"));
		util.clickElement(HomPage.NextStep);
		

	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class,dependsOnMethods = "TellUsAboutYouPage", description = "Verify  check Base And Total Premiums")
	public void checkBaseAndTotalPremiums() throws FileNotFoundException, InterruptedException {
		ABitOfYourLifePage();
		util.checkElementVisible(HomPage.RecommendedCover); 
		util.clickElement(HomPage.FiftyL);
		util.clickElement(HomPage.TenL);
		util.verifyText(HomPage.CoverAmount, ConfigReader.getProperty("CoverAmount"), "check cover amount");
		
		try {
			util.verifyText(HomPage.BasePremium, calculatePremium184(sumAssured,ratePerLaks184), "Check calculated amount with Base premium");
		} catch (Exception e) {
			util.verifyText(HomPage.BasePremium, calculatePremium209(sumAssured,ratePerLaks209), "Check calculated amount with Base premium");
		}
		
		
		try {
			util.verifyText(HomPage.TotalPerYear, calculatePremium184(sumAssured,ratePerLaks184), "Check calculated amount with Total per year premium");
		} catch (Exception e) {
			util.verifyText(HomPage.TotalPerYear, calculatePremium209(sumAssured,ratePerLaks209), "Check calculated amount with Total per year premium");
		}
		

	}
}









//double sumAssured = 5000000; 
//int currentAge = 32;
//int maturityAge = 70;
//double mortalityRate = 0.000045;
//double loadingPercent = 15;