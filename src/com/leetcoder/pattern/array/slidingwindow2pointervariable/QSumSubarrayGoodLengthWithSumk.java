package com.leetcoder.pattern.array.slidingwindow2pointervariable;

import java.util.ArrayList;
import java.util.List;

/**
 * QSumSubarrayGoodLengthWithSumk.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QSumSubarrayGoodLengthWithSumk {

	public static void main(String[] args) {
		
		int[] arr = {4,1,1,1,2,3,5};
		int n = arr.length;
		int k = 5; // sum 5
		
		int i = 0;
		int j = 0;
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		while ( j < n ) {
			
			sum += arr[j];

            // shrink window if sum exceeds k
            while ( sum > k && i <= j ) {
                sum -= arr[i];
                i++;
            }

            // check if sum equals k
            if (sum == k) {
                max = Math.max(max, j - i + 1);
            }

            j++;
			
		}
		
		System.out.println("ans : " + max);
		
	}
}
