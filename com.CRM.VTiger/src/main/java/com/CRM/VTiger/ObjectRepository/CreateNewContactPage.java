package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	@FindBy (name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtnEdt;
	
	
	//Constructor
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	//business library class 
	public void createNewContact(String contactName) {
		lastnameEdt.sendKeys(contactName);
		SaveBtnEdt.click();
	}

}
