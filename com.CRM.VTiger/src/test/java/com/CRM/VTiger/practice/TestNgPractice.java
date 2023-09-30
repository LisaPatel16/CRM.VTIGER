package com.CRM.VTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNgPractice {
	@Test(priority=2, invocationCount=3)
	public void create()
	{
		System.out.println("created");
		Assert.fail();
	}
	@Test(dependsOnMethods="create",alwaysRun=true, priority=1)
	public void update()
	{
		System.out.println("updated");
	}
	@Test(priority=4)
	public void deleted()
	{
		System.out.println("deleted");
	}

}
//