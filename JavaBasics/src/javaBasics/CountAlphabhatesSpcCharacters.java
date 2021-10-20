package javaBasics;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CountAlphabhatesSpcCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "W0rd$$";
		char sarray[] = a.toCharArray();
		int acount = 0;
		int ncount = 0;
		int scount = 0;

		char alpha[] = { 'a', 'b', 'c', 'W', 'r', 'd' };//declare all
		String number[] = { "1", "2", "3", "0" };//declare all
		String specialChrcts[] = { "@", "!", "#", "$" };//declare all

		for (int i = 0; i < sarray.length; i++) {
			if (Character.isAlphabetic(sarray[i])) {
				acount++;
				System.out.println(acount);

			} else if (Character.isDigit(sarray[i])) {
				ncount++;
				System.out.println(ncount);
			} else {
				scount++;
				System.out.println(scount);
			}

		}
		System.out.println("----------------- Aplphabets count"+acount);
		System.out.println("----------------- Number count"+ncount);
		System.out.println("----------------- Special count"+scount);
		
		String s="i i i am attending interview interview";
		Map<String, Integer>  mp= new HashMap<>();
		 String srray[]= s.split(" ");



		/*for(String s:srray)
		{
		if (mp.containsKey(s))
		{
		mp.put(s, mp.get(s)+1);
		}
		else
		{
		mp.put(s, 1);

		}

		}
	*/
	}

}  
