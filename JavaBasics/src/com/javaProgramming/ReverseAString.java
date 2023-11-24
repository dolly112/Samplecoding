package com.javaProgramming;

public class ReverseAString {

	public static void main(String[] args) {
        String rev = "";
		String s="reverse";
		char[] c= s.toCharArray();
		
		for(int i=c.length-1 ; i>=0; i--)
		{
			
		rev = rev + s.charAt(i);
			
			
		}
		System.out.println(rev);
		
			}

}
