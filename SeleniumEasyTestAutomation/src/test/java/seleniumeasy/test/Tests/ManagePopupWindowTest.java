package seleniumeasy.test.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.managePopupWindowPage;
import seleniumeasy.qa.Page.tblDataSearchPage;
import seleniumeasy.qa.Util.commonUtil;


public class ManagePopupWindowTest extends Base
{
	managePopupWindowPage  obj;
	//SoftAssert sAssert;
	@BeforeMethod
	public void setUp()
	{
		Init();
		tblDataSearchPage tObj = new tblDataSearchPage();
		obj = tObj.clickAlertsModalsMenu();
		//sAssert = new SoftAssert();
		
	}
	@Test(priority=2,description="Verify that all pop up windows close successfully")
	@Description("Test Description: Verify that all pop windows close successfully and focus returns to parent window ")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyFollowAll()
	{
		SoftAssert sAssert = new SoftAssert();
		obj.verifyBtnFollowAll();
		String sParentWindow = driver.getWindowHandle();
		commonUtil.handlePopup(sParentWindow);
		int numWindow = commonUtil.handlePopup(sParentWindow);
		Allure.step("Verification: Expected : 1 Actual: " + numWindow );
		sAssert.assertEquals(numWindow, 1);
		sAssert.assertAll();
	}
	
	@Test(priority=1,description="Verify that popup for Twitter window close successfully")
	@Description("Test Description: Verify that pop windows close successfully and focus returns to parent window ")
	@Severity(SeverityLevel.CRITICAL)
	public void testBtnFollowOnTwitter()
	{
		SoftAssert sAssert = new SoftAssert();
		obj.verifyBtnFollowOnTwitter();
		String sParentWindow = driver.getWindowHandle();
		int numWindow = commonUtil.handlePopup(sParentWindow);
		Allure.step("Verification: Expected : 1 Actual: " + numWindow );
		sAssert.assertEquals(numWindow, 1);
		sAssert.assertAll();
	}
	@AfterMethod
	public void postCleanUp()
	{
		driver.close();
		driver.quit();
		
	}
	

}
