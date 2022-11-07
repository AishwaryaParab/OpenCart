package opencart.tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import opencart.pages.SearchPage;
import utilities.Setup;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class SearchTest {
	WebDriver driver;
	Setup setupPage;
	String url="http://localhost/upload/index.php?route=common/home&language=en-gb";

	SearchPage display;

	WebElement searchh;
	String productName;
	String description;
	String price;

	
	@BeforeTest
	public void setUp() throws Exception {

		setupPage = new Setup(driver);
		driver = setupPage.browserSetup("chrome");
		driver.get(url);
		driver.manage().window().maximize();
		display = new SearchPage(driver);
	}


	@Test(dataProvider="search-details",priority=0)
	
	public void Operation(String product) throws IOException, InterruptedException {

		
		display.SearchInPage(product);

	}
	
	@Test(priority=1)
	public void Filtering() {
		display.filter();
	}
	//  @DataProvider(name="search-details")
	//  public String[][] getSearchDetails(){
	//	  
	//	  String[][] details= new String[3][1];
	//	  details[0][0] = "Iphone";
	//	  details[1][0] = "Macbook";
	//	  details[2][0] = "Nikon";
	//	  
	//	  return details;
	//  }
	@DataProvider(name="search-details")
	public Object[][] loginData() {
		Object[][] arrayObject = display.getExcelData("C:\\Users\\Administrator\\Documents\\Java for Selenium\\Search.xls","Sheet1");
		return arrayObject;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

