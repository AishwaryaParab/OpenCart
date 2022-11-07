package opencart.pages;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Setup;


public class ComparePage {
	
WebDriver driver;
Setup setupPage;
String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	@FindBy(name="search")
	WebElement search;
	
	@FindBy(xpath="//*[@id='search']/button")
	WebElement button;
	
	@FindBy(xpath="//*[@id='product-list']/div/form/div/div[2]/div[2]/button[3]")
	WebElement compareBtn;
	
	@FindBy(xpath="//*[@id='compare-total']")
	WebElement finalCompare;
	
	@FindBy(linkText="Remove")
	WebElement removeBtn;
	
	
	public JavascriptExecutor j;
	
	public ComparePage(WebDriver driver) {
		this.driver=driver;
		j=(JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);
		setupPage = new Setup(driver);
	}
	
	
	public void scrollDown(int n) {
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,5)","");
		}
	}
	
	public void compareProducts(String item1,String item2) throws IOException, InterruptedException {
		 search.click();
		  search.sendKeys(item1);
		  button.click();
		  scrollDown(200);
		  Assert.assertTrue(compareBtn.isDisplayed());
		  compareBtn.click();
		  scrollUp(200);
		  search.clear();
		  
		  
		  search.sendKeys(item2);
		  Thread.sleep(3000);
		  button.click();
		  scrollDown(200);
		  Assert.assertTrue(compareBtn.isDisplayed());
		  compareBtn.click();
		  scrollUp(200);
		  
		
		  Assert.assertTrue(finalCompare.isDisplayed());
		  
		  finalCompare.click();
		  Thread.sleep(3000);
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CompareImgs\\compare_");
		  String expectedTitle="Product Comparison";
		  String currentTitle=driver.getTitle();
		  assertEquals(currentTitle,expectedTitle);
	}
	
	public void RemoveProductFromCompare() {
		
		removeBtn.click();
	}
	
	public void scrollUp(int n) {
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,-5)","");
		}
	}
}

