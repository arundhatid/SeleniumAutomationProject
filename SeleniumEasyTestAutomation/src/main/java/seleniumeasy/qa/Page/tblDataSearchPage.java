package seleniumeasy.qa.Page;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import seleniumeasy.qa.Base.Base;
import org.openqa.selenium.JavascriptExecutor;

public class tblDataSearchPage extends Base{

	@FindBy(xpath="//input[@placeholder='Filter by Task / Assignee / Status ']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-xs btn-filter']/span")
	WebElement btnFilter;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txtUserName;
	
	public tblDataSearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String searchElement() 
	{
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", txtSearch);
	    //Thread.sleep(500);
		
		
		
		
		//txtSearch.click();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.visibilityOf(txtSearch));
		//WebElement currentElement = driver.switchTo().activeElement();
		//currentElement.sendKeys("something");
		txtSearch.click();
		txtSearch.sendKeys("Smith");
		//txtSearch.sendKeys("Smith");
		Reporter.log("Test Data is : Smith");
		System.out.println("I came here");
		return txtSearch.getAttribute("value");
		//txtSearch.sendKeys(Keys.RETURN);
				
	}
	public String searchFilterName() //throws InterruptedException
	{
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnFilter);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnFilter);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(btnFilter.isEnabled())
			btnFilter.click();
		else 
			return null;
				
		if(!txtUserName.isEnabled())	
			return null;
		else
		{		
			txtUserName.click();
			txtUserName.sendKeys("markino");
			txtUserName.sendKeys(Keys.TAB);
			Reporter.log("TestData is:markino");
			//System.out.println("I was here");
			System.out.println("txtUserName value here is: " + txtUserName.getAttribute("value"));
			return txtUserName.getAttribute("value");
		}
		
		
	}
}
