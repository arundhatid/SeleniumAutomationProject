package seleniumeasy.qa.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import seleniumeasy.qa.Base.Base;

public class HomePage extends Base
{
	//PageFactory
	
	@FindBy(linkText="Table")
	WebElement menuTable;
	
	@FindBy(linkText="Table Pagination")
	WebElement menuTablePgn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on Table Pagination Menu step.")
	public tblPaginationPage clickTablePagination()
	{
		//driver.manage().window().fullscreen();
		menuTable.click();
		menuTablePgn.click();
		return new tblPaginationPage();
		
	}
	
}
