package seleniumeasy.qa.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import seleniumeasy.qa.Base.Base;

public class InputFormValidationPage extends Base
{
	@FindBy(name="first_name")
	WebElement txtFirstName;
	
	@FindBy(name="last_name")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="phone")
	WebElement txtPhone;
	
	@FindBy(name="address")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="Select[name='state']")
	WebElement comboState;
	
	@FindBy(name="zip")
	WebElement txtZip;
	
	@FindBy(name="website")
	WebElement txtWebsite;
	
	@FindBy(css="input[type='radio']")
	List<WebElement> selectHosting;

	@FindBy(name="comment")
	WebElement txtComment;

	@FindBy(css="button[type='submit']")
	WebElement btnSubmit;
	
	public InputFormValidationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@Step("Insert data")
	public void submitInputForm(String sTestCaseNo,String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sState,String sZip,String sWebsite,String sHosting,String sComment)
	{
		
		txtFirstName.sendKeys(sFirstName);
		txtLastName.sendKeys(sLastName);
		txtEmail.sendKeys(sEmail);
		txtPhone.sendKeys(sPhone);
		txtAddress.sendKeys(sAddress);
		txtCity.sendKeys(sCity);
		
		Select sComboSelect = new Select(driver.findElement(By.cssSelector("Select[name='state']")));
		
		sComboSelect.selectByVisibleText(sState);
		//comboState.selectByVisibleText(sState);
		txtZip.sendKeys(sZip);;
		txtWebsite.sendKeys(sWebsite);;
		for(WebElement element:selectHosting)
		{
			if(element.getText().equalsIgnoreCase(sHosting))
				if(!element.isSelected())
					element.click();
		}
		txtComment.sendKeys(sComment);;
		Allure.step("Click Submit After Adding Data");
		btnSubmit.click();

	}
}
