package seleniumeasy.qa.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import seleniumeasy.qa.Base.Base;

public class managePopupWindowPage extends Base{

	@FindBy(id="followall")
	WebElement btnFollowAll;
	
	@FindBy(linkText="Follow On Twitter")
	WebElement btnFollowOnTwitter;

	@FindBy(linkText="Input Forms")
	WebElement mnuInputForms;
	
	@FindBy(linkText="Input Form Submit")
	WebElement mnuInputFormSubmit;
	

	public managePopupWindowPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@Step("Click on Follow All Button")
	public void verifyBtnFollowAll()
	{
		btnFollowAll.click();
	}
	
	@Step("Click on Follow On Twitter Button")
	public void verifyBtnFollowOnTwitter()
	{
		btnFollowOnTwitter.click();
	}
	
	public InputFormValidationPage clickInputFormSubmitMenu()
	{
		mnuInputForms.click();
		mnuInputFormSubmit.click();
		return new InputFormValidationPage();
		
	}
}
