package com.codingninjas.array;

import java.util.Arrays;

/**
 * SwapPair.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 18-Jun-2025
 */
public class SwapPair {

	public static void main(String[] args) {

//		SwapPair a = new SwapPair();
		int [] arr = {1,2,3,4,5,6,7};
		swapPair(arr);
		
		Arrays.stream(arr).forEach(System.out::println);

		
	}
	
	public static void swapPair(int [] arr) {
		
		int n = arr.length;
		
		for (int i = 0; i < arr.length; i=i+2) {
			
			int temp = arr[i];
			
			if ( i+1 < n ) {
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			
		}
		
	}
	
}
