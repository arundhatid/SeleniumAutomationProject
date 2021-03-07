package seleniumeasy.qa.Page;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import seleniumeasy.qa.Base.Base;
import seleniumeasy.qa.Util.formData;

public class InputFormValidationPage extends Base
{
	@FindBy(name="first_name")
	static WebElement txtFirstName;
	
	@FindBy(name="last_name")
	static WebElement txtLastName;
	
	@FindBy(name="email")
	static WebElement txtEmail;
	
	@FindBy(name="phone")
	static WebElement txtPhone;
	
	@FindBy(name="address")
	static WebElement txtAddress;
	
	@FindBy(name="city")
	static WebElement txtCity;
	
	@FindBy(css="Select[name='state']")
	static WebElement comboSelect;
	
	@FindBy(name="zip")
	static WebElement txtZip;
	
	@FindBy(name="website")
	static WebElement txtWebsite;
	
	@FindBy(css="input[type='radio']")
	static List<WebElement> selectHosting;

	@FindBy(name="comment")
	static WebElement txtComment;

	@FindBy(css="button[type='submit']")
	static WebElement btnSubmit;
	
	public InputFormValidationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@Step("Insert data")
	public void submitInputForm(String sTestCaseNo,String sFirstName,String sLastName,String sEmail,String sPhone,String sAddress,String sCity,String sState,String sZip,String sWebsite,String sHosting,String sComment)
	{
		
		//Map<WebElement,String> sEnterDataList = new LinkedHashMap<WebElement,String>();
		formData sEnterDataList = new formData();
		
		
		/*txtFirstName.sendKeys(sFirstName);
		txtLastName.sendKeys(sLastName);
		txtEmail.sendKeys(sEmail);
		txtPhone.sendKeys(sPhone);
		txtAddress.sendKeys(sAddress);
		txtCity.sendKeys(sCity);*/
		
		//System.out.println("The type of State Combo is: " + comboSelect.getAttribute("type"));
		//Select sComboSelect = new Select(driver.findElement(By.cssSelector("Select[name='state']")));
		
		/*sComboSelect.selectByVisibleText(sState);
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
		
		*/

		sEnterDataList.put(txtFirstName, sFirstName);
		sEnterDataList.put(txtLastName, sLastName);
		sEnterDataList.put(txtEmail, sEmail);
		sEnterDataList.put(txtPhone, sPhone);
		sEnterDataList.put(txtAddress, sAddress);
		sEnterDataList.put(txtCity, sCity);
		sEnterDataList.put(comboSelect, sState);
		sEnterDataList.put(txtZip, sZip);
		sEnterDataList.put(txtWebsite, sWebsite);
		sEnterDataList.put(selectHosting, sHosting);
		//sEnterDataList.put((WebElement) selectHosting, sHosting);
		sEnterDataList.put(txtComment, sComment);
		sEnterDataList.put(btnSubmit, "");
		seleniumeasy.qa.Util.commonUtil.EnterData(sEnterDataList);
	}
}
