package seleniumeasy.test.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class HomePageTest extends Base 
{

	public HomePage obj;
	public tblPaginationPage tblObj;
	//SoftAssert sAssert;
		
	
	
	@BeforeMethod
	public void setUp()
	{
		Init();
		obj = new HomePage();
		//sAssert = new SoftAssert();
	}
	@Test(description="Verify Table Pagination Menu Opens successfully")
	@Severity(SeverityLevel.NORMAL)
	@Description("test Description :  Verify Table Pagination Menu Open")
	public void verifyTablePaginationMenu()
	{
		SoftAssert sAssert = new SoftAssert();
		Reporter.log("Test Name is: verifyTablePaginationMenu");
		tblObj = obj.clickTablePagination();
		WebElement sPageTitle = driver.findElement(By.tagName("h2"));
		Allure.step("Verification Step: Expected : Table with Pagination Examples Actaul: " + sPageTitle.getText() );
		//sAssert.assertEquals("Table with Pagination Examples", sPageTitle.getText());
		//commonUtil.takeScreenShot(driver, "firstScreenShot");
		sAssert.assertTrue(sPageTitle.getText().equals("Table with Pagination Examples"), "Verification Step: Expected : Table with Pagination Examples Actaul: " + sPageTitle.getText() );
		sAssert.assertAll();
		
		
	}
	@AfterMethod
	public void postCleanUp()
	{
		//System.out.println("I am in HomePage AfterClass");
		//System.out.println("I came here");
		//postCleanUp("HomePageTest",driver);
		driver.close();
		driver.quit();
		
	}
}
