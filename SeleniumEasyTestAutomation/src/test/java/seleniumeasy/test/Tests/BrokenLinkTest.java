package seleniumeasy.test.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Util.commonUtil;

public class BrokenLinkTest extends Base
{

	
	@BeforeMethod
	public void setUp()
	{
		Init();
	}
	
	@Test(priority=1,description="Find the number of broken links in website")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Find out the number of brokem links in the website")
	public void testBrokenLinks()
	{
		commonUtil.testBrokenLinks();
	}
	@AfterMethod
	public void postCleanUp()
	{
		driver.close();
		driver.quit();
		
	}
}
