package javaBasics;

import java.util.HashMap;
import java.util.Map;

public class count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="i i i am attending interview interview";

		Map<String, Integer>  mp= new HashMap<>();
		String srray[]= s.split(" ");



			for(String s1:srray)
			{
			if (mp.containsKey(s1))
			{
			mp.put(s1, mp.get(s1)+1);
			}
			else
			{
			mp.put(s1, 1);

			}
		
			}
	}
	
}
		
		
		
		
	

