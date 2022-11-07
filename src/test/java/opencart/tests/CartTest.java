package opencart.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import opencart.pages.CartPage;
import opencart.pages.LoginPage;
import utilities.Setup;
import opencart.pages.CartNavigation;
//import opencart.pages.Utility;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTest {
	CartPage cart;
	CartNavigation nav;
	WebDriver driver;
	LoginPage loginPage;
	Setup setupPage;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	private String baseUrl = "http://localhost/upload/";


  @Test(priority = 1)
  public void addToCartUsingIcon() throws Exception {
	  driver.get(baseUrl);
	  loginPage.loginSuccess("ramanant75@gmail.com", "ramu123");
	  nav.HomePage();
	  
	  ArrayList<String> path = new ArrayList<String>();
	  path.add("//*[@id=\"content\"]/div[2]/div[1]/form/div/div[2]/div[2]/button[1]");
	  path.add("//*[@id=\"content\"]/div[2]/div[2]/form/div/div[2]/div[2]/button[1]");
	  cart.addToCartUsingIcon(path);
	  try {
		 setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\afterAddingtoCart_");
	} catch (IOException e) {
		e.printStackTrace();
	}

  }
  
  @Test(priority = 2)
  public void viewCart1() {
	  nav.viewCart();
	  try {
		setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\viewCart1_");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 3)
  public void ContinueShopping() {
	  nav.continueShopping();
	  try {
		setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\clickContinueShopping_");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 4)
  public void AddToCartAfterViewing1() {
	  String color = "Blue";
	  String qty = "2";
	  String item = "Canon EOS 5D";
	  
	  cart.addItemToCartAfterViewing(item, qty, color);
	  try {
		setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\addingfromItemSpec_");
	} catch (IOException e) {
		e.printStackTrace();
	}

  }
  
  
  
  @Test(priority = 5)
  public void AddToCartAfterViewing2() {
	  String qty = "1";
	  String item = "iPhone";
	  
	  cart.addItemToCartAfterViewing(item, qty, null);
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\addingfromItemSpec_");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  
  
  @Test(priority = 6)
  public void AddToCartAfterViewing3() {
	  String qty = "1";
	  String item = "MacBook";
	  
	  cart.addItemToCartAfterViewing(item, qty, null);
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\addingfromItemSpec_");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  
  @Test(priority = 7)
  public void viewCart2() {
	  nav.viewCart();
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\viewCart_");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 8)
  public void RemoveFromCart() {
	  cart.removeItem();
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\removeCart_");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
 
  
  @Test(priority = 9)
  public void viewItem() {
	  nav.viewItems();
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\viewItem_");
	} catch (IOException e) {
				e.printStackTrace();
	}
  }
  
  @Test(priority = 10)
  public void CheckoutPage() {
	  nav.goToCheckOutPage();
	  try {
		  setupPage.takeScreenshot(driver, baseFilePath + "\\CartImgs\\checkoutPage_");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  cart = new CartPage(driver);
	  nav = new CartNavigation(driver);

	  loginPage = new LoginPage(driver);
  }

  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(5000);
	  cart.closeBrowser();
  }

}