package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.HomePage;
import seleniumeasy.qa.Page.tblPaginationPage;

@Listeners(seleniumeasy.qa.Util.TestListener.class)
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
		sAssert.assertAll();
	}
	@AfterClass
	public void assertAllTests()
	{
		System.out.println("I am in TablePaginationTest AfterClass");
		//sAssert.assertAll();
		postCleanUp("TablePaginationTest",driver);
	}
	/*@AfterClass
	public void closeConnection()
	{
		//postCleanUp();
	}*/
}
