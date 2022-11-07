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


public class EditAccountPage {
	private WebDriver driver;
	Setup setupPage;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	@FindBy(xpath = "//input[@name='firstname']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//a[@class='list-group-item'][contains(text(), 'Edit Account')]")
	@CacheLookup
	WebElement editBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	@CacheLookup
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
	WebElement result;
	
	public EditAccountPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		setupPage = new Setup(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void editFirstName(String firstName) throws Exception {
		editBtn.click();
		setupPage.logger("Edit Account Button clicked");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\beforeFirstNameEdit_");
		this.firstName.clear();
		setupPage.logger("Old First Name cleared");
		
		this.firstName.sendKeys(firstName);
		setupPage.logger("New First Name entered");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\afterFirstNameEdit_");
	}
	
	public void editLastName(String lastName) throws Exception {
		editBtn.click();
		setupPage.logger("Edit Account Button clicked");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\beforeLastNameEdit_");
		this.lastName.clear();
		setupPage.logger("Old Last Name cleared");
		
		this.lastName.sendKeys(lastName);
		setupPage.logger("New Last Name entered");

		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\afterLastNameEdit_");
	}
	
	public void editEmail(String email) throws Exception {
		
		editBtn.click();
		setupPage.logger("Edit Account Button clicked");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\beforeEmailEdit_");
		this.email.clear();
		setupPage.logger("Old Email cleared");
		
		this.email.sendKeys(email);
		setupPage.logger("New Email entered");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\afterEmailEdit_");
	}
	
	
	
	public void closeBrowser() throws Exception {
		setupPage.scroll(0, 150);
		
		continueBtn.click();
		
		Thread.sleep(2000);
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\EditAccountImgs\\AccountEdited_");
		
		String expectedResult = "Success: Your account has been successfully updated.";
		String actualResult = result.getText();
		Assert.assertEquals(actualResult,expectedResult);
		
		driver.quit();
	}
}