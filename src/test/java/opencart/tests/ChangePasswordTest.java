package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.ChangePasswordPage;
import opencart.pages.LoginPage;
import utilities.Setup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ChangePasswordTest {
	ChangePasswordPage changePass;
	LoginPage loginPage;
	WebDriver driver;
	Setup setupPage;

  @BeforeMethod
  public void beforeMethod() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  setupPage.getDriverSetup();
	  changePass = new ChangePasswordPage(driver);
	  loginPage = new LoginPage(driver);
  }

  @Test(dataProvider = "changepass-details")
  public void changePasswordPageTest(String pass, String confPass) throws Exception {
	  loginPage.loginSuccess("temp@gmail.com", "admin");
	  changePass.changePassword(pass, confPass);
  }
  
  @DataProvider(name="changepass-details")
  public String[][] getDetails(){
	  String[][] details = new String[1][2];
	  details[0][0] = "admin1";
	  details[0][1] = "admin1";
	  return details;
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}