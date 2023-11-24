package com.javaPrograms;

public class TryCatch {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		int i=0;
		try {
			i++;
			System.out.println("-----------------Try->"+i);
		throw new Exception();
		}
		
		catch (Exception e) 
		{
			i++;
			System.out.println("-----------------Catch->"+i);
			throw new Exception();
			
		}
		finally 
		{
			i++;
			System.out.println("-----------------finally->"+i);
			//throw new Exception();
		}

	}

}
