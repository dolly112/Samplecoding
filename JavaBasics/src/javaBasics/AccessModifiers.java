package javaBasics;

public class AccessModifiers {

	private int a=90;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccessModifiers am=new AccessModifiers();	
	
		am.method1();
		am.method2();
		System.out.println(am.a);
		
	}
	
	 private void method1()
	{  int a=10;
		System.out.println("private 1methis 1called");
		System.out.println(a);
	}
	 void method2()
		{
		 System.out.println(a);
			System.out.println("no private method");
		}
	 void m3()
	 
	 {
	 }
	 }


