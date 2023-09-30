package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	
	@FindBy(name = "accountname")
	private WebElement OrganizationNameField;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateNewOrganizationPage(String orgname) {
		OrganizationNameField.sendKeys(orgname);
		saveBtn.click();
	}

}
