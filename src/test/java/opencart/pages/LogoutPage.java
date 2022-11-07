package opencart.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myAcc;
	
	@FindBy(xpath="//a[contains(text(),'Logout')][@class='dropdown-item']")
	WebElement logoutBtn;
	
	public LogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void logout() throws InterruptedException {
		myAcc.click();
		logoutBtn.click();
		Thread.sleep(3000);
	}
}

