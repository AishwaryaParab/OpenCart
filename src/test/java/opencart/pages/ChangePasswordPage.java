package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Setup;

public class ChangePasswordPage {
	WebDriver driver;
	Setup setupPage;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	@FindBy(xpath = "//a[@class='list-group-item'][contains(text(),'Password')]")
	@CacheLookup
	WebElement passwordBtn;
	
	@FindBy(id="input-password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="input-confirm")
	@CacheLookup
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary'][contains(text(),'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	WebElement result;
		
		public ChangePasswordPage(WebDriver driver) {
//			driver = new ChromeDriver();
//			driver.get(baseUrl);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			setupPage = new Setup(driver);
		}
		
		public void changePassword(String password, String confirmPassword) throws Exception {
			
			passwordBtn.click();
			setupPage.logger("Change Password Button Clicked");
			
			this.password.sendKeys(password);
			setupPage.logger("Password Entered");
			
			this.confirmPassword.sendKeys(confirmPassword);
			setupPage.logger("Confirm Password Entered");
			
			setupPage.takeScreenshot(driver, baseFilePath + "\\ChangePassImgs\\beforeChangePass_");
			
			continueBtn.click();
			setupPage.logger("Continue Button Clicked");
			Thread.sleep(2000);
			String expectedResult = "Success: Your password has been successfully updated.";
			String actualResult = result.getText();
			
			Assert.assertEquals(actualResult,expectedResult);
			
			setupPage.takeScreenshot(driver, baseFilePath + "\\ChangePassImgs\\afterChangePass_");
		}
		
		
		public void closeBrowser() {
			driver.quit();
		}
}