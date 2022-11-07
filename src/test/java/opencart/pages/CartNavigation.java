package opencart.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartNavigation {
	private WebDriver driver;
	private String baseurl;
	Logger log= Logger.getLogger("devpinoyLogger");
	
	public CartNavigation(WebDriver driver) {
		log.debug("Navigation Class Initialized");
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

	}

	public void HomePage(){
		baseurl ="http://localhost/upload/";
		driver.get(baseurl);
		log.debug("Open cart homepage is opened");
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
	}
	
	public void viewCart() {
		log.debug("To view Cart");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("finding view cart button");
		driver.findElement(By.xpath("//*[@id='top']/div/div[2]/ul/li[4]/a")).click();
		log.debug("clicked view cart button");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        log.debug("scrolled to view items in cart");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Assert.assertEquals(driver.getTitle(), "Shopping Cart");
	}
	
	public void goToCheckOutPage() {
		log.debug("to visit checkout page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-550)", "");
		log.debug("Scroll up the page");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("find checkout page link");
        driver.findElement(By.xpath("//*[@id='top']/div/div[2]/ul/li[5]/a")).click();
        if((driver.getTitle().toString()).equals("Shopping Cart")) {
        	log.debug("Cart is empty hence cannot CheckOut");
        }
        else {	
	        Assert.assertEquals(driver.getTitle(), "Checkout");
	        log.debug("opened checkout page");
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
	
	public void continueShopping() {
        Assert.assertEquals(driver.getTitle(), "Shopping Cart");
        log.debug("To continue shopping");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("clicking continue shopping button");
		driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/a")).click();
		log.debug("Migrates to the home page");
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
	}
	
	public void viewItems() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		log.debug("To view items in cart on current page");
		log.debug("find view item button");
		WebElement tapOnCart = driver.findElement(By.xpath("//*[@id='header-cart']/div/button"));	
		Assert.assertEquals(true, tapOnCart.isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tapOnCart.click();
		log.debug("Clicked on the view item button");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}