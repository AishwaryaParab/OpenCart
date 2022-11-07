package opencart.tests;

import org.testng.annotations.Test;


import opencart.pages.SubscriptionPage;
import utilities.Setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.apache.log4j.Logger;

public class SubscriptionTest {
	SubscriptionPage myLogin;
	WebDriver driver;
	Setup setupPage;
	Logger log = Logger.getLogger("devpinoyLogger");
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	  @Test
	  public void loginPageTest() throws InterruptedException, IOException {
		  myLogin.login("Raj@gmail.com", "password");
		  
		  setupPage.takeScreenshot(driver, baseFilePath + "\\SubscriptionImgs\\subscribe_");
		  log.debug("Taking Screenshot");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  String baseUrl = "http://localhost/upload/";
		  setupPage = new Setup(driver);
		  driver = setupPage.browserSetup("chrome");
		  driver.get(baseUrl);
		  myLogin = new SubscriptionPage(driver);	 
		  
		 log.debug("Logging in");
		 
		 log.debug("News letter subscribed");
		  
	  }

	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  myLogin.closeBrowser();
		  log.debug("Closing Browser");
		  
		  
	  }


}

