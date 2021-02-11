package seleniumeasy.qa.Util;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import seleniumeasy.qa.Base.Base;

public class commonUtil extends Base {
	
	public static String sConfigPath = "\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\src\\main\\java\\seleniumeasy\\qa\\Config\\config.properties";
	public static String sScreenShotFolderPath = "\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\Screenshots";
	
	public static int iImplicitWait = 30;
	
	
	public void handlePopup()
	{
		String sParentWindow = driver.getWindowHandle();
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
	
}
