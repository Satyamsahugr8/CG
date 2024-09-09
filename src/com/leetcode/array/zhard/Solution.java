package com.leetcode.array.zhard;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
		System.out.println(majorityElement(nums));

	}
	
	
	
	public static int majorityElement(int[] nums) {
        
		int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        // Iterating on the array
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			
        	if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
		}
		return -1;

    }

}
