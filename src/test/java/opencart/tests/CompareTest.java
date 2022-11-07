package opencart.tests;

import org.testng.annotations.Test;
import opencart.pages.ComparePage;
import utilities.Setup;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;


public class CompareTest {
	
	WebDriver driver;
	String url="http://localhost/upload/index.php?route=common/home&language=en-gb";
	ComparePage compare;
	Setup setupPage;
	
	
	
  
  @BeforeTest
  public void setUp() throws Exception {
	  setupPage = new Setup(driver);
	  driver = setupPage.browserSetup("chrome");
	  driver.get(url);
	  driver.manage().window().maximize();
	  compare = new ComparePage(driver);
  }
  
  @Test(priority=0,dataProvider="json-data")
  public void compare(String item1,String item2) throws InterruptedException, IOException{
	  
	  compare.compareProducts(item1,item2);

	 
  }
  
  @Test(priority=1)
  public void RemoveFromCompare() {
	  compare.RemoveProductFromCompare();
	  compare.RemoveProductFromCompare();
	  compare.RemoveProductFromCompare();
	  compare.RemoveProductFromCompare();
	 
  }
  
  
  @DataProvider(name="json-data")
  public String[][] readWriteJSON() throws InterruptedException, IOException, ParseException {
	  String detail[][]=new String[2][2];
	  JSONParser jsonParser = new JSONParser();
	  try  {
		  	FileReader reader = new FileReader("C:\\Users\\Administrator\\Documents\\Java for Selenium\\JsonData.json");
		  	
	  //Read JSON file
	              Object obj = jsonParser.parse(reader);
	              JSONArray usersList = (JSONArray) obj;
	              System.out.println("Compare List-> "+usersList); //This prints the entire json file
	              for(int i=0;i<usersList.size();i++) 
	              {
	              JSONObject users = (JSONObject) usersList.get(i);
	              System.out.println("Items -> "+users);//This prints every block - one json object
 
	              JSONObject user = (JSONObject) users.get("Compare");
	              System.out.println("item -> "+user); //This prints each data in the block
              
	              String item1 = (String) user.get("item1");
	              String item2 = (String) user.get("item2");
              
	              System.out.println(item1);
	              System.out.println(item2);
	              
	              detail[i][0]=item1;
	              detail[i][1]=item2;

	              }

	  } 
	  catch (FileNotFoundException e) 
	  	
	  	{
		  			
		  e.printStackTrace();
	  	}
  
	  return detail;
  }

  



  @AfterTest
  public void tearDown() {
	  driver.quit();
  }

}
