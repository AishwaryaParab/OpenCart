package opencart.pages;

import java.time.Duration;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartPage {
	private WebDriver driver;
	private String baseurl="http://localhost/upload/index.php?route=common/home&language=en-gb";
    Logger log= Logger.getLogger("devpinoyLogger");

	public CartPage(WebDriver driver){
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		log.debug("Cart Class initialized");
	}
	
	
	public void addToCartUsingIcon(List<String> path) {
		log.debug("To add items to cart using icon");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Assert.assertEquals(driver.getTitle().toString(), "Your Store");
	    
	       js.executeScript("window.scrollBy(0,550)", "");
	       log.debug("Scrolled to the items to be added");
	       

		log.debug("Iterate through the list of items");
		for(String i:path) {
	       try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	       
		WebElement btnAddToCart = driver.findElement(By.xpath(i));
		log.debug("Finding the Add to Cart icon");
		
		btnAddToCart.click();
		log.debug("Add to Cart icon pressed");
		
	}
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    js.executeScript("window.scrollBy(0,-550)", "");
	    log.debug("Scroll to Top of the homepage");
	    
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
				
	}
	
	public void addItemToCartAfterViewing(String item, String qty, String color) {
		driver.get(baseurl);
		log.debug("to view item specification before adding to cart");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Assert.assertEquals(driver.getTitle().toString(), "Your Store");
	    log.debug("Home page opened");
		
		log.debug("Scrolled down to the item to be selected");
       js.executeScript("window.scrollBy(0,600)", "");
	
       try {
    	   Thread.sleep(500);
       } catch (InterruptedException e) {
    	   e.printStackTrace();
       }

	    log.debug("finding the item to be added to the cart after viewing");  
	    
	    
//		WebElement canonCamSpec = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[4]/form/div/div[2]/div[1]/h4/a"));
		WebElement itemSpec = driver.findElement(By.linkText(item));
		
		itemSpec.click();
		log.debug("clicked on the item");
		if((driver.getTitle().toString()).equals("sdf"))
		{
			log.debug("Item specification Page opened");
			js.executeScript("window.scrollBy(0,380)", "");
			log.debug("Scrolled down to fill details");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Select colSelect = new Select(driver.findElement(By.xpath("//*[@id='input-option-226']")));
			colSelect.selectByVisibleText(color);
			log.debug("Selected color of the item");
			
			driver.findElement(By.xpath("//*[@id='input-quantity']")).clear();
			driver.findElement(By.xpath("//*[@id='input-quantity']")).sendKeys(qty);
			log.debug("enter the quantity of the item");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.debug("finding add to cart button");
			driver.findElement(By.xpath("//*[@id='button-cart']")).click();
			log.debug("Add to cart button clicked");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}
		
		if((driver.getTitle().toString()).equals(item))
		{
			js.executeScript("window.scrollBy(0,380)", "");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			driver.findElement(By.xpath("//*[@id='input-quantity']")).clear();
			driver.findElement(By.xpath("//*[@id='input-quantity']")).sendKeys(qty);
			log.debug("enter the quantity of the item");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.debug("finding add to cart button");
			driver.findElement(By.xpath("//*[@id='button-cart']")).click();
			log.debug("Add to cart button clicked");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}	
		}
		
		 js.executeScript("window.scrollBy(0,-550)", "");
		    
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
	}
	
	public void removeItem() {
		log.debug("to remove an item from cart");
	    JavascriptExecutor js = (JavascriptExecutor) driver;	
	    js.executeScript("window.scrollBy(0,-600)", "");
	    log.debug("scroll up to the view item button");
	    try {
	    	Thread.sleep(500);
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    log.debug("find view items button");

		WebElement tapOnCart = driver.findElement(By.xpath("//*[@id='header-cart']/div/button"));		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tapOnCart.click();
		log.debug("clicked on view items");
		
		log.debug("finding remove from cart button");
		driver.findElement(By.xpath("//*[@id='header-cart']/div/ul/li/table/tbody/tr[1]/td[5]/form/button")).click();
		log.debug("clicked remove item from cart button");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("1 item removed from the cart");

	}
	

	public void closeBrowser() {
		driver.close();
	}
}
