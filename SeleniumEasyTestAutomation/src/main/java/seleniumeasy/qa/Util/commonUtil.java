package seleniumeasy.qa.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import io.qameta.allure.Allure;
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
		Allure.step("Following are valid links in the website");
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
					Allure.step(sURL + "  is broken link");
					iCount++;
				}
				else
				{
					System.out.println(sURL + "  is valid link");
					Reporter.log(sURL + "  is valid link");
					Allure.step(sURL);
				}
			}
			catch(MalformedURLException e)
			{
				
				e.printStackTrace();
				Reporter.log("MalformedURLException: " + sURL);
				Allure.step("MalformedURLException: " + sURL);
				System.out.println("MalformedURLException: " + sURL);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
				Reporter.log("Exception: " + sURL );
				Allure.step("Exception: " + sURL);
				System.out.println("Exception: " + sURL);
			}
			
		}
		System.out.println("The Number of Broken Links are: " + iCount);
		Allure.step("The Number of Broken Links are: " + iCount);
		Reporter.log("The Number of Broken Links are: " + iCount);
	}
	
	@DataProvider(name="readDataFromJason")
	public static Object[][] readJasonData(Method method)
	{
		
		JSONParser jParser = new JSONParser();
		FileReader reader = null;
		Object obj = null;
		try {
			reader = new FileReader("D:\\Arundhati\\Testing\\GitRepository\\SeleniumAutomationProject\\SeleniumEasyTestAutomation\\src\\main\\java\\seleniumeasy\\qa\\TestData\\Data_TableDataSearch.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			obj = jParser.parse(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The method name is: " + method.getName());
		String sKey = null;
		String sEachKey=null;
		if(method.getName().equals("verifySearchElementBasedOnUsername"))
		{
			sKey="searchAsignee";
			sEachKey="asignee";
		}	
		if(method.getName().equals("verifySearchElementBasedOnAssignee"))
		{
			sKey="searchUsers";
			sEachKey="username";
		}
		JSONObject JSONData = (JSONObject)obj;
		
		JSONArray JSONDataArray = (JSONArray)JSONData.get(sKey);
		Object data[][] = new Object[JSONDataArray.size()][2];
		int j=0;
		for(int i=0;i<JSONDataArray.size();i++)			
		{
				j=0;
				JSONObject jData = (JSONObject)JSONDataArray.get(i);
				String sTestDataNo = (String) jData.get("TestDataNo");
				String sTestData = (String) jData.get(sEachKey);
				System.out.println("sTestDataNo is:" + sTestDataNo);
				System.out.println("sUserName is:" + sTestData);
				data[i][0] = (Object)sTestDataNo;
				data[i][1] = (Object)sTestData;
				System.out.println("data[" + i + "][0] is:" + data[i][j]);
				System.out.println("data[" + i + "][1] is:" + data[i][j+1]);
			
		}
		/*obj=null;
		JSONData=null;
		JSONDataArray=null;
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return data;		
		
	}

}
			
			
				
				

			
