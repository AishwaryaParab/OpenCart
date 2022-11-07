package opencart.pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import utilities.Setup;

import org.apache.log4j.Logger;


public class SearchPage {

	WebDriver driver;
	
	@FindBy(name="search")
	WebElement search;
	
	@FindBy(tagName="h4")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\'product-list\']/div/form/div/div[2]/div[1]/p")
	WebElement details;
	
	@FindBy(xpath="//*[@id='product-list']/div/form/div/div[2]/div[1]/div/span[1]")
	WebElement price;
	
	@FindBy(xpath="//*[@id='search']/button")
	WebElement button;
	
	@FindBy(id="input-sort")
	WebElement sort;
	
	public JavascriptExecutor j;
	Logger log = Logger.getLogger("devpinoyLogger");
	String productName;
	String description;
	String productPrice;
	
	Setup setupPage;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		j=(JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);
		setupPage = new Setup(driver);
	}
	

	
	String title="Search - ";
	public void SearchInPage(String Product) throws IOException {
		
		search.click();
		log.debug("Search Box clicked");
		
		
		log.debug("Entering Product Name");
		search.sendKeys(Product);
		
		button.click();
		log.debug("Product Searched Successfully");
		
		scrollDown(100);
		setupPage.takeScreenshot(driver, baseFilePath + "\\SearchingImgs\\searching_");
		log.debug("Screenshot taken Successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		productName=name.getText();
		description=details.getText();
		productPrice=price.getText();
		
		Assert.assertEquals(driver.getTitle() ,title+Product); //Assert title of page
		log.debug("Product Title page asserted Successfully");
		Assert.assertTrue(search.isDisplayed());
		log.debug("Search Box Asserted Successfully");
		Assert.assertTrue(button.isDisplayed());
		log.debug("Search Button Asserted Successfully");
		
	
		System.out.println("Product Name: "+productName);
		System.out.println("Product Discription: " +description);
		System.out.println("Product Price: "+productPrice);
		
		scrollUp(100);
		search.clear();
		
		
		
	}
	public void filter() {
		Select filtering =new Select(sort);
		filtering.selectByVisibleText("Price (High > Low)");
		log.debug("Filter Button Clicked Suss");
	}
	
	public void scrollDown(int n) {
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,5)","");
		}
	}
	
	public void scrollUp(int n) {
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,-5)","");
		}
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	
	
}
