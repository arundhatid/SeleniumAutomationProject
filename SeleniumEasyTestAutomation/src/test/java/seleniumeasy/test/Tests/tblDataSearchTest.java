package seleniumeasy.test.Tests;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.tblDataSearchPage;
import seleniumeasy.qa.Page.tblPaginationPage;

//@Listeners(seleniumeasy.qa.Util.TestListener.class)
//Comment to push data 
//one more comment added

@Listeners(seleniumeasy.qa.Util.TestListener.class)
public class tblDataSearchTest extends Base
{

	//SoftAssert sAssert;
	tblPaginationPage tObj;
	tblDataSearchPage obj;
	
	public tblDataSearchTest()
	{
		
	}
	@BeforeMethod
	public void setUp()
	{
		Init();
		sAssert = new SoftAssert();
		tObj=new tblPaginationPage();
		obj = tObj.clickTableDataSearchMenu();		

	}
	@Test(priority='b',description="Verify Search Based on Asignee Criteria")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Search Test Based On Asignee")
	public void verifySearchElementBasedOnAssignee()
	{
		String sEnteredText;
		sEnteredText = obj.searchElement();
		
		System.out.println("sEnteredText is : " + sEnteredText);
		System.out.println("The String is this: " + "//td[contains(text(),'" + sEnteredText + "'" + ")"+ "]");
		if((sEnteredText!=null))
		{
			String sAssignee = driver.findElement(By.xpath("//td[contains(text(),'" + sEnteredText + "'" + ")"+ "]")).getText();
			sAssert.assertEquals(sAssignee, sEnteredText);
		}
		//sAssert.assertAll();
	}
	@Test(priority='a',description="Verify Search Based on Username Criteria")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Search Test Based On Username")
	public void verifySearchElementBasedOnUsername()
	{		
		String sEnteredText = obj.searchFilterName();
		System.out.println("sEnteredText is : " + sEnteredText);
		if((sEnteredText!=null))
		{
			String sUserName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[text()='" + sEnteredText + "']")).getText();
			sAssert.assertEquals(sUserName, sEnteredText);
		}
		readJSonFile();
	}
	
	public void readJSonFile()
	{
		FileReader fr = null;
		JSONObject objJson = null;
		//create JSONParser object
		JSONParser jSonParser=new JSONParser();
		try {
			//create testdata file object
			fr = new FileReader("D:\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\src\\main\\java\\seleniumeasy\\qa\\TestData\\Data_TableDataSearch.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//parse testdata into object
			objJson = (JSONObject) jSonParser.parse(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		//JSONArray jArray =  (JSONArray) objJson.get(username);
		Object[][] data = new Object[objJson.keySet().size()][0];
		
		System.out.println("JSON Object Size is: " + objJson.keySet().size());
		//for(Set<Keys> key= objJson.keySet();key.hasNext())
		for(int i=0;i<objJson.keySet().size();i++)
		{
			//data[i][0] = objJson.
			
		}
		System.out.println("Jason Array List is as followes: " + data);
		
		
	}
	@AfterMethod
	public void assertAllTests()
	{
		System.out.println("I am in TableDataSerch AfterClass");
		
		//postCleanUp("TableDataSearch",driver);
		
		driver.close();
		driver.quit();

	}
	
	@AfterTest()
	public void assertAll()
	{
		sAssert.assertAll();
	}
		/*@AfterClass
	public void closeConnection()
	{
		//postCleanUp();
	}*/

}
