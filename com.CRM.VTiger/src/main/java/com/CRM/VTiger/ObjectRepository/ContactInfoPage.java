package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(name="lastname") private WebElement nameLast;
	
	@FindBy(xpath = "//input[contains(@class,'crmButton')]") private WebElement button;
	
	public ContactInfoPage(WebDriver dri)
	{
		PageFactory.initElements(dri,this);
	}
	
	public void nameInpuMethod(String name)
	{
		nameLast.sendKeys(name);
		button.click();
	}
}

