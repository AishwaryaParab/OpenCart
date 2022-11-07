package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.AccountPage;
import opencart.pages.AffiliatePage;
import opencart.pages.LoginPage;
import utilities.Setup;

//import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;

public class AffiliateTest {
	AffiliatePage affiliateTest;
	LoginPage myLogin;
	AccountPage accountTest;
	WebDriver driver;
	Setup setupPage;
	
  @Test(priority=3)
  public void editAddAffiliateBankTransfer() throws Exception {	//For Bank Transfer payment method
	  myLogin.loginSuccess("demo@gmail.com", "1234"); //Login to account
//	  Thread.sleep(7000);
	  accountTest.goToRegisterAffiliatePage(driver);
	  affiliateTest.enterAffiliateDetails("Persistent Systems Limited", "www.google.com", "12335", "Bank Transfer","BOB", "ABA2002", "swift1000", "RamusDafg", "12345637822");
//	  Thread.sleep(10000);
  }
  
  
  @Test(priority=1)
  public void editAddAffiliateCheque() throws Exception { //for Cheque payment method
	  myLogin.loginSuccess("demo@gmail.com", "1234"); //Login to account
	  accountTest.goToRegisterAffiliatePage(driver);
	  affiliateTest.enterAffiliateDetails("Persistent Systems Limited", "www.google.com", "12335", "Cheque", "Ramanand");
  }
  
  @Test(priority=2)
  public void editAddAffiliatePayPal() throws Exception { //for PayPal payment method
	  myLogin.loginSuccess("demo@gmail.com", "1234"); //Login to account
	  accountTest.goToRegisterAffiliatePage(driver);
	  affiliateTest.enterAffiliateDetails("Persistent Systems Limited", "www.google.com", "12335", "PayPal", "Ramanand@gmail.com");
  }
  
  
  @BeforeMethod
  public void beforeTest() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  setupPage.getDriverSetup();
	  myLogin = new LoginPage(driver);
	  affiliateTest = new AffiliatePage(driver);
	  
	  setupPage.logger("Initialised");
	  
	  accountTest = new AccountPage(driver);

  }

  @AfterMethod
  public void afterTest() throws InterruptedException {
	  //Thread.sleep(7000);
	  driver.quit();
  }

}

