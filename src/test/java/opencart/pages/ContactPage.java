package opencart.pages;


import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Setup;

public class ContactPage {
	Setup setupPage;
	private WebDriver driver;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	Logger log;
	
	@FindBy(linkText = "Contact Us")
	@CacheLookup
	WebElement contact;
	
	@FindBy(css = "input[name='name']")
	@CacheLookup
	WebElement name;
	
	@FindBy(css = "input[name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(css = "textarea[name='enquiry']")
	@CacheLookup
	WebElement enquiry;
	
	@FindBy(css = "button[type='submit']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(linkText = "Continue")
	@CacheLookup
	WebElement continueElement;


public ContactPage(WebDriver driver)
{
	String baseUrl = "http://localhost/upload/";
	this.driver = driver;
	driver.get(baseUrl);
	PageFactory.initElements(driver, this);
	log = Logger.getLogger("devpinoyLogger");
	setupPage = new Setup(driver);
}


public void contact(String contactName, String contactEmail,String contactEnquiry) throws InterruptedException, IOException
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0 ,1000)");
	Thread.sleep(100);
	contact.click();
	Thread.sleep(100);

	name.sendKeys(contactName);
	email.sendKeys(contactEmail);
	enquiry.sendKeys(contactEnquiry);
//	js.executeScript("window.scrollBy(0 ,100)");
//	Thread.sleep(100);
//	name.sendKeys("Urvi Naik");
//	Thread.sleep(100);
//	email.sendKeys("naikurvi@yahoo.com");
//	Thread.sleep(100);
//	enquiry.sendKeys("Within how many days will the product be delivered?");
//	Thread.sleep(100);
	submit.click();
	Thread.sleep(10000);
	setupPage.takeScreenshot(driver, baseFilePath + "\\ContactImgs\\contact_");
	continueElement.click();
	Thread.sleep(1000);

}

public void closeBrowser() {
	driver.quit();
}
}

//
//public void login(String email, String password) throws InterruptedException {
//		myAccount.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		loginBtn.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		emailBox.sendKeys(email);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		
//		passwordBox.sendKeys(password);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		
//		loginSubmit.click();
//		Thread.sleep(5000);
//}
//
//public void closeBrowser() {
//	driver.quit();
//}
//
//}
//public static void takeSnapShot(String fileWithPath) throws Exception{
//    // This code will capture screenshot of current screen      
//   BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//   // This will store screenshot on Specific location
//   ImageIO.write(image, "png", new File(fileWithPath)); 
//   log.info("Screenshot taken");
//}

//package c_testng;
//import java.io.File;
//import java.io.IOException;
//
//
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//
//
//import jxl.*;
//import jxl.read.biff.BiffException;
//
//
//
//
//
//
//
//public class YahooLogin {
//
//
//
//
//
//  public static void main(String[] args) throws BiffException, IOException, InterruptedException {
//        // TODO Auto-generated method stub
//        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Administrator\\Documents\\javaExample.xls"));
//        Sheet sheet = workbook.getSheet("chilly");
//        String username = sheet.getCell(0,0).getContents();
//        String password = sheet.getCell(1,0).getContents();
//        
////        Thread.sleep(1000);
//         WebDriver driver = new ChromeDriver();
//            driver.get("https://login.yahoo.com/");
//            
//            WebElement usernameField = driver.findElement(By.cssSelector("div.input-group>input"));
//            usernameField.sendKeys(username);
//            usernameField.submit();
//            
//            Thread.sleep(3000);
//            
//            System.out.println(driver.getTitle());
//            
//            WebElement passwordField = driver.findElement(By.cssSelector("div#password-container>input"));
//            passwordField.sendKeys(password);
//            
//            driver.findElement(By.cssSelector("div.button-container>button")).click();
//            
//            driver.findElement(By.cssSelector("a[id='ymail']")).click();
//            
//            driver.findElement(By.cssSelector("a[role='button']")).click();
//            
//            driver.findElement(By.xpath("//input[@role='combobox' and @id='message-to-field']")).sendKeys("naikurvi@yahoo.com");
//            
//            driver.findElement(By.cssSelector("input[placeholder='Subject']")).sendKeys("Selenium");
//            
//            Thread.sleep(2000);
//            
//            //driver.findElement(By.cssSelector("div[role='textbox']")).sendKeys("Urvii you're the sweetest");
//            
//            //driver.findElement(By.xpath("//button[@title='Send this email']")).click();
//            
//            //driver.findElement(By.cssSelector("img[alt='Profile image']")).click();
//            
//            new Actions(driver).moveToElement(driver.findElement(By.cssSelector("img[alt='Profile image']"))).perform();
//            
//            Thread.sleep(3000);
//            
//           //driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
//           new Actions(driver).moveToElement(driver.findElement(By.linkText("Sign out"))).click().build().perform();
//           
//           Alert alert = driver.switchTo().alert();
//           alert.accept();
//            
//        
//                Thread.sleep(3000);
//                driver.quit();
//                workbook.close();
//        
//
//
//
//
//
//  }
//
//
//
//
//
//}

