package com.CRM.VTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;



public class JavaUtility {
	/**
	 * Here we fetch the random number.
	 * @author Lisa
	 * @return
	 */
	public int getrandom()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * Here we fetch the date and time because while taking a screenshot at what time we take that 
	 * Screenshot we get to know.
	 * @author Lisa
	 * @return
	 */
	public String sysdateTime()
	{
		//for date import java.util
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	
	public String modifiedDate()
	{
		Date d=new Date();
		String[] date=d.toString().split(" ");
		String dt=date[2];
		String month= date[1];
		String time=date[3].replace(":", "-" );
		String year=date[5];
		String currentdate=dt+" "+month+" "+time+" "+year;
		return currentdate;
		
		
		
	}
}
