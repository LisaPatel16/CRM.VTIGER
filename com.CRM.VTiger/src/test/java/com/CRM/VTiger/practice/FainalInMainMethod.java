package com.CRM.VTiger.practice;


class ParentClass {
	   public final void show() {
		   final int a=10;
	      System.out.println("ParentClass method");
	   }
	}
	class ChildClass extends ParentClass {
	   public void show(String name) {
		   System.out.println("ChildClass method");
	   }
	}
	public class FainalInMainMethod {
	   public static final void main(String[] args) { // declaring main () method with final keyword.
	      //ParentClass p = new ParentClass();
	      ChildClass c = new ChildClass();
	      ParentClass p1=new ChildClass();///stig
	     //p.show();
	      c.show("xyz");
	      c.show();
	     
	      
	   }
	}

