package com.leetcoder.pattern.array.slidingwindow2pointer;

/**
 * QSubArraySum.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QSubArraySum {

	public static void main(String[] args) {
		
		int[] arr = {2,5,1,8,2,9,1};
		int k = 3;
		int j = 0;
		int n = arr.length;
		int sum = sum(arr, j, k);
		int max = Integer.MIN_VALUE;
		max = Math.max(sum, max);
		int i = 1;
		while ( i <= (n - k) ) {
			sum = sum - arr[i - 1] + arr[(i + k) - 1];
			max = Math.max(sum, max);
			i++;
		}
		
		System.out.println(max);
	}
	
	public static int sum(int[] arr, int i, int k) {
		
		int sum = arr[i];
		int j = i + 1;
		
		while ( j - i + 1 <= k ) {
			sum += arr[j];
			j++;
		}
		
		return sum;
	}
}
