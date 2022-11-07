package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import opencart.pages.GiftCertPage;
import opencart.pages.LoginPage;
import opencart.pages.LogoutPage;
import utilities.Setup;

public class GiftCertTest {
	WebDriver driver;
	
	GiftCertPage gift;
	LoginPage myLogin;
	
	String csvPath = "C:\\Users\\Administrator\\Documents\\Java for Selenium\\giftDetails.csv";
	Setup setupPage;
	
	@BeforeTest
	public void setUp() throws Exception {
		  setupPage = new Setup(driver);
		  driver = setupPage.browserSetup("chrome");
		  setupPage.getDriverSetup();
		  gift = new GiftCertPage(driver);
	}
	
  @Test
  public void fillGiftCert() throws Exception {
	  String recName = "";
	  String recEmail = "";
	  String name = "";
	  String email = "";
	  String choice = "";
	  String message = "";
	  String amount = "";
	  
	  String[][] data = setupPage.readCSV(csvPath);
	  
	  for(String[] row: data) {
		 recName = row[0];
		 recEmail = row[1];
		 name = row[2];
		 email = row[3];
		 choice = row[4];
		 message = row[5];
		 amount = row[6];
		 gift.fillGiftCertificate(recName, recEmail, name, email, choice,message, amount);
	  }
	  
  }
  
  @AfterTest
  public void tearDown() throws InterruptedException {
//	  Thread.sleep(5000);
	  driver.quit();
  }
}