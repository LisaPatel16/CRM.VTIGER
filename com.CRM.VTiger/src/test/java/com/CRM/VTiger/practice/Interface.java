package com.CRM.VTiger.practice;


abstract interface Demo1
{
	static int a=10;
	int b=20;
	
	public void m1();
	
	abstract void m2();
}

abstract class Interface implements Demo1 {

	
	public void m1() {
		System.out.println("hi");
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(Demo1.a);
		System.out.println(Demo1.b);
		
	}
	public void m2()
	{
		System.out.println("frtry");
	}
	

}


