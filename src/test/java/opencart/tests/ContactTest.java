package opencart.tests;

import java.io.BufferedReader;


import org.testng.annotations.Test;

import opencart.pages.ContactPage;
import utilities.Setup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class ContactTest {
	ContactPage mycontact;
	WebDriver driver;
	Setup setupPage;
	
	  @DataProvider(name="contactDetails")
	  public String[][] getContactDetails() throws IOException {
		String[][] details = new String[3][3];
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Documents\\Java for Selenium\\ContactDetails.csv"));
		String newLine;
		int i=0;
		while((newLine=br.readLine()) != null) {
			String[] user = newLine.split(",");
			
			//populating details
			for(int j=0; j<3; j++) {
				details[i][j] = user[j];
			}
			
			i++;	
		}
		
		return details;
	  }
	
  @Test(dataProvider="contactDetails")
  public void contactTest(String name, String email, String enquiry) throws InterruptedException, IOException
  {
	  mycontact.contact(name,email,enquiry);
	  
  }
  @BeforeMethod
  
  public void beforeMethod() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  mycontact = new ContactPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  mycontact.closeBrowser();
	  //System.out.println("Done");
  }

}

//public class LoginTest {
//	LoginPage myLogin;
//	WebDriver driver;
//	  @Test
//	  public void loginPageTest() throws InterruptedException {
//		  myLogin.login("temp@gmail.com", "admin");
//	  }
//	  @BeforeMethod
//	  public void beforeMethod() {
//		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
//		  driver = new ChromeDriver();
//		  driver.get(baseUrl);
//		  myLogin = new LoginPage(driver);
//	  }
//
//	  @AfterMethod
//	  public void afterMethod() throws InterruptedException {
//		  myLogin.closeBrowser();
//	  }
//
//
//}