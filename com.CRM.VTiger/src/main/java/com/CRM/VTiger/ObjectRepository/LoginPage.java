package com.CRM.VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Identify the elements using selenium annotation and declare as private
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement LogInBtn;


	//Initialise the Elements, PageFactory class will handle StaleElementRefernceException  
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Creating business libraries(generic methods) for reducing the code
//	public void logIntoApp(String username, String password) {
//		usernameEdt.sendKeys(username);
//		passwordEdt.sendKeys(password);
//		LogInBtn.click();
//	}
	
	public void unameMethod(String un)
	{
		usernameEdt.sendKeys(un);
	}
	public void pwdMethod(String pwd)
	{
		passwordEdt.sendKeys(pwd);
		LogInBtn.click();
	}

}
//page factory is java design pattern