package opencart.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.exceptions.CsvValidationException;

import opencart.pages.RegisterPage;
import utilities.Setup;

public class RegisterTest {
	RegisterPage myRegisterPage;
	Setup setupPage;
	WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	@BeforeSuite
	 public void setup() {
	  htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	 }
	 
	
	@AfterSuite
	 public void tearDown() {
		 extent.flush();
	 }
	
	
// Reading .csv file using BufferedReader and DataProvider annotation
	
  @DataProvider(name="userDetails")
  public String[][] getRegisterDetails() throws IOException {
	String[][] details = new String[4][4];
	
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Documents\\Java for Selenium\\userDetails.csv"));
	String newLine;
	int i=0;
	while((newLine=br.readLine()) != null) {
		String[] user = newLine.split(",");
		
		//populating details
		for(int j=0; j<4; j++) {
			details[i][j] = user[j];
		}
		
		i++;	
	}
	
	return details;
  }

  
//  DataProvider with hard-coded data
  
//  @DataProvider(name="userDetails")
//	public String[][] getRegisterDetails(){
//		String[][] details = new String[3][2];
//		details[0][0] = "Aishwarya";
//		details[0][1] = "Parab";
//		details[0][2] = "aishwaryaparab1@gmail.com";
//		details[0][3] = admin123;
  
//		details[1][0] = "Sridhar";
//		details[1][1] = "Maskeri";
//		details[1][2] = "sridharmaskeri@gmail.com";
//		details[1][3] = admin123;

//		return details;
//	}

	
  @Test(dataProvider="userDetails")
  public void Test1(String firstname, String lastname, String email, String password) throws InterruptedException, IOException, CsvValidationException {
	  ExtentTest test = extent.createTest("Successful Register Test");
	  myRegisterPage.registerSuccess(firstname, lastname, email, password);
	  test.pass("Registered Successfully.");
  }
  
  @Test(dataProvider="userDetails")
  public void Test2(String firstname, String lastname, String email, String password) throws InterruptedException, IOException, CsvValidationException {
	  ExtentTest test = extent.createTest("Register Warning Test");
	  myRegisterPage.registerWarning(firstname, lastname, email, password);
	  test.pass("Registration Error.");
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  myRegisterPage = new RegisterPage(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @AfterMethod
  public void afterMethod() {
	  myRegisterPage.closeBrowser();
  }
}
