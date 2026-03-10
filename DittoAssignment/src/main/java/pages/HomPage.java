package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomPage {

	WebDriver driver;

	public HomPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains(text(),'HDFC Life Click 2 Protect Supreme Plus')])[1]")
	public static WebElement HDFCLife;

	@FindBy(xpath  =  "//h1[text()='Understand your policy']")
	public static WebElement Understand_your_policy;
//	
	@FindBy(xpath = "(//span[contains(@class,'mantine-Text-root') and contains(text(),'Click 2 Protect Supreme Plus')])[1]")
	public static WebElement Smart_Total_Elite_Protection;
//
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public static WebElement Next;
//
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	public static WebElement Continue;
//
	@FindBy(xpath = "//h1[contains(text(),'Tell us about you')]")
	public static WebElement TellUsAboutYou;
	
	@FindBy(xpath = "//label[contains(text(),'Your gender')]")
	public static WebElement your_gender ;

	@FindBy(xpath = "//span[contains(text(),'Male')]")
	public static WebElement male ;
	
	@FindBy(xpath = "//label[contains(text(),'Your date of birth')]")
	public static WebElement Your_DOB;
	
	@FindBy(xpath = "//input[@placeholder='DD/MM/YYYY']")
	public static WebElement YourDOB_Field;
	
	
	@FindBy(xpath = "//label[contains(text(),'Have you smoked in the last 24 months?')]")
	public static WebElement HaveYouSmocked;
	
	@FindBy(xpath = "//label[contains(text(),'Have you smoked in the last 24 months?')]//following::span[contains(text(),'No')][1]")
	public static WebElement HaveYouSmoked_No;
	
	
	@FindBy(xpath = "//span[contains(text(),'Begin New Quote')]")
	public static WebElement Begin_New_Quote;
	
	@FindBy(xpath = "//label[contains(text(),'Do you have diabetes?')]")
	public static WebElement You_diabetes;
	
	
	@FindBy(xpath = "//label[contains(text(),'Do you have diabetes?')]//following::span[contains(text(),'No')][1]")
	public static WebElement You_diabete_No;
	
	@FindBy(xpath = "//label[contains(text(),'Are you an NRI?')]")
	public static WebElement YouNRI;
	
	@FindBy(xpath = "//label[contains(text(),'Are you an NRI?')]//following::span[contains(text(),'No')][1]")
	public static WebElement YouNRI_No;
//
	@FindBy(xpath = "(//span[contains(text(),'Next step')])[1]")
	public static WebElement NextStep;
	
	@FindBy(xpath = "//h1[contains(text(),'A bit about your lifestyle')]")
	public static WebElement ABitOfYourLifeStyle;
	
	@FindBy(xpath = "//label[contains(text(),'Are you an existing customer of Ditto?')]")
	public static WebElement customer_of_Ditto;
	
	@FindBy(xpath = "(//span[contains(text(),'No')])[1]")
	public static WebElement customerOfDittoNo ;

	@FindBy(xpath = "//label[contains(text(),'Where do you live?')]")
	public static WebElement WhereDoYouLive ;
//	
	@FindBy(css = "input[name='pincode']")
	public static WebElement pincode ;
//	
	@FindBy(xpath = "//label[contains(text(),'Education')]")
	public static WebElement Education ;
//	
	@FindBy(css = "input[placeholder='Education']")
	public static WebElement EducationFeild ;
	
	@FindBy(xpath  = "//span[contains(text(),'Post Graduate')]")
	public static WebElement PostGraduate ;
	
//	
	@FindBy(xpath = "//label[contains(text(),'Salaried')]")
	public static WebElement Salaried ;
	

	@FindBy(xpath = "//label[contains(text(),'Salaried')]//following::span[contains(text(),'Yes')][1]")
	public static WebElement SalariedYes ;
//	
	@FindBy(xpath = "//label[contains(text(),'Annual Income')]")
	public static WebElement Annual_Income ;
//	
	@FindBy(css  = "input[name='annInc']")
	public static WebElement AnnualIncomeField ;
//	
	@FindBy(xpath = "//label[contains(text(),'Monthly Expenses')]")
	public static WebElement Monthly_Expenses;
//	
	@FindBy(css = "input[name='mExpenses']")
	public static WebElement MonthlyExpensesField ;
//
	@FindBy(xpath = "//h1[contains(text(),'Recommended Cover')]")
	public static WebElement RecommendedCover ;
//	
	@FindBy(xpath = "//input[@id='mantine-rvom3lufo']")
	public static WebElement CoverTill ;
	
	@FindBy(xpath = "//span[contains(text(),'Cover Amount (for your family)')]//following::button[1]")
	public static WebElement FiftyL;
	
	@FindBy(xpath = "//span[contains(text(),'Cover Amount (for your family)')]//following::button[2]")
	public static WebElement TenL;
	
	
	@FindBy(xpath = "//span[contains(text(),'Cover Amount (for your family)')]//following::span[4]")
	public static WebElement CoverAmount ;
//
	@FindBy(xpath = "//span[contains(text(),'Base Premium')]//following::span[1]")
	public static WebElement BasePremium;
//	
	@FindBy(xpath = "//span[contains(text(),'Total')]//following::span[1]")
	public static WebElement TotalPerYear;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
//	
//	@FindBy(xpath = "//span[contains(text(),'Male')]")
//	public static WebElement male ;
	
//
//	@FindBy(id = "password")
//	public static WebElement password;
//
//	@FindBy(id = "loginBtn")
//	public static WebElement loginButton;
//
//	@FindBy(xpath = "//span[text()='Hotels']")
//	public static WebElement Hotels;

//    public void enterUsername(String user) {
//
//        username.sendKeys(user);
//    }

//	public void enterPassword(String pass) {
//
//		password.sendKeys(pass);
//	}
//
//	public void clickLogin() {
//
//		loginButton.click();
//	}
}