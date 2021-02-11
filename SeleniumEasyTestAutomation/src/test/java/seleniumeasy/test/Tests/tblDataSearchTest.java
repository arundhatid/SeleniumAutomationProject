package seleniumeasy.test.Tests;
import seleniumeasy.qa.TestData.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.tblDataSearchPage;
import seleniumeasy.qa.Page.tblPaginationPage;

//@Listeners(seleniumeasy.qa.Util.TestListener.class)
//Comment to push data 
//one more comment added
public class tblDataSearchTest extends Base
{

	SoftAssert sAssert;
	tblPaginationPage tObj;
	tblDataSearchPage obj;
	
	public tblDataSearchTest()
	{
		Init();
		sAssert = new SoftAssert();
		tObj=new tblPaginationPage();
		obj = tObj.clickTableDataSearchMenu();		

	}
	@Test(priority='b')
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
	}
	@Test(priority='a')
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
	@AfterClass
	public void assertAllTests()
	{
		postCleanUp("TableDataSearch");
		sAssert.assertAll();
		
	}
	/*@AfterClass
	public void closeConnection()
	{
		//postCleanUp();
	}*/

}
