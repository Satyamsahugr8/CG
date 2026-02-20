package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

import java.util.ArrayList;
import java.util.List;

/**
 * QSubArrayOfKFirstNegative.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QSubArrayOfKFirstNegative {

	public static void main(String[] args) {
		
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		int i = 0;
		int j = 0;
		int n = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		
		while ( j < n ) {
			
			if ( arr[j] < 0 ) list.add(arr[j]);
			
			if ( (j - i + 1) < k ) {
				j++;
			}
			
			else if ( (j - i + 1) == k) {
				
				if (list.isEmpty()) {
					ans.add(0);
				} 
				
				else {
					ans.add(list.get(0));
				}
				
 				if( arr[i] < 0 ) {
 					list.remove(0);
 				}
 				
				i++;
				j++;
			}
		}
		
		System.out.println("ans : " + ans);
		
	}
}
