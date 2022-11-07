package opencart.pages;

import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utilities.Setup;

import org.apache.log4j.Logger;



public class RegisterPage {
	private WebDriver driver;
	private Boolean firstnamePresent, lastnamePresent, emailBoxPresent, passwordBoxPresent, agreementPresent, continuePresent;
	private String baseUrl = "http://localhost/upload/";
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	Logger log;
//	private static int count = 1;  for unique screenshots
	
	Setup setupPage;
	
	
	@FindBy(xpath="//input[@name='agree']")
	@CacheLookup
	WebElement agreement;
	
	@FindBy(xpath="//input[@name='firstname']")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement emailBox;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement passwordBox;
	
	@FindBy(xpath="//button[contains(text(), 'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	
	@FindBy(xpath="//div[@id='content']/h1")
	@CacheLookup
	WebElement confirm;
	
	
	@FindBy(id="alert")
	@CacheLookup
	WebElement alert;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log = Logger.getLogger("devpinoyLogger");
		setupPage = new Setup(driver);
	}
	
	public void registerDisplay() {
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
		driver.findElement(By.linkText("Register")).click();
		
		
		firstnamePresent = firstname.isDisplayed();
		lastnamePresent =  lastname.isDisplayed();
		emailBoxPresent =  emailBox.isDisplayed();
		passwordBoxPresent = passwordBox.isDisplayed();
		agreementPresent = agreement.isDisplayed();
		continuePresent = continueBtn.isDisplayed();
		
		Assert.assertTrue(firstnamePresent, "First Name field is present.");
		Assert.assertTrue(lastnamePresent, "Last Name field is present.");
		Assert.assertTrue(emailBoxPresent, "E-mail field is present.");
		Assert.assertTrue(passwordBoxPresent, "Password field is present.");
		Assert.assertTrue(agreementPresent, "Agreement checkbox is present.");
		Assert.assertTrue(continuePresent, "Continue button is present.");
	}
	
//	public void registerSuccess() throws InterruptedException, IOException, CsvValidationException {
//		String csvFilename = "C:\\Users\\Administrator\\Documents\\Java for Selenium\\userDetails.csv";
//		  
//		CSVReader csvRead = new CSVReader(new FileReader(csvFilename));
//		  
//		String[] row = null;
//		  
//		while((row = csvRead.readNext()) != null) {
//			driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
//			driver.findElement(By.linkText("Register")).click();
//			
//			//screenshot of the Registration Page
//			takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\beforeRegister_");
//			  
//			String fName = row[0];
//			String lName = row[1];
//			String email = row[2];
//			String password = row[3];
//			  
//			firstname.sendKeys(fName);
//			lastname.sendKeys(lName);
//			emailBox.sendKeys(email);
//			passwordBox.sendKeys(password);
//			
//			if(!agreement.isSelected()){
//				agreement.click();
//			}
//			  
//			//screenshot of the details
//			takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\RegisterDetails_");
//			
//			continueBtn.click();
//			Thread.sleep(5000);
//			
//			String expectedResult = "Your Account Has Been Created!";
//			
//			//screenshot after successful registration
//			takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\afterRegister_");
//			
//			String actualResult = confirm.getText();
//			
//			Assert.assertEquals(actualResult, expectedResult);
//			
//			driver.get(baseUrl);
//		}	  
//	}
	
	
	public void registerSuccess(String fName, String lName, String email, String password) throws InterruptedException, IOException, CsvValidationException {
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
		driver.findElement(By.linkText("Register")).click();
			
		//screenshot of the Registration Page
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\beforeRegister_");
			  
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
			
		if(!agreement.isSelected()){
			agreement.click();
		}
			  
		//screenshot of the details
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\RegisterDetails_");
			
		continueBtn.click();
		Thread.sleep(5000);
			
		String expectedResult = "Your Account Has Been Created!";
			
		//screenshot after successful registration
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\afterRegister_");
			
		String actualResult = confirm.getText();
			
		Assert.assertEquals(actualResult, expectedResult);	
		log.debug("Registration done successfully.");
	}
	
	public void registerWarning(String fName, String lName, String email, String password) throws InterruptedException, IOException {
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();
		driver.findElement(By.linkText("Register")).click();
		
		//screenshot of the Registration Page
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\beforeRegister_");
		
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		
		if(!agreement.isSelected()){
			agreement.click();
		}
		  
		//screenshot of the details
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\RegisterDetails_");
		
		continueBtn.click();
		Thread.sleep(5000);
		
		String expectedResult = "Warning: E-Mail Address is already registered!";
		
		String actualResult = alert.getText();
		
		//screenshot after successful registration
		setupPage.takeScreenshot(driver, baseFilePath + "\\RegisterImgs\\afterRegister_");
		
		Assert.assertEquals(actualResult, expectedResult);
		log.debug("Registration Failure.");
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
