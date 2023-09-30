package com.CRM.VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method to fetch the data from property file
 * @author Lisa
 *
 */

public class FileUtility
{
	/**
	 * this method helps us to fetch the data from property file
	 * @Lisa
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
