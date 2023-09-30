package com.CRM.VTiger.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.FileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.GenericUtilities.WebdriverUtility;
import com.CRM.VTiger.ObjectRepository.ContactHeaderPage;
import com.CRM.VTiger.ObjectRepository.ContactInfoPage;
import com.CRM.VTiger.ObjectRepository.ContactsPage;
import com.CRM.VTiger.ObjectRepository.HomePage;
import com.CRM.VTiger.ObjectRepository.LoginPage;

public class ExtraCreateContact extends BaseClass{
	
	@Test(groups = "Smokesuite")
	public  void verifyUserCreateContactTest()throws Throwable {
		
		ExcelFileUtility e=new ExcelFileUtility();
		JavaUtility j=new JavaUtility();
		WebdriverUtility web=new WebdriverUtility();
		String name=e.getDataFromExcel("Sheet1",2, 0)+j.getrandom();
		//click on contact link
		HomePage h=new HomePage(driver);
		h.clickContact();
		Reporter.log("clicked on contact",true);
		
		//click on contact look up image
		ContactsPage c=new ContactsPage(driver);
		c.contactlookUpimg();
		Reporter.log("clicked on Look up image",true);
		
		//create contact with mandatory field
		ContactInfoPage con=new ContactInfoPage(driver);
		web.screenshot(driver, "namess");
		
		//fetch the created contact
		ContactHeaderPage head=new ContactHeaderPage(driver);
		String s1=head.headerMethod();
		
		//validate contact created or not
		Assert.assertTrue(s1.contains(name));
		Reporter.log("validation pass",true);
		System.out.println("pass");
	}
	@Test
	public void create()
	{
		System.out.println("Running");
	}
}

