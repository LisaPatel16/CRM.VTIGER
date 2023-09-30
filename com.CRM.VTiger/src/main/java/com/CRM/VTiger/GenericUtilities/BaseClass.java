package com.CRM.VTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CRM.VTiger.ObjectRepository.HomePage;
import com.CRM.VTiger.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver listenerdri;
	public FileUtility futil=new FileUtility();
	public WebdriverUtility wutil=new WebdriverUtility();
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void beforesuiteconfig() {
		System.out.println("create the database connection");
	}
	
	@Parameters("browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void beforeClassConfig(/*String Browser*/) throws Throwable {
		String BROWSER = futil.getDataFromPropertyFile("browser");//when you writing from the suite.xml file
		
		//to read data from command line
		//String BROWSER=System.getProperty("browser");
		
		
		String URL = futil.getDataFromPropertyFile("url");
		//runtime polymorpshiam or overriding
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {//remove else when you writing from the suite.xml file
			driver=new FirefoxDriver();
		}
		else
			driver=new EdgeDriver();
		//System.out.println("Invalid Browser");
		
		listenerdri=driver; //initialize listener implementation
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(futil.getDataFromPropertyFile("url"));
		driver.get(URL);
	}
		
		@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
		public void beforeMethodConfig() throws Throwable
		{
			LoginPage lp=new LoginPage(driver);
			lp.unameMethod(futil.getDataFromPropertyFile("username"));
			lp.pwdMethod(futil.getDataFromPropertyFile("password"));
			
			//lp.logIntoApp(UN, PWD);
		}
		
		@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
		public void afterMethodConfig() throws Throwable
		{
			HomePage hp=new HomePage(driver);
			hp.logoutFromApp(driver);
		}
		@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
		public void afterclassCpnfig()
		{
			driver.quit();
		}
		@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
		public void aftersuiteConfig()
		{
			System.out.println("colse the database connection");
		}
		
	}
	

