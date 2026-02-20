package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

/**
 * QSubArraySum.java
 * 
 * Description: 
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QSubArraySum {

	public static void main(String[] args) {
		
		int target = 7;
		int[] nums = {2,3,1,2,4,3};
		int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    int sum = 0;
	    int i = 0;

	    for (int j = 0; j < n; j++) {
	        sum += nums[j];

	        // shrink from left while condition is satisfied
	        while (sum >= target) {
	            ans = Math.min(ans, j - i + 1);
	            sum -= nums[i];
	            i++;
	        }
	    }

	    System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);
//	    return (ans == Integer.MAX_VALUE) ? 0 : ans;
	}
	
}
