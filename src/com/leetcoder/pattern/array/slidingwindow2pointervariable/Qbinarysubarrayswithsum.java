package com.leetcoder.pattern.array.slidingwindow2pointervariable;

import java.util.HashMap;
import java.util.Map;

/**
 * Qbinarysubarrayswithsum.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 10-Oct-2025
 */
public class Qbinarysubarrayswithsum {

	public static void main(String[] args) {
		
		int[] nums = {1,0,1,0,1};
		int goal = 2;
		int ans = numSubarraysWithSum(nums, goal);
		System.out.println("ans : " + ans);
	}
	
	// using prefix sum
	public static int numSubarraysWithSum(int[] nums, int goal) {
        
		Map<Integer, Integer> prefixCount = new HashMap<>();
	    prefixCount.put(0, 1); // base case: one way to have sum = 0

	    int sum = 0;
	    int count = 0;

	    for (int num : nums) {
	        sum += num;

	        // Check if there exists a prefix sum that makes current subarray = goal
	        if (prefixCount.containsKey(sum - goal)) {
	            count += prefixCount.get(sum - goal);
	        }

	        prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
	    }

	    return count;
    }
}
