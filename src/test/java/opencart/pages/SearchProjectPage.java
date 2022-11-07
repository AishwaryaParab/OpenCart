package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProjectPage {
	private WebDriver driver; 
	private Boolean searchFieldPresent, searchButtonPresent;
	private String baseUrl = "https://icahn.mssm.edu/search";
	JavascriptExecutor js;
	
	@FindBy(id = "glosr-input")
	private WebElement searchField;
	
	@FindBy(id = "glosr-submit-btn")
	private WebElement searchButton;
	
	@FindBy(id = "glosr-search-info")
	private WebElement searches;
	
	@FindBy(id = "glosr-no-results")
	private WebElement noResults;
	
	@FindBy(id = "glosr-show-more")
	private WebElement showMoreBtn;
	
	public SearchProjectPage(WebDriver driver) {
		this.driver = driver;
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	public void getPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "search | Icahn School of Medicine";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void searchDisplay() {
		searchFieldPresent = searchField.isDisplayed();
		searchButtonPresent = searchField.isDisplayed();
		
		Assert.assertTrue(searchFieldPresent, "Search field is present.");
		Assert.assertTrue(searchButtonPresent, "Search button is present.");	
	}
	
	public void emptySearch() {
		if(!searchButton.isEnabled()) {
			System.out.println("The search button is disabled for an empty input");
		}
	}
	
	public void searchValidData() {
		searchField.sendKeys("Research institutes in Medicine");
		searchButton.click();
		
		String expectedResult = "Showing 10 results of about 2753 for Research institutes in Medicine.";
		String actualResult = searches.getText();
		
		System.out.println(expectedResult);
		System.out.println(actualResult);
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void searchInvalidData() {
		searchField.sendKeys("red velvet");
		searchButton.click();
		
		String actualResult = noResults.getText();
		
//		System.out.println(actualResult);
	}
	
	public void showMoreDisplay() {
		searchField.sendKeys("Research institutes in Medicine");
		searchButton.click();
		
		js.executeScript("window.scrollBy(0, 500)","");
		
		showMoreBtn.click();
//		System.out.println(actualResult);
	}
	
}
