package com.leetcode.array.easy;

public class FindClosestNumber {
	
	public static int modulus(int s) {
		return s*(-1);
	}
	
	public static int findClosestNumber(int[] nums) {
		//nums = [-4,-2,1,4,8]
		int[] copy = nums.clone();
		
//		for (int i : copy) {
//			System.out.println(i);
//		}
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				nums[i] = modulus(nums[i]);
			}
		}
		//nums = [4,2,1,4,8]
			//smallest in this array or sort it
//			Arrays.sort(nums);
			
			int min = nums[0];
			int index = 0;
			int value = copy[0];
			for (int j = 0; j < nums.length; j++) {
				if(min>nums[j]) {
					index = j;
					return copy[index];
				} else if (min==nums[j]) {
					index = j;
					return copy[index];
				}
				
			}
			
//			int value = nums[0];
//			if(nums[0] == nums[1]) {
//				value = nums 
//			}
        return value;
        }

	
	public static int optimisedFindClosestNumber2(int[] nums) {
		int value = nums[0];
		
		for (int i : nums) {
			if (Math.abs(i)<Math.abs(value)) {
				value = i;
			}
		}
		
		if(value < 0) {
			for (int j : nums) {
				if(Math.abs(value) == j) {
					value = Math.abs(value);
				}
			}
		}
		return value;
	}
		
	public static void main(String[] args) {
//		int nums[] = {-10,10,10,10};
		int nums[] = {-4,-2,1,4,8};
//		int nums[] = {-100000,-100000};
		
		System.out.println(optimisedFindClosestNumber2(nums)); 

	}

}
