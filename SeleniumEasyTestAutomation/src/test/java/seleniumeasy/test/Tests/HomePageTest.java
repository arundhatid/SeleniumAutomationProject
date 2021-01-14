package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.HomePage;
import seleniumeasy.qa.Page.tblPaginationPage;

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
		tblObj = obj.clickTablePagination();
		WebElement sPageTitle = driver.findElement(By.tagName("h2"));
		
		sAssert.assertEquals("Table with Pagination Example", sPageTitle.getText());
		
	}
	@AfterTest
	public void sAssertAll()
	{
		sAssert.assertAll();
	}
	@AfterClass
	public void closeConnection()
	{
		postCleanUp();
	}
}