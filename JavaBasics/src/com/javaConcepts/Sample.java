package com.javaConcepts;

public class Sample {

	public static void main(String[] args) {
		int a = 1;

		int a1[] = new int[5]; // if you know 5 values are going to be allocated
		a1[0] = 1; // 0
		a1[1] = 2;// 1
		a1[2] = 3;// 2
		a1[3] = 4;// 3
		a1[4] = 5;// 4

		// or you can also declare like this
		int[] a2 = { 1, 2, 3, 4, 5 };
		System.out.println(a2[1]); // 1 is printed
		
		for(int i=0; i<a2.length ; i++)
		{
			System.out.println(a2[i]);
		}
	}

}
