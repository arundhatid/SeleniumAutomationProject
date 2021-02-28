package seleniumeasy.test.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Page.InputFormValidationPage;
import seleniumeasy.qa.Page.managePopupWindowPage;
import seleniumeasy.qa.Util.excelDataUtil;

public class InputFormValidationTest extends Base{

	InputFormValidationPage obj;
	managePopupWindowPage mObj;
	SoftAssert softAssert;
	@BeforeMethod
	public void setUP()
	{
		Init();
		softAssert = new SoftAssert();
		mObj = new managePopupWindowPage();
		obj = mObj.clickInputFormSubmitMenu();		
	}
	@Description("Data Driven Test to insert new records - Excel")
	@Test(dataProvider="getInputData",description="Data driven test using excel to insert records in the system")
	public void validateInputForm(String sTestCaseNo,String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sState,String sZip,String sWebsite,String sHosting,String sComment)
	{
		//System.out.println(sTestCaseNo + "-" + sFirstName + "-" + sLastName+ "-"+ sEmail+ "-" + sPhone+ "-" +sAddress + "-" +sCity + "-" + sState + "-" +  sZip + "-" +  sWebsite + "-" +  sHosting + "-" +  sComment);
		obj.submitInputForm(sTestCaseNo, sFirstName, sLastName, sEmail, sPhone, sAddress, sCity, sState, sZip, sWebsite, sHosting, sComment);
		Allure.step("Verification after insertion of record");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getInputData()
	{
		Object data[][] = excelDataUtil.readExcelFile();
		//System.out.println("Data inside data provider is as followes:");
		//System.out.println(data.toString());
		return data;
	}
	@AfterTest()
	public void assertAll()
	{
		sAssert.assertAll();
	}
	
}
