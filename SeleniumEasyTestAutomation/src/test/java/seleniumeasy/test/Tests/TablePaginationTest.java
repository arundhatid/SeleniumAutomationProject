package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.HomePage;
import seleniumeasy.qa.Page.tblPaginationPage;

public class TablePaginationTest extends Base 
{
	SoftAssert sAssert;
	HomePage hObj;
	tblPaginationPage obj;
	public TablePaginationTest()
	{
		Init();
		sAssert = new SoftAssert();
		hObj = new HomePage();
		obj = hObj.clickTablePagination();
	}

	@Test(priority=1)
	public void verifyTableHeader()
	{
		String sHeading = obj.readTableHeader();
		sAssert.assertEquals(driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText(), sHeading);
		
	}
	@Test(priority=2)
	public void verifyTableContents()
	{
		obj.readTableContents();
	}
	@AfterTest
	public void assertAllTests()
	{
		sAssert.assertAll();
	}
	@AfterClass
	public void closeConnection()
	{
		postCleanUp();
	}
}
