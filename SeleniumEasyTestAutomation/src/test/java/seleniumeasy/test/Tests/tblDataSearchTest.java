package seleniumeasy.test.Tests;

import java.util.List;

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
import seleniumeasy.qa.Page.tblDataSearchPage;
import seleniumeasy.qa.Page.tblPaginationPage;
import seleniumeasy.qa.Util.commonUtil;





//@Listeners(seleniumeasy.qa.Util.TestListener.class)
//Comment to push data 
//one more comment added

@Listeners(seleniumeasy.qa.Util.TestListener.class)
	



//@Listeners(seleniumeasy.qa.Util.TestListener.class)
//Comment to push data 
//one more comment added

//@Listeners(seleniumeasy.qa.Util.TestListener.class)
public class tblDataSearchTest extends Base
{
	

	//SoftAssert sAssert;
	tblPaginationPage tObj;
	tblDataSearchPage obj;
	
	
	@BeforeMethod
	public void setUp()
	{
		Init();
		
		tObj=new tblPaginationPage();
		obj = tObj.clickTableDataSearchMenu();		

	}
	@Test(priority='b',description="Verify Search Based on Asignee Criteria which is populated through JSON Test data file",dataProvider = "readDataFromJason", dataProviderClass=commonUtil.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Search Test Based On Asignee which is populated through JSON Test data file")
	public void verifySearchElementBasedOnAssignee(String sTestDataNo,String sAsigneeName)
	{
		//System.out.println("sData1 is : " + sTestDataNo + "sUserName: "+ sAsigneeName);
		SoftAssert sAssert = new SoftAssert();
		String sEnteredText;
		sEnteredText = obj.searchFilterName(sTestDataNo,sAsigneeName);
		
		//System.out.println("sEnteredText is : " + sEnteredText);
		Reporter.log("Entered Data: " + sEnteredText);
		//System.out.println("The String is this: " + "//td[contains(text(),'" + sEnteredText + "'" + ")"+ "]");
		if((sEnteredText!=null))
		{
			List<WebElement> wAssignee = driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'" + sEnteredText +  "')]"));
			if(!wAssignee.isEmpty())
			{
				if(wAssignee.size()>1)
				{
					for(WebElement element:wAssignee)
					{
						System.out.println("The Actual User Name is: "+ element.getText());
						Reporter.log("Verification: Actual "+ element.getText() + " Expected: " + sEnteredText);
						Allure.step("Verification: Actual "+ element.getText() + " Expected: " + sEnteredText);
						sAssert.assertTrue(element.getText().contains(sEnteredText),"Verification: Actual "+ element.getText() + " Expected: " + sEnteredText);
					}
				}
				else
				{
					Reporter.log("Verification: Actual "+ wAssignee.get(0).getText() + " Expected: " + sEnteredText);
					Allure.step("Verification: Actual "+ wAssignee.get(0).getText() + " Expected: " + sEnteredText);
					sAssert.assertTrue(wAssignee.get(0).getText().contains(sEnteredText),"Verification: Actual "+ wAssignee.get(0).getText() + " Expected: " + sEnteredText);
				}
			}
			else
				{
					Reporter.log("Element Not Found:  "+ sEnteredText);
					Allure.step("Element Not Found:  "+ sEnteredText);
				}
		}
		sAssert.assertAll();
		//Object[][] data = readJasonData();
	}
	@Test(priority='a',description="Verify Search Based on Username Criteria which is populated through JSON Test data file",dataProvider="readDataFromJason",dataProviderClass=commonUtil.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: JSON Data Driven Test Based On Username")
	public void verifySearchElementBasedOnUsername(String sData1, String sUserName)
	{		
		//System.out.println("sData1 is : " + sData1 + "sUserName: "+ sUserName);
		SoftAssert sAssert = new SoftAssert();
		String sEnterUserName = obj.searchElement(sUserName);
		//System.out.println("sEnteredText is : " + sEnterUserName);
		Reporter.log("Entered Data: " + sEnterUserName);
		if((sEnterUserName!=null))
		{
			List<WebElement> wActualUserName = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[contains(text(),'" + sEnterUserName + "')]"));
			//sAssert.assertEquals(sActualUserName, sEnterUserName);
			if(wActualUserName.size()>1)
			{
				for(WebElement element:wActualUserName)
				{
					//System.out.println("The Actual User Name is: "+ element.getText());
					Reporter.log("Verification: Actual: "+ element.getText() + " Expected: " + sEnterUserName);
					Allure.step("Verification: Actual: "+ element.getText() + " Expected: " + sEnterUserName);
					sAssert.assertTrue(element.getText().contains(sEnterUserName),"Verification: Actua: "+ element.getText() + " Expected: " + sEnterUserName);

					
				}
			}
			else
			{
				//System.out.println("The Actual User Name is: "+ wActualUserName.get(0).getText());
				Reporter.log("Verification: Actual: "+ wActualUserName.get(0).getText() + " Expected: " + sEnterUserName);
				Allure.step("Verification: Actual: "+ wActualUserName.get(0).getText() + " Expected: " + sEnterUserName);
				sAssert.assertTrue(wActualUserName.get(0).getText().contains(sEnterUserName), "Verification: Actua: "+ wActualUserName.get(0).getText() + " Expected: " + sEnterUserName);
			}
		}
		
		sAssert.assertAll();
	}
	
	
	
	
	//@DataProvider
		
	@AfterMethod
	public void assertAllTests()
	{
		
		driver.close();
		driver.quit();

	}
	
	
	
	
}
