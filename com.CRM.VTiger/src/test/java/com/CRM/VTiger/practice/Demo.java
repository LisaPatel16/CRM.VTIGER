package com.CRM.VTiger.practice;


class A
{
	public final void Show1()
	{
		System.out.println("in a show");
	}
	//my github update 
}

class B extends A
{
	public void show2() 
	{
		System.out.println("in b show");	
	}
}
public class Demo
{

	public static void main(String[] args) 
	
	{
		A a1=new B(); //up casting implicitly
		//a1.Show1();
		
		
		B b1=(B)a1; //down casting explicitly
		b1.show2();
	    b1.Show1();
		
		B b2=new B(); // single inheritance
		b2.Show1();
		b2.show2();
		
		
	}

}
