package opencart.tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import opencart.pages.browsing;
import utilities.Setup;

//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class browsingTest {
	private WebDriver driver;
	browsing mybrowsing;
	Setup setupPage;
	
  @Test(priority = 0)
  public void testBrowse() throws InterruptedException, IOException {
	  mybrowsing.browse();
  }
  
  @Test(priority = 1)
  public void testDesktopTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseDesktopTab();
  }
  
  @Test(priority = 2)
  public void testLaptopTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseLaptopTabs();
  }  
  
  @Test(priority = 3)
  public void testComponentTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseComponentTab();
  }
  
  @Test(priority = 4)
  public void testTabletsTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseTablets();
  }
  
  @Test(priority = 5)
  public void testSoftwareTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseSoftware();
  }
  
  @Test(priority = 6)
  public void testPhonesTab() throws InterruptedException, IOException
  {
	  mybrowsing.browsePhones();
  }
  
  
  @Test(priority = 7)
  public void testCamerasTab() throws InterruptedException, IOException
  {
	  mybrowsing.browseCameras();
  }
  
  @Test(priority = 8)
  public void testMp3Tab() throws InterruptedException, IOException
  {
	  mybrowsing.browseMP3();
  }
  
  @Test(priority = 9)
  public void testHomePage() throws InterruptedException, IOException
  {
	  mybrowsing.browseHomPage();
  }
  
  @BeforeTest
  public void beforeMethod() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  mybrowsing = new browsing(driver);
  }

  @AfterTest
  public void afterMethod() {
	  mybrowsing.closeBrowser();
  }

}
