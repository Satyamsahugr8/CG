package com.leetcoder.pattern.array.slidingwindow2pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Q2461Maximum.java
 * 
 * Description: 2461. Maximum Sum of Distinct Subarrays With Length K
 * 
 * @author satyamsahu
 * @since 04-Oct-2025
 */
public class Q2461Maximum {

	public static void main(String[] args) {

	}
	
	public long maximumSubarraySum( int[] nums, int k ) {
		
		int i = 0;
		int l = 0;
		int j = i + k;
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		while ( i < j ) {
			
			if ( !set.contains( nums[i] ) ) {
				set.add( nums[i] );
				sum += nums[i];
			} 
			
			else {
				i++;
				j = i + k;
			}
			
			if ( i == i + k ) {
				
			}
			
			i++;
			
		}
		
        return 1l;
    }
	
	public static int sum(int[] arr, int i, int j) {
		
		int sum = 0;
		while (i<j) {
			sum += arr[i];
		}
		
		return sum;
	}
}
