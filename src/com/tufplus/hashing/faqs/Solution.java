package com.tufplus.hashing.faqs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {100, 4, 200, 1, 3, 2};
//		System.out.println(longestConsecutive(nums));
		
		int[] nums = {-3, 2, 1};
		System.out.println(longestSubarray(nums, 6));
	}
	
//	public static int longestConsecutive(int[] nums) {
//		
//		
////		Arrays.sort(nums);
//		
//		Map<Integer, Integer> hashMap = new HashMap<>();
//
//        // Iterating on the array
//        for (int num : nums) {
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//        
//        System.out.println(hashMap);
//        
//        
//        int longestCounter = 0;
//		int count = 0;
//        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
//            int ele = it.getKey();
//            int freq = it.getValue();
//            
//            if ()
//            
//            
//        }
//        
//		return longestCounter;
//
//        
//    }
	
	
	public static int longestSubarray(int[] nums, int k) {
		
		// nums = {10, 5, 2, 7, 1, 9};  k = 15;
		
		int longestCounter = 0;
		 
		for (int i = 0; i < nums.length - 1; i++) {
			
			int currCounter = 1;
			
			int j = i;
			
			while (longestCounter <= k && j < nums.length - 1) {
				
			if ( nums.length - i <= longestCounter) {
				break;
			}
				
			int remain = k - nums[j];  // 5
			
			if ( nums[j+1] == remain ) {
				currCounter++;
				break;
			}
			
			if ( nums[j+1] < remain ) {
				k = remain;
				j++;
				currCounter++;
			}
			
			}
			
			
			// store current counter to longestCounter
			longestCounter = Math.max(longestCounter, currCounter); 
			
			
		}
		
		
		return longestCounter;   
    }

}




























