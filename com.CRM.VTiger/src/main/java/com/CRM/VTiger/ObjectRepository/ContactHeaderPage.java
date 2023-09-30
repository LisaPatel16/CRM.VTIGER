package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHeaderPage {

	@FindBy(className = "dvHeaderText") private WebElement header;
	
	public ContactHeaderPage(WebDriver dri)
	{
		PageFactory.initElements(dri,this);
	}
	
	public String headerMethod()
	{
		return header.getText();
	}
}
