package seleniumeasy.qa.Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import seleniumeasy.qa.Base.Base;

public class tblPaginationPage extends Base
{
	
	//PageFactory
	@FindBy(css="table.table-hover>thead>tr>th")
	List<WebElement> tblHeader;
	
	@FindBy(css="tbody#myTable>tr>td")
	List<WebElement> tblContents;
	
	@FindBy(linkText="2")
	WebElement linkTwo;
	
	@FindBy(linkText="3")
	WebElement linkThree;
	
	@FindBy(linkText="Table")
	WebElement menuTable;

	@FindBy(linkText="Table Data Search")
	WebElement menuTableDataSearch;
	
	public tblPaginationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@Step("Verify table healders")
	public String readTableHeader()
	{
		String sHeading="";
		for(WebElement row : tblHeader)
		{
			if(row.getText().equalsIgnoreCase("Table heading 4"))
				sHeading = row.getText();
			//System.out.println(row.getText());
		}
		System.out.println("Total Number of Columns Are: " + tblHeader.size());
		
		return sHeading;
	}
	
	@Step("Read table contents")
	public void readTableContents()
	{
		for(WebElement row : tblContents)
			System.out.println(row.getText());
		linkTwo.click();
		for(WebElement row : tblContents)
			System.out.println(row.getText());
		linkThree.click();
		for(WebElement row : tblContents)
			System.out.println(row.getText());

		System.out.println("Total Number of rows Are: " + tblContents.size());
		
	}
	public tblDataSearchPage clickTableDataSearchMenu()
	{
		menuTable.click();
		menuTableDataSearch.click();
		return new tblDataSearchPage();
		
	}
}
