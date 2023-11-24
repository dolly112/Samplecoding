package com.javaPrograms;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SplitAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//1.Declaration
    
    String s2="09/24/2015";
    
    
   // System.out.println(s2.split("/")); //this will not work so use below any methods to print output
    //Method 1 to print
    String a1[]=s2.split("/");
    for (int i=0;i<a1.length;i++)
    {
    	System.out.println(a1[i]);
    }

    //Method 2 to print
	System.out.println("-------"+s2.split("/")[0]);
	
	//Method 3 to print
	String array[]=	(s2.split("/"));
	System.out.println(Arrays.toString(array));
	
	//Method 4 for each loop
	for(String store:a1 )
	{
	System.out.print(store);	
	}
	}

}
