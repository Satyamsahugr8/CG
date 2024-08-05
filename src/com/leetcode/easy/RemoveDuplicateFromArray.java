package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromArray {
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int returned = removeDuplicates(nums);
		System.out.println(returned);
		
		for (int i : nums) {
			System.out.println(i);
		}
		
	}
	
	public static int removeDuplicates(int[] nums) {
        Set<Integer> setInt = new HashSet<>();
        for (Integer integer : nums) {
        	setInt.add(integer);
		}
        int index = 0;
        for (Integer num : setInt) {
        	nums[index++] = num;
        }
        
        for (int i = index; i < nums.length; i++) {
			
		}
        
		return nums.length;
    }

}
