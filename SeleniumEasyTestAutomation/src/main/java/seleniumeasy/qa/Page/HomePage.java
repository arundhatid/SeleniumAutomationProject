package seleniumeasy.qa.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public tblPaginationPage clickTablePagination()
	{
		menuTable.click();
		menuTablePgn.click();
		return new tblPaginationPage();
		
	}
	
}
