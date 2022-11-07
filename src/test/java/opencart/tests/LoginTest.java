package opencart.tests;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import utilities.Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginTest {
	LoginPage myLogin;
	WebDriver driver;
	Setup setupPage;
	
	@DataProvider(name="account-details")
	public String[][] getLoginDetails(){
		String[][] details = new String[3][2];
		details[0][0] = "temp@gmail.com";
		details[0][1] = "admin";
		
		details[1][0] = "temp1@gmail.com";
		details[1][1] = "admin1";
		
		details[2][0] = "temp2@gmail.com";
		details[2][1] = "admin2";
		
		return details;
	}
	
	  @Test(dataProvider = "account-details")
	  public void Test1(String email, String password) throws Exception {
		  myLogin.loginSuccess(email, password);
	  }
	  
	  @Test
	  public void Test2() throws Exception {
		  myLogin.loginFailure("unknown@gmail.com", "unknown");
	  }
	  
	  //passing empty fields
	  @Test
	  public void Test3() throws Exception {
		  myLogin.loginFailure(" ", " ");
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		  setupPage = new Setup(driver);
		  driver = setupPage.browserSetup("chrome");
		  driver.get(baseUrl);
		  //Maximize current window
		  driver.manage().window().maximize();
		  myLogin = new LoginPage(driver);
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  myLogin.closeBrowser();
	  }
}

