package opencart.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Setup;

public class Wishlist {
	WebDriver driver;
	String url = "http://localhost/upload/";
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	JavascriptExecutor js;
	Setup setupPage;
	
	@FindBy(partialLinkText = "Wish List")
	@CacheLookup
	WebElement wishlistnav;
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
    @CacheLookup
    WebElement myAccount;
    
    @FindBy(xpath = "//a[@class='dropdown-item'][contains(text(), 'Login')]")
    @CacheLookup
    WebElement loginBtn;
    
    @FindBy(xpath = "//input[@name = 'email']")
    @CacheLookup
    WebElement emailBox;
    
    @FindBy(xpath = "//input[@name = 'password']")
    @CacheLookup
    WebElement passwordBox;
    
    @FindBy(xpath="//button[contains(text(),'Login')]")
    @CacheLookup
    WebElement loginSubmit;
    
    @FindBy(xpath="//button[@aria-label='Add to Cart']")
    @CacheLookup
    WebElement addToCartbtn;
    
    @FindBy(xpath="//button[@data-bs-original-title = 'Add to Wish List']")
    @CacheLookup
    WebElement addToWishbtn;
    
    @FindBy(xpath="//p[contains(text(), \"Your wish list is empty\")]")
    @CacheLookup
    WebElement emptyWishlist;
    
//    @FindBy(xpath="//button[@data-bs-original-title = 'Remove']")
//    @CacheLookup
//    WebElement removeItem;

	
	public Wishlist(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		setupPage = new Setup(driver);
	}
	
	public void displayWishlist(String email, String password) throws InterruptedException, IOException {
		wishlistnav.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Login
		
		if(driver.getTitle().equals("Account Login")) {
			emailBox.sendKeys(email);
			passwordBox.sendKeys(password);
			            
			loginSubmit.click();
		}
				
		//logged in successfully
		
		
		try {
			String msg = driver.findElement(By.xpath("//div[@id='wishlist']/p")).getText();
			
			//screenshot of empty wishlist
			setupPage.takeScreenshot(driver, baseFilePath + "\\WishlistImgs\\emptyWishlist_");
			
			System.out.println(msg);
		} catch(NoSuchElementException e) {
			System.out.println("Items are present in the wishlist.");
			
			//screenshot of the entire wishlist
			setupPage.takeScreenshot(driver, baseFilePath + "\\WishlistImgs\\displayWishlist_");
			
			WebElement table = driver.findElement(By.tagName("table"));
			
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("The number of rows are: " + rows.size());
			
			List<WebElement> cols = table.findElements(By.xpath("//table/thead/tr/td"));
			System.out.println("The number of columns are: " + cols.size());
			
			
			for(WebElement row: rows) {
				System.out.println();
				for(WebElement col : row.findElements(By.tagName("td"))) {
					System.out.printf("%25s ", col.getText());
				}
				System.out.println();
			}
		}
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 600)");
	}
	
	
	//adding to cart when item exists in the wishlist
	public void addToCartFromWish(String email, String password) throws InterruptedException, IOException {
	
		wishlistnav.click();
		
		//Login
		
		if(driver.getTitle().equals("Account Login")) {
			   emailBox.sendKeys(email);	            
	           passwordBox.sendKeys(password);

	           loginSubmit.click();
		}
		
		//logged in successfully
		
		if(driver.findElement(By.xpath("//div[@id='wishlist']/div/table")).isDisplayed()) {
			System.out.println("Item present in the wishlist.");
			
			//as element is not interactable
			WebElement add = driver.findElement(By.xpath("//button[@class='btn btn-primary' and @title='Add to Cart']"));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", add);
			
			//screenshot of adding to cart
			setupPage.takeScreenshot(driver, baseFilePath + "\\WishlistImgs\\addToCartFromWishlist_");
			
			driver.navigate().refresh();
		}
	}
	
	
	//removing item from the wishlist
	public void removeWishlist(String email, String password) throws InterruptedException, IOException {
		wishlistnav.click();
		
		//Login
		
		if(driver.getTitle().equals("Account Login")) {
			emailBox.sendKeys(email);			            			            
			passwordBox.sendKeys(password);
			            
			loginSubmit.click();
		}
				
		//logged in successfully
		
		if(driver.findElement(By.xpath("//div[@id='wishlist']/div/table")).isDisplayed()) {
			System.out.println("Item present in the wishlist.");
			
			//as element is not interactable
			WebElement remove = driver.findElement(By.xpath("//button[@title='Remove']"));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", remove);
			
			//screenshot of removing an item
			setupPage.takeScreenshot(driver, baseFilePath + "\\WishlistImgs\\removeWishlist_");
		}
	}
	
	
	public void wishlistItem(String email, String password) throws InterruptedException, IOException {
		
		wishlistnav.click();
		
		//Login
		
		if(driver.getTitle().equals("Account Login")) {
			emailBox.sendKeys(email);
			passwordBox.sendKeys(password);
		
			loginSubmit.click();
		}
						
		//logged in successfully
		
		
		//if wishlist is empty
		
		if(emptyWishlist.isDisplayed()) {
			driver.findElement(By.xpath("//li[@class='breadcrumb-item']/a")).click();
			
			if(driver.getTitle().equals("Your Store")) {
//				System.out.println("I'm in Your Store");
				
//				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0, 600)");
			}
			
			List<WebElement> products = driver.findElements(By.xpath("//div[@class='description']/h4"));
			
			for(WebElement product : products) {
				System.out.println(product.getText());
			}
			
			driver.findElement(By.linkText("MacBook")).click();
			driver.findElement(By.xpath("//button[@class='btn btn-light'][1]")).click();
			
			js.executeScript("window.scrollBy(0, 300)");
			
			//screenshot of adding item to wishlist
			setupPage.takeScreenshot(driver, baseFilePath + "\\WishlistImgs\\addToWishlist_");
		}		
	}
	
	
	public void wishlistItems(String email, String password, String itemName) throws InterruptedException {
			
		wishlistnav.click();
			
		//Login
			
		if(driver.getTitle().equals("Account Login")) {
			emailBox.sendKeys(email);
			passwordBox.sendKeys(password);
			
			loginSubmit.click();
		}
							
		//logged in successfully
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[1]/a")).click();

		if(driver.getTitle().equals("Your Store")) {
//			System.out.println("I'm in Your Store");
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0, 600)");
		}

		driver.findElement(By.linkText("iPhone")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-light'][1]")).click();
	}		
	
	
	 public void closeBrowser() {
	        driver.quit();
	 }

	
}
