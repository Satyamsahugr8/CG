package com.leetcoder.pattern.array.slidingwindow2pointervariable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Qsubarrayswithkdifferentintegers.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 10-Oct-2025
 */
public class Qsubarrayswithkdifferentintegers {

	public static void main(String[] args) {
		
		int [] arr = {1,2,1,2,3};
		int k = 2;
		
//		int a = atMostK(arr, k);
		int ans = subarraysWithKDistinct(arr, k);
		System.out.println(ans);
	}
	
	public static int subarraysWithKDistinct(int[] nums, int k) {
		return atMostK(nums, k) - atMostK(nums, k - 1);
	}
	
	private static int atMostK(int[] nums, int k) {
	    int i = 0;
	    int count = 0;
	    Map<Integer, Integer> map = new HashMap<>();

	    for (int j = 0; j < nums.length; j++) {
	        map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

	        // shrink window if too many distinct numbers
	        while (map.size() > k) {
	            map.put(nums[i], map.get(nums[i]) - 1);
	            if (map.get(nums[i]) == 0)
	                map.remove(nums[i]);
	            i++;
	        }

	        // all subarrays ending at j with ≤ k distinct
	        count += (j - i + 1);
	    }

	    return count;
	}
		
}
