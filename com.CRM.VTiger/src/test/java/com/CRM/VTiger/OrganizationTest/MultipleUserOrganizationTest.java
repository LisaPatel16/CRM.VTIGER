package com.CRM.VTiger.OrganizationTest;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.ObjectRepository.CreateNewOrganizationPage;
import com.CRM.VTiger.ObjectRepository.HomePage;
import com.CRM.VTiger.ObjectRepository.OrganizationInfoPage;
import com.CRM.VTiger.ObjectRepository.Organizationpage;
@Listeners(com.CRM.VTiger.GenericUtilities.ListenerImplemention.class)
public class MultipleUserOrganizationTest extends BaseClass{

	@Test(dataProvider = "multipleData",dataProviderClass = ExcelFileUtility.class)
	public void verifyUserCreateOrganizationTest(String mulorgname) throws Throwable {
		
		ExcelFileUtility e=new ExcelFileUtility();
		JavaUtility j=new JavaUtility();
		//String orgname=e.dataFromExcelUtility("Sheet1", 2,0)+j.randomNumber();
		String orgname=mulorgname+j.getrandom();
		HomePage h=new HomePage(driver);
		h.clickOrganization();
		Organizationpage o=new Organizationpage(driver);
		o.clickorgLookupImg();
		CreateNewOrganizationPage c=new CreateNewOrganizationPage(driver);
		c.clickCreateNewOrganizationPage(orgname);
		OrganizationInfoPage or=new OrganizationInfoPage(driver);
		String s=or.orgHeader();
		Assert.assertTrue(s.contains(orgname));
		System.out.println("pass");
	}

}
