package com.javaPrograms;

public class StaticAndFinalExample {
	static int a=10;
	public static void main(String[] args) {//so if i remove static here, it becomes a normal method?  
		// TODO Auto-generated method stub
		//StaticAndFinalExample s=new StaticAndFinalExample();
		 m1();
		 final int t=7;

	}
	static void m1()
	{
	System.out.println("inside static m1");
	}
 public static void  m2()//will this be called automatically? bcs its static
{
	 System.out.println("inside static m2");
}
	
	
	
	
	
}
