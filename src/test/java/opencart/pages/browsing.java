package opencart.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Setup;

public class browsing {
	private WebDriver driver;
	private String baseUrl;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	private Actions action;
	private JavascriptExecutor j;
	Logger log;
	Setup setupPage;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[1]/a/i")
	WebElement contactUs;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span")
	WebElement myAccount;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement register;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a")
	WebElement login;

	@FindBy(id = "wishlist-total")
	WebElement wishlist;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[4]/a")
	WebElement shoppingCart;

	@FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[5]/a")
	WebElement checkout;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/a")
	WebElement desktopTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[1]/a")
	WebElement pc;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement mac;

	@FindBy(linkText = "iMac")
	WebElement imac;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/div/div/a[1]/img")
	WebElement image;

	@FindBy(xpath = "/html/body/div[2]/div/button[2]")
	WebElement forwardbtn;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/button")
	WebElement closebtn;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[2]/a")
	WebElement laptopsTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[2]/div/a")
	WebElement showAllLaptops;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[3]/a")
	WebElement componentsTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[4]/a")
	WebElement tabletsTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[5]/a")
	WebElement softwareTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[6]/a")
	WebElement phoneTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[7]/a")
	WebElement cameraTab;

	@FindBy(xpath = "//*[@id=\"narbar-menu\"]/ul/li[8]/a")
	WebElement mp3Tab;
	

	public browsing(WebDriver driver)
	{
		baseUrl = "http://localhost/upload/index.php?route=common/home&language=en-gb";
		this.driver = driver;
		action = new Actions(driver);
		j = (JavascriptExecutor)driver;
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
		log = Logger.getLogger("devpinoyLogger");
		setupPage = new Setup(driver);
	}


	public void browse() throws IOException, InterruptedException 
	{
		Assert.assertTrue(contactUs.isDisplayed());
		Assert.assertTrue(myAccount.isDisplayed());
		Assert.assertTrue(wishlist.isDisplayed());
		Assert.assertTrue(shoppingCart.isDisplayed());
		Assert.assertTrue(checkout.isDisplayed());
		
		Assert.assertTrue(desktopTab.isDisplayed());
		Assert.assertTrue(laptopsTab.isDisplayed());
		Assert.assertTrue(componentsTab.isDisplayed());
		Assert.assertTrue(tabletsTab.isDisplayed());
		Assert.assertTrue(softwareTab.isDisplayed());
		Assert.assertTrue(phoneTab.isDisplayed());
		Assert.assertTrue(cameraTab.isDisplayed());
		Assert.assertTrue(mp3Tab.isDisplayed());
		
		
		//System.out.println(driver.getTitle());
		log.debug(driver.getTitle());

		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		
		
		contactUs.click();
		//System.out.println(driver.getTitle());
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//driver.navigate().back();


		myAccount.click();
		register.click();
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		myAccount.click();
		login.click();
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//driver.navigate().back();

		wishlist.click();
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//driver.navigate().back();

		shoppingCart.click();
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//driver.navigate().back();

		checkout.click();
		log.debug(driver.getTitle());
		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//driver.navigate().back();
	}



	public void browseDesktopTab() throws InterruptedException, IOException
	{
		log.debug(driver.getTitle());
		action.moveToElement(desktopTab).perform();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		action.moveToElement(pc).perform();

		action.moveToElement(mac).perform();
		//			
		//action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/div/a"))).perform();

		mac.click();

		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(100);

		imac.click();

		log.debug(driver.getTitle());	

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(100);

		image.click();

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		forwardbtn.click();

		Thread.sleep(2000);

		closebtn.click();

		scrollSmoothUp(100);

		driver.navigate().back();

		driver.navigate().back();

		log.debug(driver.getTitle());

		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}


	public void browseLaptopTabs() throws IOException, InterruptedException
	{
		//laptops & notebooks	
		//System.out.println("Home Page");
		//			
		action.moveToElement(laptopsTab).perform();

		//action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[2]/div/div/ul/li[1]/a"))).perform();
		//			
		//action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[2]/div/div/ul/li[2]/a"))).perform();
		//			
		//action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[2]/div/a"))).perform();

		showAllLaptops.click();

		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
					
		scrollSmoothDown(1000);
		scrollSmoothUp(1000);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}

	public void browseComponentTab() throws InterruptedException, IOException
	{
		//			components
		log.debug(driver.getTitle());
		//			
		action.moveToElement(componentsTab).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[1]/a"))).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[2]/a"))).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[3]/a"))).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[4]/a"))).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/div/ul/li[5]/a"))).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/a"))).perform();
		//			
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[3]/div/a")).click();

		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//			
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ul/li[2]/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(1000);
		scrollSmoothUp(1000);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}

	public void browseTablets() throws InterruptedException, IOException
	{
		log.debug(driver.getTitle());
					
		action.moveToElement(tabletsTab).perform();
					
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[4]/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
					
		scrollSmoothDown(500);
		scrollSmoothUp(500);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}

	public void browseSoftware() throws InterruptedException, IOException 
	{
		log.debug(driver.getTitle());
		//			
		action.moveToElement(softwareTab).perform();
		//			
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[5]/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//			
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}


	public void browsePhones() throws InterruptedException, IOException
	{
		log.debug(driver.getTitle());
		//			
		action.moveToElement(phoneTab).perform();
		//			
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[6]/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//			
		scrollSmoothDown(500);
		scrollSmoothUp(500);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}

	public void browseCameras() throws InterruptedException, IOException
	{
		log.debug(driver.getTitle());
		//			
		action.moveToElement(cameraTab).perform();
		//			
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[7]/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");
		//			
		scrollSmoothDown(500);
		scrollSmoothUp(500);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();
	}

	public void browseMP3() throws InterruptedException, IOException
	{
		log.debug(driver.getTitle());
		//			
		action.moveToElement(mp3Tab).perform();
		//			
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[1]/li[1]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[2]/li[1]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[2]/li[2]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[2]/li[3]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[2]/li[4]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/div/ul[2]/li[5]/a"))).perform();

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/a"))).perform();
		//			
		driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[8]/div/a")).click();
		log.debug(driver.getTitle());

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(1000);
		scrollSmoothUp(1000);
		driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a/i")).click();

	}



	public void browseHomPage() throws InterruptedException, IOException
	{
		//homepage
		log.debug(driver.getTitle());
		scrollSmoothDown(550);			
		WebElement mac1 = driver.findElement(By.linkText("MacBook"));

		//			j.executeScript("arguements[0].scrollIntoView();",element);


		mac1.click();

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(700);
		scrollSmoothUp(700);

		driver.navigate().back();


		scrollSmoothDown(550);			
		WebElement iphone = driver.findElement(By.linkText("iPhone"));
		iphone.click();

		Thread.sleep(2000);
		setupPage.takeScreenshot(driver, baseFilePath + "\\BrowsingImgs\\browsing_");

		scrollSmoothDown(150);

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/div/a[1]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/button")).click();

		scrollSmoothUp(150);

		driver.navigate().back();

		scrollSmoothUp(150);

	}

	public void scrollSmoothDown(int n){
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,5)","");
		}
	}

	public void scrollSmoothUp(int n){
		for(int i=0;i<n;i++) {
			j.executeScript("window.scrollBy(0,-5)","");
		}
	}


	public void closeBrowser()
	{
		driver.quit();
	}
}

