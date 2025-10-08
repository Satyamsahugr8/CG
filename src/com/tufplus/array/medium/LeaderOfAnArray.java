package com.tufplus.array.medium;

import java.util.ArrayList;

/**
 * LeaderOfAnArray.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 30-Jul-2025
 */
public class LeaderOfAnArray {

	public static void main(String[] args) {

		LeaderOfAnArray a = new LeaderOfAnArray();
		int[] arr = {-3, 4, 5, 1, -4, -5};
		ArrayList<Integer> ans = a.leaders(arr);
		
		System.out.println(ans);
	}
	
	public ArrayList<Integer> leaders(int[] nums) {
		
		int n = nums.length;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(nums[n-1]);
		int high = nums[n-1];
		
		for (int i = n - 2; i >= 0; i--) {
			
			if ( nums[i] > high ) {
				ans.add(0, nums[i]); // add at the start for correct order
	            high = nums[i];
			}
			
		}
        return ans;
    }
	
	
}
