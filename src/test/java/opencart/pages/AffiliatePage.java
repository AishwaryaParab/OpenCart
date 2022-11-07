package opencart.pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Setup;

public class AffiliatePage {
	Setup setupPage;
	WebDriver driver;
	
	
	@FindBy(xpath="//a[text()='Edit your affiliate information']")
	@CacheLookup
	WebElement goToRegAffiliate;

//	
	@FindBy(id="input-company")
	@CacheLookup
	WebElement enterCompanyName;
	
	@FindBy(xpath="//input[@id='input-website']")
	@CacheLookup
	WebElement enterCompanyWebsiteUrl;
	
	@FindBy(xpath="//input[@id='input-tax']")
	@CacheLookup
	WebElement enterTaxID;
	
	@FindBy(xpath="//input[@id='input-cheque']")
	@CacheLookup
	WebElement chequePayee;
	
	@FindBy(xpath="//input[@id='input-paypal']")
	@CacheLookup
	WebElement paypalEmail;
	
	@FindBy(xpath="//input[@id='input-bank-name']")
	@CacheLookup
	WebElement theBankName;
	
	@FindBy(xpath="//input[@id='input-bank-branch-number']")
	@CacheLookup
	WebElement paypalAbaBasNo;
	
	@FindBy(xpath="//input[@id='input-bank-swift-code']")
	@CacheLookup
	WebElement enterSwiftCode;
	
	@FindBy(xpath="//input[@id='input-bank-account-name']")
	@CacheLookup
	WebElement enterAccName;
	
	@FindBy(xpath="//input[@id='input-bank-account-number']")
	@CacheLookup
	WebElement enterAccNo;

	//Constructor for the Affiliate Page
	public AffiliatePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		setupPage = new Setup(driver);
//		logger.info("Initialised");
		
		
	}
	
	//Enter the Details
	public void enterCompany(String companyName) {
		enterCompanyName.clear();
		enterCompanyName.sendKeys(companyName);
		setupPage.logger("Company name entered:"+companyName);
	}
	
	public void enterWebsite(String companyWebsiteUrl) {
		enterCompanyWebsiteUrl.clear();
		enterCompanyWebsiteUrl.sendKeys(companyWebsiteUrl);
		setupPage.logger("Website url entered:"+companyWebsiteUrl);
	}
	
	public void enterTaxID(String TaxID) {
		enterTaxID.clear();
		enterTaxID.sendKeys(TaxID);
		setupPage.logger("TaxId entered:"+TaxID);
	}
	
	public void selectPaymentMethod(String paymentMethod) {
		WebElement clickMethod;
		if (paymentMethod.equals("Cheque")){
			clickMethod = driver.findElement(By.xpath("//input[@id='input-payment-cheque']"));
			clickMethod.click();
			setupPage.logger("Cheque payment method chosen");
		}
		else if (paymentMethod.equals("PayPal")){
			clickMethod = driver.findElement(By.xpath("//input[@id='input-payment-paypal']"));
			clickMethod.click();
			setupPage.logger("PayPal payment method chosen");
		}
		else if (paymentMethod.equals("Bank Transfer")){
			clickMethod = driver.findElement(By.xpath("//input[@id='input-payment-bank']"));
			clickMethod.click();
			setupPage.logger("Bank Transfer payment option chosen");
		}
	}
	
	public void enterChequePayeeName(String name) {
		chequePayee.clear();
		chequePayee.sendKeys(name);
		setupPage.logger("Cheque payee name entered:"+name);
	}
	
	public void enterPaypalEmail(String mailId) {
		paypalEmail.clear();
		paypalEmail.sendKeys(mailId);
		setupPage.logger("Email id entered:"+mailId);
	}
	
	public void enterbankName(String bankName) {
		theBankName.clear();
		theBankName.sendKeys(bankName);
		setupPage.logger("Bank name entered:"+bankName);
	}
	
	public void enterabaBSBno(String abaBSBno) {
		paypalAbaBasNo.clear();
		paypalAbaBasNo.sendKeys(abaBSBno);
		setupPage.logger("ABA BAs number entered:"+abaBSBno);
	}
	
	public void enterswiftCode(String swiftCode) {
		enterSwiftCode.clear();
		enterSwiftCode.sendKeys(swiftCode);
		setupPage.logger("Swift Code entered:"+swiftCode);
	}
	
	public void enteraccName(String accName) {
		enterAccName.clear();
		enterAccName.sendKeys(accName);
		setupPage.logger("Account Name entered:"+accName);
	}
	
	public void enteraccNo(String accNo) {
		enterAccNo.clear();
		enterAccNo.sendKeys(accNo);
		setupPage.logger("Account Number entered:"+accNo);
	}

	public void enterBankTransferDetails(String bankName, String abaBSBno, String swiftCode, String accName, String accNo) {
		enterbankName(bankName);
		enterabaBSBno(abaBSBno);
		enterswiftCode(swiftCode);
		enteraccName(accName);
		enteraccNo(accNo);
	}	
	
	public void agreeDeliveryTerms() {
		WebElement checkBtn = driver.findElement(By.name("agree"));
		checkBtn.click();
	}
	
	public void continueButton() {
		WebElement continueBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		continueBtn.click();
	}
	
	//constructors
	public void enterAffiliateDetails(String companyNames, String websites, String taxIDs, String paymentMethods, String nameEmail ) {
		enterCompany(companyNames);
		enterWebsite(websites);
		enterTaxID(taxIDs);
		selectPaymentMethod(paymentMethods);
		if (paymentMethods.equals("Cheque")) {
			enterChequePayeeName(nameEmail);
		}
		else if (paymentMethods.equals("PayPal")){
			enterPaypalEmail(nameEmail);
		}
		continueButton();
	}
	
	public void enterAffiliateDetails(String companyNames, String websites, String taxIDs, String paymentMethods, String bankNames, String absBSBnos, String swiftCodes, String accNames, String accNos) {
		enterCompany(companyNames);
		enterWebsite(websites);
		enterTaxID(taxIDs);
		selectPaymentMethod(paymentMethods);
		enterbankName(bankNames);
		enterabaBSBno(absBSBnos);
		enterswiftCode(swiftCodes);
		enteraccName(accNames);
		enteraccNo(accNos);
		continueButton();
	}
	
//	public void enterAffiliateDetails(String companyNames, String websites, String taxIDs, String paymentMethods, String nameEmail, String bankNames, String absBSBnos, String swiftCodes, String accNames, String accNos) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		enterCompany(companyNames);
//		enterWebsite(websites);
//		enterTaxID(taxIDs);
//		selectPaymentMethod(paymentMethods);
//		enterbankName(bankNames);
//		enterabaBSBno(absBSBnos);
//		enterswiftCode(swiftCodes);
//		enteraccName(accNames);
//		enteraccNo(accNos);
//		continueButton();
//	}

}
