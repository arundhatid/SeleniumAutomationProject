package seleniumeasy.test.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Util.commonUtil;

public class BrokenLinkTest extends Base
{

	
	@BeforeMethod
	public void setUp()
	{
		Init();
	}
	
	@Test
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
