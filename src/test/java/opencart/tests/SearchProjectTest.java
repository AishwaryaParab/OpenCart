package opencart.tests;

import org.testng.annotations.Test;

import opencart.pages.SearchProjectPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SearchProjectTest {
	
	private WebDriver driver;
	SearchProjectPage searchPage;
	

  @Test
  public void Test1() {
	  searchPage.getPageTitle();
  }

  @Test
  public void Test2() {
	  searchPage.searchDisplay();
  }
	
	@Test
	public void Test3() {
		searchPage.emptySearch();
	}
 
  @Test
  public void Test4() {
	  searchPage.searchValidData();
  }
  
  @Test
  public void Test5() {
	  searchPage.searchInvalidData();
  }

	
  @Test
  public void Test6() {
	  searchPage.showMoreDisplay();
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  searchPage = new SearchProjectPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
