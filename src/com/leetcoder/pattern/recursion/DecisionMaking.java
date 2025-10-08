package com.leetcoder.pattern.recursion;

import java.util.Arrays;

/**
 * DecisionMaking.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 24-Sep-2025
 */
public class DecisionMaking {

	public static void main(String[] args) {
		
		int [] arr = {0,1,10,9,4,5,-69};
		sortAnArray(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
	}
	
	/// {0,1,10,9,4,5,69}
	public static void sortAnArray(int[] arr, int j) {
		
		if ( j == 1 ) {
			return;
		}
		
		sortAnArray(arr, j - 1);
		
		// j is length
		if ( arr[j-2] < arr[j - 1] ) {
			return;
		}
		
		else {
			
			// this for loop also can be down using recursion
			for ( int i = j - 1; i - 1 >= 0; i-- ) {
				
				if ( arr[i - 1] > arr[i] ) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
				else {
					return;
				}
			}
		}
		
		
	}
}
