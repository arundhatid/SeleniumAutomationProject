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
	
	HomePage hObj;
	tblPaginationPage obj;
			
	@BeforeMethod
	public void setUp()
	{
		Init();
		
		hObj = new HomePage();
		obj = hObj.clickTablePagination();

	}

	@Test(priority=1,description="Verify Table Header")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:Test to verify presence of Table Header")
	public void verifyTableHeader()
	{
		SoftAssert sAssert = new SoftAssert();
		String sHeading = obj.readTableHeader();
		Reporter.log("Verification: Actual : " + driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText() + " Expected: " + sHeading+"_wrongStringAddedToDeliberatelyfailtest");;
		Allure.step("Verification: Actual : " + driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText() + " Expected: " + sHeading+"_wrongStringAddedToDeliberatelyfailtest");
		//sAssert.assertEquals(driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText(), "_wrongStringAddedToDeliberatelyfailtest");
		//sAssert.assertEquals(driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText(), "_wrongStringAddedToDeliberatelyfailtest", "Verify Assert");
		sAssert.assertTrue(driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText().equals("_wrongStringAddedToDeliberatelyfailtest"),"Verification Failed: Expected: " + driver.findElement(By.xpath("//th[text()='Table heading 4']")).getText() + " Actual: _wrongStringAddedToDeliberatelyfailtest");
		sAssert.assertAll();
	}
	@Test(priority=2,description="Verify Table Contents")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description:Test to read table contents")
	public void verifyTableContents()
	{
		SoftAssert sAssert = new SoftAssert();
		int totalNumberofRows = obj.readTableContents();
		Reporter.log("Verification: Actual : " + totalNumberofRows + " Expected: 91");
		Allure.step("Verification: Actual : " + totalNumberofRows + " Expected: 91");
		sAssert.assertEquals(totalNumberofRows, 91,"Verification: Actual: "+ totalNumberofRows +" Expected: 91");
		sAssert.assertAll();
	}
	@AfterMethod
	public void tearDown()
	{
		
		driver.close();
		driver.quit();
		
	}
}
