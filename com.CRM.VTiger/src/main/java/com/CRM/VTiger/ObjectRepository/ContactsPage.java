package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[contains(@title,'Create Contact')]")
	private WebElement contactLookUpImp;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void contactlookUpimg() {
		contactLookUpImp.click();
	}
}
