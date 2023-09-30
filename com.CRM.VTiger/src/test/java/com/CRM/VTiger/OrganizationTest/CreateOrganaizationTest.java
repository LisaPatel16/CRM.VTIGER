package com.CRM.VTiger.OrganizationTest;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.FileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.GenericUtilities.WebdriverUtility;
import com.CRM.VTiger.ObjectRepository.CreateNewOrganizationPage;
import com.CRM.VTiger.ObjectRepository.HomePage;
import com.CRM.VTiger.ObjectRepository.LoginPage;
import com.CRM.VTiger.ObjectRepository.OrganizationInfoPage;
import com.CRM.VTiger.ObjectRepository.Organizationpage;

public class CreateOrganaizationTest extends BaseClass{
	@Test(groups = "RegressionSuite")
	public void	VerifyCreateOrganisationTest() throws Throwable {
		//WebDriver driver = null;
		//FileUtility futil = new FileUtility();
		JavaUtility jutil = new JavaUtility();
		//WebdriverUtility wutil = new WebdriverUtility();
		/*String UN = futil.getDataFromPropertyFile("username");
		String PWD = futil.getDataFromPropertyFile("password");
		String URL = futil.getDataFromPropertyFile("url");
		String BROWSER = futil.getDataFromPropertyFile("browser");*/
		// runtime polymorphism
		/*if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}*/
		/*
		 * Random r = new Random(); int random = r.nextInt(1000);
		 */
		ExcelFileUtility eutil = new ExcelFileUtility();
		String orgname = eutil.getDataFromExcel("Testdata", 0, 1) + jutil.getrandom();
		;
		// String orgName ="Qspider"+random;
		/*
		 * WebDriver driver = new FirefoxDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.get(URL);
		 */

		/*wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(URL);*/

		/*
		 * driver.findElement(By.name("user_name")).sendKeys(UN);
		 * driver.findElement(By.name("user_password")).sendKeys(PWD);
		 * driver.findElement(By.id("submitButton")).click();
		 */

		/*LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(UN, PWD);*/

		HomePage hp = new HomePage(driver);
		hp.clickOrganization();
		// driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		
		Organizationpage op=new Organizationpage(driver);
		op.clickorgLookupImg();
		//driver.findElement(By.xpath("//img[contains(@title,'Crea']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(orgname);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.clickCreateNewOrganizationPage(orgname);
		
		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
		String orgheader = orginfo.orgHeader();
		//String msg = driver.findElement(By.className("dvHeaderText")).getText();
		if (orgheader.contains(orgname)) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Test Case Failed");
		}
		//driver.quit();

	}

}
