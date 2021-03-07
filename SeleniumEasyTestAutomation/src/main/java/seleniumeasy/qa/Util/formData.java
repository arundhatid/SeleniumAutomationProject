package seleniumeasy.qa.Util;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import seleniumeasy.qa.Base.Base;

public class formData extends Base{

	private Map<WebElement,String> map;
	
	public formData()
	{
		this.setMap(new LinkedHashMap<WebElement,String>());
		
	}
	public formData(final LinkedHashMap<WebElement,String> map)
	{
		this.setMap(map);
	}
	public Map<WebElement,String> getMap() {
		return map;
	}
	public void setMap(Map<WebElement,String> map) {
		this.map = map;
	}
	public void put(final WebElement webelement,final String value)
	{
		this.map.put(webelement, value);
	}
	//to handle radio buttons
	public void put(final List<WebElement> webelements,final String value)
	{
		for(WebElement element:webelements)
		{
			if(element.getText().equalsIgnoreCase(value))
			{
				this.put(element, value);
			}
		}
							 
							 
							 
	}
}
