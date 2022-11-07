package opencart.tests;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import opencart.pages.Wishlist;
import utilities.Setup;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {
	Wishlist wish;
	Setup setupPage;
	WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	@BeforeSuite
	 public void setup() {
	  htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	 }
	 
	
	@AfterSuite
	 public void tearDown() {
		 extent.flush();
	 }
	

  @Test(priority=1)
  public void Test1() throws InterruptedException, IOException {
	  ExtentTest test1 = extent.createTest("Add Item to New Wishlist");
	  wish.wishlistItem("aishwaryaparab1@gmail.com", "aish123890");
	  test1.pass("New item added to the wishlist");
  }
	
  @Test(priority=2)
  @Parameters("itemName")
  public void Test2(String itemName) throws InterruptedException {
	  ExtentTest test2 = extent.createTest("Add another item to Wishlist");
	  wish.wishlistItems("aishwaryaparab1@gmail.com", "aish123890", itemName);
	  test2.pass("Added another item to the wishlist successfully");
  }
  
  @Test(priority=3)
  public void Test3() throws InterruptedException, IOException {
	  ExtentTest test3 = extent.createTest("Remove an item from Wishlist");
	  wish.removeWishlist("aishwaryaparab1@gmail.com", "aish123890");
	  test3.pass("Removed item from the wishlist");
  }
  
  @Test(priority=4)
  public void Test4() throws InterruptedException, IOException {
	  ExtentTest test4 = extent.createTest("Display Wishlist");
	  wish.displayWishlist("aishwaryaparab1@gmail.com", "aish123890");
	  test4.pass("Displayed wishlist successfully");
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  wish = new Wishlist(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  wish.closeBrowser();
  }

}
