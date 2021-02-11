package seleniumeasy.qa.Util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import seleniumeasy.qa.Base.Base;

public class TestListener extends Base implements ITestListener
{

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@SuppressWarnings("deprecation")
	public void onTestFailure(ITestResult result) {
		final SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		System.out.println("THe failed test is: " + result.getName());
		
		
		
		//webManager
		//ITestContext iContext = result.getTestContext();
		//ITestContext iContext1 = commonUtil.setContext(iContext, (WebDriver) iContext.getAttribute("driver"));
		//WebDriver sdriver = (WebDriver) iContext.getAttribute("driver");
		System.out.println(result.getTestContext().getAttributeNames());
		//WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String sFileName =  result.getName() + "_" + simpleFormat.format(timestamp);
		System.out.println("sFileName is:" + sFileName);
		commonUtil.takeScreenShot(sFileName);
		
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		System.out.println("THe skipped test is: " + result.getName());
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		System.out.println("THe passed test is: " + result.getName());
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedWithTimeout(org.testng.ITestResult)
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

}
