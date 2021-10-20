package javaBasics;

import java.util.Scanner;



public class VerifyPalindromeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter string");
		Scanner sc=new Scanner(System.in);
		String valuestored=sc.next();
		String t="";
		for(int i=valuestored.length()-1; i>=0; i--)
		{
			t=t+valuestored.charAt(i);
		}
		
		System.out.println("Reversed value is->"+t);
		if(valuestored.equals(t))
		{
		System.out.println("The given input is a palindrome");
		}
		else
		{System.out.println("Given input is not a palindrome");
		}
		}
		
		
		
		
		

	}


