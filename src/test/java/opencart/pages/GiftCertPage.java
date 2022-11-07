package opencart.pages;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Setup;

public class GiftCertPage {
	WebDriver driver;
	Setup setupPage;
	private String baseFilePath = "C:\\Users\\Administrator\\Documents\\OpenCartTestImages";
	
	public GiftCertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		setupPage = new Setup(driver);
	}
	
	@FindBy(xpath="//a[starts-with(text(),'Gift')]")
	WebElement giftBtn;
	
	@FindBy(id="input-to-name")
	WebElement recNameInp;
	
	@FindBy(id="input-to-email")
	WebElement recEmailInp;
	
	@FindBy(id="input-from-name")
	WebElement nameInp;
	
	@FindBy(id="input-from-email")
	WebElement emailInp;
	
	@FindBy(id = "input-theme-7")
	WebElement birthdayBtn;
	
	@FindBy(id = "input-theme-6")
	WebElement christmasBtn;
	
	@FindBy(id = "input-theme-8")
	WebElement generalBtn;
	
	@FindBy(id = "input-message")
	WebElement msgInp;
	
	@FindBy(id = "input-amount")
	WebElement amtInp;
	
	@FindBy(name = "agree")
	WebElement agreeBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@id='content']/p")
	WebElement purchaseSucc;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	public void fillGiftCertificate(String recName, String recEmail, String name, String email, String choice, String message, String amount) throws Exception {		
		setupPage.scroll(0, 500);
		
		setupPage.logger("Home Page Opened.");
		
		giftBtn.click();
		
		setupPage.logger("Gift Certificate link clicked.");
		
		recNameInp.sendKeys(recName);
		setupPage.logger("Recipient Name Entered.");
		
		recEmailInp.sendKeys(recEmail);
		setupPage.logger("Recipient Email Entered.");
		
		nameInp.sendKeys(name);
		setupPage.logger("From Name Entered.");
		
		emailInp.sendKeys(email);
		setupPage.logger("From Email Entered.");
		
		if(choice.equalsIgnoreCase("birthday")) {
			birthdayBtn.click();
		}
		else if(choice.equalsIgnoreCase("christmas")) {
			christmasBtn.click();
		}
		else if(choice.equalsIgnoreCase("general")) {
			generalBtn.click();
		}
		else {
			Assert.assertEquals(true, "Invalid checkbox selected!");
		}
		
		setupPage.logger("Gift Certificate Theme selected");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\GiftCertificateImgs\\beforeSubmitForm1_");
		
		setupPage.scroll(0, 150);
		
		msgInp.sendKeys(message);
		setupPage.logger("Message Entered");
		
		amtInp.clear();
		amtInp.sendKeys(amount);
		setupPage.logger("Amount Entered");
		
		agreeBtn.click();
		setupPage.logger("Agree Button selected");
		
		Thread.sleep(1000);
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\GiftCertificateImgs\\beforeSubmitForm2_");
		
		submitBtn.click();
		setupPage.logger("Submit Button Clicked");
		
		Thread.sleep(1000);
		
		String expectedTitle = "Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.";
		
		Assert.assertEquals(purchaseSucc.getText(), expectedTitle);
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\GiftCertificateImgs\\afterSubmitForm1_");
		
		continueBtn.click();
		setupPage.logger("Continue Button Clicked");
		
		setupPage.takeScreenshot(driver, baseFilePath + "\\GiftCertificateImgs\\afterSubmitForm2_");
	}
}

