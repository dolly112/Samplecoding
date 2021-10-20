package javaBasics;

import java.util.HashMap;
import java.util.Map.Entry;

public class Sandbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<>();
		map.put("a", 5);
		map.put("b", 6);
		
		map.entrySet().forEach(e->System.out.println("key->"+e.getKey()+" value->"+e.getValue()));
		
		map.entrySet().stream().forEach(e->System.out.println("key->"+e.getKey()+" value->"+e.getValue()));
		
		map.forEach((k,v)->System.out.println("key->"+k+" value->"+v));
		
		for (Entry<String, Integer> e : map.entrySet()) {
			System.out.println("key->"+e.getKey()+" value->"+e.getValue());
		}
	}

}
