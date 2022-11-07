package opencart.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

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

public class SubscriptionPage {
	private WebDriver driver;
	
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
	
	
	@FindBy(xpath = "//input[@name = 'newsletter']")
	@CacheLookup
	WebElement checkBox;
	

	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement submit;
	
	
	
	public SubscriptionPage(WebDriver driver) {
//		String baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email, String password) throws InterruptedException {
			myAccount.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			loginBtn.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			emailBox.sendKeys(email);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			passwordBox.sendKeys(password);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			loginSubmit.click();
			Thread.sleep(3000);
			
			//Newsletter Subscription code
			
			driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
			
			checkBox.click();
			
		
			
			submit.click();
			
			Thread.sleep(3000);
			
			
	}
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
	    Date d = new Date();
	    String FileName = d.toString().replace(":", "_").replace(" ", "_");
	    
	    //Call getScreenshotAs method to create image file
	    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	    
	    //Move image file to new destination
	    File DestFile = new File("C:\\Users\\Administrator\\Documents\\OpenCartTestImages\\ContactImages\\contact_"+FileName+".png");
	    
	    
	    FileHandler.copy(SrcFile, DestFile);
	}
	
	public void closeBrowser() {
		driver.quit();
	}  
}
