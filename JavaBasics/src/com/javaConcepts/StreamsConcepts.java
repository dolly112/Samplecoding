package com.javaConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsConcepts {

	public static void main(String[] args) {

		
		int[] a= {3,2,2,7,5,1,9,7};
		List<int[]>value= Arrays.asList(a);
//		value.stream().filter(a -> )
		
		
		
		ArrayList<String> al=  new ArrayList<String>();
		al.add("3");
		al.add("2");
		al.add("2");
		al.add("7");
		al.add("5");
		al.add("1");
		al.add("9");
		al.add("7");
		
		//sort and distinct
		List<String> store= al.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println("Sorted distinct values:" +store);
		
		//starts with a
		
		List<String> b= new ArrayList<String>();
		b.add("bbi");
		b.add("bhi");
		b.add("sdes");
		b.add("hhi");
		
		List<String> storevalue   =b.stream().filter(c->c.startsWith("b")).collect(Collectors.toList());
		
		System.out.println(storevalue);
		
		
		
		b.stream().filter(c->c.startsWith("b")).forEach(c->System.out.println(c));
		
	}

}
