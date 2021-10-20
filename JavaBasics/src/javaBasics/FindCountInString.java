package javaBasics;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindCountInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Map hm= new HashMap<Integer,String>();
		 hm.put(1, "Helllllllloooo"); //key,value
		 //only to get  value
		 for(int i=0;i<=hm.size();i++)
		 {
		 System.out.println(hm.get(i));
		 }
		 //through iterator
		 /*for(Entry store: hm.entrySet<Integer,String>())
		 {
			System.out.println(hm.g);
			System.out.println();
		 }*/
		 /*
		 hm.entrySet().stream().forEach(e->System.out.println(e.getClass()));
		 
		 hm.forEach((k,v)->System.out.println(k+" "+v));
//		 for( Map.Entry m : hm.entrySet())
//		 {  
//			   System.out.println(m.getKey()+" "+m.getValue());  
//		 } 
		
		 for (Map.Entry<Integer, String> entry : hm.entrySet()) {
	          System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
	      }*/
		
		
		
	}

	

}
