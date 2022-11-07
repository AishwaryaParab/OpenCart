package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverSetup {

	private String baseUrl = "http://localhost/upload/";
	private WebDriver driver;
	
	public DriverSetup(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver setUp(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.get(baseUrl);
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//			driver.get(baseUrl);
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
//			driver.get(baseUrl);
		}
		
		//Opera Driver shows deprecated
		
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		return driver;
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public void takeScreenshot(WebDriver driver, String filepath) throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		
		String timestamp = time.toString().replace(":", "").replace(" ", "_");
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				
		//Move image file to new destination
		File DestFile = new File(filepath + timestamp + ".png");
		FileHandler.copy(SrcFile, DestFile);
	}
}
