package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.VTiger.GenericUtilities.WebdriverUtility;

public class HomePage extends WebdriverUtility {

	@FindBy(linkText = "Organizations")
	private WebElement orgLinkEdt;
	@FindBy(linkText = "Contacts")
	private WebElement contactLinkEdt;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministartorImg;
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOrganization() {
		orgLinkEdt.click();
	}

	public void clickContact() {
		contactLinkEdt.click();
	}

	public void logoutFromApp(WebDriver driver) {
		moveToElement(driver, AdministartorImg);
		signOutLink.click();
	}
}
