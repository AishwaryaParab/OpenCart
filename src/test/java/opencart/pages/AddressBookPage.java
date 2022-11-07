package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	@CacheLookup
	WebElement newAddBtn;
	
	@FindBy(xpath="//a[@class='btn btn-light']")
	@CacheLookup
	WebElement backBtn;
	
	@FindBy(xpath="//input[@name='firstname']")
	@CacheLookup
	WebElement firstNameBlank;
	
	@FindBy(xpath="//input[@name='lastname']")
	@CacheLookup
	WebElement lastNameBlank;
	
	@FindBy(xpath="//input[@name='company']")
	@CacheLookup
	WebElement companyBlank;
	
	@FindBy(xpath="//input[@name='address_1']")
	@CacheLookup
	WebElement address1Blank;
	
	@FindBy(xpath="//input[@name='address_2']")
	@CacheLookup
	WebElement address2Blank;
	
	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement cityBlank;
	
	@FindBy(xpath="//input[@name='postcode']")
	@CacheLookup
	WebElement postCodeBlank;
	
	@FindBy(xpath="//input[@name='default' and @value='0']")
	@CacheLookup
	WebElement defaultNo;
	
	@FindBy(xpath="//input[@name='default' and @value='1']")
	@CacheLookup
	WebElement defaultYes;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	@CacheLookup
	WebElement continueBtn;
	
	public AddressBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//Click on new Address
	public void addNewAddress() {
		newAddBtn.click();
	}
	
	//Click on Back
	public void goBack() {
		backBtn.click();
	}
	
	
	//Enter the details
	public void enterFirstName(String firstName) {
		firstNameBlank.clear();
		firstNameBlank.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameBlank.clear();
		lastNameBlank.sendKeys(lastName);
	}
	
	public void enterCompany(String companyName) {
		companyBlank.clear();
		companyBlank.sendKeys(companyName);
	}
	
	public void enterAdd1(String address1) {
		address1Blank.clear();
		address1Blank.sendKeys(address1);
	}
	
	public void enterAdd2(String address2) {
		address2Blank.clear();
		address2Blank.sendKeys(address2);
	}
	
	public void enterCity(String CityName) {
		cityBlank.clear();
		cityBlank.sendKeys(CityName);
	}
	
	public void enterPostCode(String postCode) {
		postCodeBlank.clear();
		postCodeBlank.sendKeys(postCode);
	}
	
	public void selectCountry(String countryName) {
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText(countryName);
	}
	
	public void selectRegionOrState(String regionName) {
		Select drpRegion = new Select(driver.findElement(By.name("zone_id")));
		drpRegion.selectByVisibleText(regionName);
	}
	
	public void isItDefaultAdd(int defaultYesNo) {
		if (defaultYesNo==0) {
			defaultNo.click();
		}
		else {
			defaultYes.click();
		}
	}
	
	
	//Click on Continue Button
	public void continueButton() {
		continueBtn.click();		
	}
	
	//Click on Delete Button to delete the address at the given index
	public void deleteButton(String indexOfAdd) {
		String xpathOfDelete = "//a[@class='btn btn-danger'][contains(@href,'id="+indexOfAdd+"')]";
		WebElement deleteBtn = driver.findElement(By.xpath(xpathOfDelete));
		deleteBtn.click();		
	}
	
	//Click on Edit Button to edit the address at the given index
	public void editButton(String indexOfAdd) {
		String xpathOfEdit = "//a[@class='btn btn-outline-primary'][contains(@href,'id="+indexOfAdd+"')]";
		WebElement editBtn = driver.findElement(By.xpath(xpathOfEdit));
		editBtn.click();		
	}
	
	//Constructors
	public void enterAddressBookDetails(String firstName, String lastName, String companyName, String address_1, String address_2, String city, String postcode, String country, String region, int defAdd) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCompany(companyName);
		enterAdd1(address_1);
		enterAdd2(address_2);
		enterCity(city);
		enterPostCode(postcode);
		selectCountry(country);
		selectRegionOrState(region);
		isItDefaultAdd(defAdd);
		continueButton();
	}
}