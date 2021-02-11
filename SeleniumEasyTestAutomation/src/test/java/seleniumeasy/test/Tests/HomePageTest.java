package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.HomePage;
import seleniumeasy.qa.Page.tblPaginationPage;

@Listeners(seleniumeasy.qa.Util.TestListener.class)
public class HomePageTest extends Base 
{

	public HomePage obj;
	public tblPaginationPage tblObj;
	SoftAssert sAssert;
	
	
	
	public HomePageTest()
	{
		Init();
		obj = new HomePage();
		sAssert = new SoftAssert();
		
	}
	
	@Test
	public void verifyTablePaginationMenu()
	{
		Reporter.log("Test Name is: verifyTablePaginationMenu");
		tblObj = obj.clickTablePagination();
		WebElement sPageTitle = driver.findElement(By.tagName("h2"));
		
		sAssert.assertEquals("Table with Pagination Examples", sPageTitle.getText());
		//commonUtil.takeScreenShot(driver, "firstScreenShot");
		
		sAssert.assertAll();
		
	}
	@AfterClass	
	public void sAssertAll()
	{
		System.out.println("I am in HomePage AfterClass");
		//System.out.println("I came here");
		postCleanUp("HomePageTest",driver);
		
		
	}
	/*@AfterClass
	public void closeConnection()
	{
		//postCleanUp();
	}*/
}
