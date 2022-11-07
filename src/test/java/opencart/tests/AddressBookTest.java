package opencart.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import opencart.pages.AccountPage;
import opencart.pages.AddressBookPage;
import opencart.pages.LoginPage;
import opencart.pages.LogoutPage;

import utilities.Setup;

public class AddressBookTest {
	AddressBookPage addressTest;
	LoginPage loginTest;
	AccountPage accountTest;
	LogoutPage logoutTest;
	WebDriver driver;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	Setup setupPage;
	
  @Test
  public void editAddAddressInAddressBook() throws Exception {
	  CSVReader CSVLoginRead = new CSVReader(new FileReader("C:\\Users\\Administrator\\Documents\\Java for Selenium\\Login.csv"));
	  CSVReader CSVAddressBookread = new CSVReader(new FileReader("C:\\Users\\Administrator\\Documents\\Java for Selenium\\AddressBook.csv"));
	  String[] row1 = null;	//login credentials
	  String[] row2 = null;	//addressbook credentials
	  while(((row1 = CSVLoginRead.readNext())!=null)&&((row2 = CSVAddressBookread.readNext())!=null)) {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("http://localhost/upload/");
		  loginTest = new LoginPage(driver);
		  addressTest = new AddressBookPage(driver);
		  accountTest = new AccountPage(driver);
		  logoutTest = new LogoutPage(driver);
		 
		  loginTest.loginSuccess(row1[0], row1[1]);	//Login into account

		  @SuppressWarnings("removal")
		Integer stringToInteger = new Integer(row2[9]);
	      int z=stringToInteger.intValue();
	      accountTest.goToAddressBookPage(driver);	//navigates from account page to address book page
		  addressTest.addNewAddress();	//adds new address
		  addressTest.enterAddressBookDetails(row2[0],row2[1], row2[2], row2[3], row2[4], row2[5], row2[6],row2[7], row2[8],z);
		  Thread.sleep(1000);
		 
		  setupPage.takeScreenshot(driver, baseFilePath + "\\AddressBookImgs\\afterAddingAddressBook_");
		  logoutTest.logout();
	  }
	  
//	  accountTest.goToAddressBookPage(driver);	//navigates from account page to address book page
//	  addressTest.addNewAddress();	//adds new address
	  //addressTest.enterAddressBookDetails("Saisha","Parab", "PSL", "Mapusa Guirim", "Bardez Goa", "Mapusa", "403506", "India", "Goa", 0);
  }
  
  @BeforeTest
  public void beforeTest() throws Exception {	  
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //driver.get("http://localhost/OpenCart/index.php?route=common/home&language=en-gb");
	  loginTest = new LoginPage(driver);
	  addressTest = new AddressBookPage(driver);
	  accountTest = new AccountPage(driver);

	  logoutTest = new LogoutPage(driver);
	  driver.manage().window().maximize();
  }
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  //Thread.sleep(7000);
	  driver.quit();
  }
}
