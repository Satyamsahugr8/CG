package com.leetcoder.pattern.array.slidingwindow2pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * QCountOfOccurance.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QCountOfOccurance {

	public static void main(String[] args) {
		
//		Input: txt = "forxxorfxdofr", pat = "for"
//		Output: 3
		
		String txt = "zbcoejuvpvaboyg";
		String pat = "po";
		

	}
	
	public static void notcorrect(String txt, String pat) {
		
		int sum = 0;
		
		for (int i = 0; i < pat.length(); i++) {
			sum += pat.charAt(i);
		}
		
		System.out.println("sum : " + sum);
		
		int count = 0;
		int k = pat.length();
		int i = 0;
		int j = 0;
		int n = txt.length();
		
		int calSum = 0;
		
		while ( j < n ) {
			
			calSum += txt.charAt(j);
			
			if ( calSum == sum ) {
				count++;
			}
			
			if ( (j - i + 1) < k ) {	
				j++;
			}
			
			else if ( (j - i + 1) == k ) {
				
 				calSum = calSum - txt.charAt(i);
 				
				i++;
				j++;
			}
		}
		
		System.out.println("count : " + count);
	}
}
