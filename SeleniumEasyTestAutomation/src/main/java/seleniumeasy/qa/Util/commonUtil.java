package seleniumeasy.qa.Util;

import java.util.Set;

import seleniumeasy.qa.Base.Base;

public class commonUtil extends Base {
	
	public static String sConfigPath = "\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\src\\main\\java\\seleniumeasy\\qa\\Config\\config.properties";
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
}
