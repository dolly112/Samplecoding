package com.javaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindWordCountinSentance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "i i i am attending function function";

		Map<String, Integer> mp = new HashMap<>();
		String srray[] = s.split(" ");

		for(String s1 : srray) {
			if (mp.containsKey(s1)) 
			{
				mp.put(s1, mp.get(s1) + 1);
			} else 
			{
				mp.put(s1, 1);

			}
			
}
		/* 
		 mp.forEach((k, v) -> {
		 if (v > 1) {
		 System.out.println("--" + k + "-->" + v);
			}
		});   
		
		*/
		for(Entry<String, Integer> m: mp.entrySet())
		{
			if(m.getValue()>1)
			{	
				System.out.print(m.getKey()+"  ");
			   System.out.println(m.getValue());
				
			
			}
			
			
		}

	}

}
