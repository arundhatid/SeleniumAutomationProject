/**
 * 
 */
package seleniumeasy.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import seleniumeasy.qa.Util.commonUtil;

/**
 * @author sanee
 *
 */
public class Base {
	
	protected static WebDriver driver;
	private static FileInputStream fis;
	private static Properties prop;
	
	public Base()
	{
		//System.out.println("I am in Base constructor");
		try {
			fis = new FileInputStream(commonUtil.sConfigPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Init()
	{
		//System.out.println("I am inside Init.");
		
		//if(driver==null)
		//{
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty(prop.getProperty("chromekey"),prop.getProperty("chromepath"));
				driver = new ChromeDriver();			
			}
			if(prop.getProperty("browser").equalsIgnoreCase("edge"))
			{
				System.setProperty(prop.getProperty("edgekey"),prop.getProperty("edgepath"));
				driver = new EdgeDriver();			
			}
			if(prop.getProperty("browser").equalsIgnoreCase("ff"))
			{
				System.setProperty(prop.getProperty("ffkey"),prop.getProperty("ffpath"));
				driver = new FirefoxDriver();			
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	
			driver.manage().timeouts().implicitlyWait(commonUtil.iImplicitWait, TimeUnit.SECONDS);
			driver.manage().window().maximize();		
			driver.get(prop.getProperty("url"));
			
			
			/*Alert alt = driver.switchTo().alert();
			alt.dismiss();*/
			
			
			driver.findElement(By.linkText("No, thanks!")).click();
			
		}		
		
		
	//}
	
	public void postCleanUp(String sTestName,WebDriver driver1)
	{
		//System.out.println("I am in postcleanup from: + " + sTestName);
		driver1.close();
		driver1.quit();
		driver1=null;
		/*try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	
	
}
