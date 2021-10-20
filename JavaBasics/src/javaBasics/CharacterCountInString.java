package javaBasics;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterCountInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="Cognizant";
		char carray[]=s.toCharArray();
		Map<Character,Integer> MapObject= new HashMap<Character,Integer>();
	
		for(char c:carray)
		{
			if (MapObject.containsKey(c))
			{
				MapObject.put(c, MapObject.get(c)+1)	;
			}
			else
			{
			   MapObject.put(c, 1);
			}
			
		}
		System.out.println(s+":"+MapObject);
		
		
		
		
		
		
		
		
//		for(  Entry<Integer,String>  store  : hm.entrySet())
//		{
//			
//		}
		
		
		
		
		
	}

}
