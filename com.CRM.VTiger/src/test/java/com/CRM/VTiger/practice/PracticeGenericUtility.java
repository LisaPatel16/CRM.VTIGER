package com.CRM.VTiger.practice;

import java.io.IOException;


import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.FileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;


public class PracticeGenericUtility 
{
	
	public static void main(String[] args) throws IOException
	{
		FileUtility futil = new FileUtility();
		String BROWSER=futil.getDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String contactname=eutil.getDataFromExcel("TestData", 0, 0);
		System.out.println(contactname);
		
		JavaUtility jutil=new JavaUtility();
		String dt = jutil.sysdateTime();
		System.out.println(dt);
		
		String mdate = jutil.modifiedDate();
		System.out.println(mdate);
		
	}

}
//system class is present in java.lang package and it is open source
//scanner is a class which is present in java.uitl package so we have to import the class

//depricated method which are present in tdc his version might not be present in next or upcoming version