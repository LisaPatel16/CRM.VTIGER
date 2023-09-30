package com.CRM.VTiger.practice;

class Mobile
{
	double price;
	Mobile() 
	{

	}
	Mobile(double price) 
	{
		this.price=price;
	}	
}

class Redmi extends Mobile
{
 boolean remote;
 
 	Redmi()
 	{
 		
 	}
 	Redmi(boolean remote,double price)
 	{
 		super(price);
 		this.remote=remote;
 	}
}

public class UpDownCasting
{

	public static void main(String[] args) 
	{
		Mobile m1=new Redmi(true,10000);
		
		System.out.println(m1.price);
	}

}
