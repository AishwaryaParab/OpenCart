package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Setup;

public class AccountPage {
	WebDriver driver;
	Setup setupPage;
	
	@FindBy(xpath="//a[@class='list-group-item'][4]")
	@CacheLookup
	WebElement addressBookPageLink;
	
	@FindBy(xpath="//a[text()='Edit your affiliate information']")
	@CacheLookup
	WebElement goToEditAffiliate;
	
	@FindBy(xpath="//a[text()='Register for an affiliate account']")
	@CacheLookup
	WebElement goToRegAffiliate;
	
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		setupPage = new Setup(driver);
	}
	
	public void goToRegisterAffiliatePage(WebDriver driver) {
		this.driver=driver;
		setupPage.scroll(0, 350);
//		WebElement goToEditAffiliate = driver.findElement(By.xpath("//a[text()='Edit your affiliate information']"));
//		if (!goToEditAffiliate.isDisplayed()) {
////			WebElement goToRegAffiliate = driver.findElement(By.xpath("//a[text()='Register for an affiliate account']"));
//			goToRegAffiliate.click(); }
//		else {
//			goToEditAffiliate.click();}
		
		try{
            driver.findElement(By.xpath("//a[text()='Edit your affiliate information']"));
            //Since, no exception, so element is present
            goToEditAffiliate.click();
           }
           catch(NoSuchElementException e){
            //Element is not present
               goToRegAffiliate.click();}
		}

	
	public void goToAddressBookPage(WebDriver driver) {
		addressBookPageLink.click();
	}
}
