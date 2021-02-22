package seleniumeasy.qa.Util;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.Reporter;

import seleniumeasy.qa.Base.Base;

public class commonUtil extends Base {
	
	public static String sConfigPath = "\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\src\\main\\java\\seleniumeasy\\qa\\Config\\config.properties";
	public static String sScreenShotFolderPath = "\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\Screenshots";
	
	public static int iImplicitWait = 30;
	
	
	public static int handlePopup(String sParentWindow)
	{
		//String sParentWindow = driver.getWindowHandle();
		Set<String> lsWnd = driver.getWindowHandles();
		
		System.out.println(lsWnd);
		
		if(lsWnd.size()>1)
		{
			for(String sWnd : lsWnd)
			{
				
				System.out.println("Window is: " + sWnd);
				
				if(!sParentWindow.equalsIgnoreCase(sWnd))
				{
					driver.switchTo().window(sWnd);
					driver.switchTo().parentFrame().close();
				}
			}
		}
		driver.switchTo().window(sParentWindow);
		Set<String> lstWindow = driver.getWindowHandles();
		System.out.println("AFter Test Number of Windows Open are:" +  lstWindow.size());
		
		return lstWindow.size();

	}
	
	public static void takeScreenShot(String sFileName)
	{
		File scrFile;
		File picFile;
		
		//TakesScreenshot scrShot = (TakesScreenshot)driver;
		scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		picFile = new File(sScreenShotFolderPath + "\\" + sFileName + ".jpg");
		try {
			FileUtils.copyFile(scrFile, picFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver)
	{
		iTestContext.setAttribute("driver", driver);
		return iTestContext;
		
	}
	public static void testBrokenLinks()
	{
		int iCount=0;
		String sURL;
		List <WebElement> sLinkName = driver.findElements(By.tagName("a"));
		System.out.println("The Number of hyperlinks are : " + sLinkName.size());
		Iterator <WebElement> itr = sLinkName.iterator();
		while(itr.hasNext())
		{
			
			sURL = itr.next().getAttribute("href");
			if(sURL == null || sURL.isEmpty())
			{
				System.out.println("URL is not configured for anchor tag or it is empty");
				continue;
			}

			try
			{
				URL url = new URL(sURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setConnectTimeout(2000);
				con.connect();
				if(con.getResponseCode()>=400)
				{
					System.out.println(sURL + "  is broken link");
					Reporter.log(sURL + "  is broken link");
					iCount++;
				}
				else
				{
					System.out.println(sURL + "  is valid link");
					Reporter.log(sURL + "  is valid link");
				}
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
				Reporter.log("MalformedURLException: " + sURL);
				
				System.out.println("MalformedURLException: " + sURL);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
				Reporter.log("Exception: " + sURL );
				
				System.out.println("Exception: " + sURL);
			}
			
		}
		System.out.println("The Number of Broken Links are: " + iCount);
		
	}
}
			
			
				
				

			
