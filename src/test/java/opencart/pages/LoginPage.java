package opencart.pages;

import java.time.Duration;

import javax.imageio.ImageIO;

import java.io.File;
import org.openqa.selenium.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Setup;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoginPage {
	static Logger log = Logger.getLogger("devpinoyLogger");
	Setup setupPage;
	
	private WebDriver driver;
	
	String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
//	static int count = 1;
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][contains(text(), 'Login')]")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@name = 'email']")
	@CacheLookup
	WebElement emailBox;
	
	@FindBy(xpath = "//input[@name = 'password']")
	@CacheLookup
	WebElement passwordBox;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement loginSubmit;
	
	@FindBy(id="alert")
	@CacheLookup
	WebElement alert;
	
	public LoginPage(WebDriver driver) {
//		String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.debug("Opened OpenCart");
		setupPage = new Setup(driver);
	}
	
//	public static void takeSnapShot(String fileWithPath) throws Exception{
//		 // This code will capture screenshot of current screen      
//        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//        // This will store screenshot on Specific location
//        ImageIO.write(image, "png", new File(fileWithPath)); 
//        log.debug("Screenshot taken");
//    }

	
	public void loginSuccess(String email, String password) throws Exception {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			myAccount.click();
			log.debug("MyAccount Link Clicked");
			
			loginBtn.click();
			log.debug("Login Link Clicked");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			log.debug("Page scrolled");
			
			emailBox.sendKeys(email);
			log.debug("Email Entered");
			
			passwordBox.sendKeys(password);
			log.debug("Password Entered");
			
			setupPage.takeScreenshot(driver, baseFilePath + "\\LoginImgs\\beforelogin_");
			
			loginSubmit.click();
			log.debug("Login Button Clicked");
			
			
			Thread.sleep(2000);
			setupPage.takeScreenshot(driver, baseFilePath + "\\LoginImgs\\afterlogin_");
			
			String expectedResult = "My Account";
			String actualResult = driver.getTitle();
			Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void loginFailure(String email, String password) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		myAccount.click();
		log.debug("MyAccount Link Clicked");
		
		loginBtn.click();
		log.debug("Login Link Clicked");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		log.debug("Page scrolled");
		
		emailBox.sendKeys(email);
		log.debug("Email Entered");
		
		passwordBox.sendKeys(password);
		log.debug("Password Entered");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\LoginImgs\\beforelogin_");
		
		loginSubmit.click();
		log.debug("Login Button Clicked");
		
		
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\LoginImgs\\afterlogin_");
		
		String expectedResult = "Warning: No match for E-Mail Address and/or Password.";
		String actualResult = alert.getText();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void closeBrowser() {
		driver.quit();
		log.debug("Browser quit");
	}

}
