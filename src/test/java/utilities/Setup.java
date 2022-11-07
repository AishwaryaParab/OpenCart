package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Setup {

	private String baseUrl = "http://localhost/upload/";
	private WebDriver driver;
	JavascriptExecutor js;
	
	public Setup(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public WebDriver browserSetup(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//Opera Driver shows deprecated
		
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		return driver;
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
	
	public void scroll(int up, int down) {
        js.executeScript("window.scrollBy(" + up + "," + down + ")","");
    }
	
	public void logger(String log) {
		Logger.getLogger("group_04_opencart").debug(log);
	}
	
	public void getDriverSetup() {
		String baseUrl = "http://localhost/upload/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	 public String[][] readCSV(String filename) throws CsvValidationException, IOException {
		 CSVReader csvRead1 = new CSVReader(new FileReader(filename));
		 String[] rowData = null;
		 int row = 0;
		 while((rowData = csvRead1.readNext()) != null) {
			 row++;
		 }
		 String[][] data = new String[row][];
		 int i = 0;
		 
		 CSVReader csvRead2 = new CSVReader(new FileReader(filename));
		 while((rowData = csvRead2.readNext()) != null) {
			 data[i] = rowData;
			 i++;
		 }
		 
		 return data;
	 }
}
