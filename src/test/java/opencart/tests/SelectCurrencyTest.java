package opencart.tests;

import org.testng.annotations.Test;
import opencart.pages.SelectCurrencyPage;
import utilities.Setup;

import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SelectCurrencyTest {
	WebDriver driver;
	String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	SelectCurrencyPage selectCurrency;
	Setup setupPage;
	
	 @BeforeMethod
	  public void setUp() throws Exception {
		  setupPage = new Setup(driver);
		  driver = setupPage.browserSetup("chrome");
		  setupPage.getDriverSetup();
		  selectCurrency = new SelectCurrencyPage(driver);
	  }
	 
  @Test(priority = 1)
  public void selectEuroTest() throws Exception {
	  selectCurrency.changeCurrencyToEuro();
	 
  }
  
  @Test(priority = 2)
  public void selectUSDollar() throws Exception {
	  selectCurrency.changeCurrencyToUSDollar();
  }

  @Test(priority = 3)
  public void selectPoundTest() throws Exception {
	  selectCurrency.changeCurrencyToPound();
  }
 
  @AfterMethod
  public void tearDown() throws Exception {
	  selectCurrency.closeBrowser();
  }

}