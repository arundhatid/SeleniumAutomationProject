package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.HomePage;
import seleniumeasy.qa.Page.tblPaginationPage;

@Listeners(seleniumeasy.qa.Util.TestListener.class)
public class TablePaginationTest extends Base 
{
	//SoftAssert sAssert;
	HomePage hObj;
	tblPaginationPage obj;
	public TablePaginationTest()
	{
			}
	@BeforeMethod
	public void setUp()
	{
		Init();
		//sAssert = new SoftAssert();
		hObj = new HomePage();
		obj = hObj.clickTablePagination();

	}

	@Test(priority=1,description="Verify Table Header")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:Test to verify presence of Table Header")
	public void verifyTableHeader()
	{
		String sHeading = obj.readTableHeader();
		Reporter.log("Verification: Actual : " + driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText() + " Expected: " + sHeading);;
		Allure.step("Verification: Actual : " + driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText() + " Expected: " + sHeading);
		sAssert.assertEquals(driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText(), sHeading);
		
	}
	@Test(priority=2,description="Verify Table Contents")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description:Test to read table contents")
	public void verifyTableContents()
	{
		obj.readTableContents();
		//sAssert.assertAll();
	}
	@AfterMethod
	public void assertAllTests()
	{
		System.out.println("I am in TablePaginationTest AfterClass");
		//sAssert.assertAll();
		//postCleanUp("TablePaginationTest",driver);
		driver.close();
		driver.quit();

	}
	}
