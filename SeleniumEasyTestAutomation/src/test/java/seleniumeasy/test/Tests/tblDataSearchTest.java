package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
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
	}
	@AfterClass
	public void closeConnection()
	{
		postCleanUp();
	}
}
