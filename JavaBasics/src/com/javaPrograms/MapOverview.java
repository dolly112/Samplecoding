package com.javaPrograms;


import java.util.HashMap;
import java.util.Map.Entry;


public class MapOverview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> hm= new HashMap<Integer,String>();
		hm.put(1, "Hello");
		hm.put(2, "World");
		hm.put(3, "Java");
		hm.put(3, "c");
		hm.put(null, "c");
		hm.put(null, "c++");
		
		for( Entry<Integer,String>  store  : hm.entrySet())
		{
		System.out.println("Key is: " +store.getKey());
		System.out.println("Value is: " +store.getValue());
		}
		
		
		
		
		
		
		
	}

}
