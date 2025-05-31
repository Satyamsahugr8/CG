package com.leetcode.array.easy;


public class Q136SingleNonRepeatingElementInAnArray {

	public static void main(String[] args) {
		
		int arr[] = {3,4,9,3,7,4,8,9,8};
		int answer = singleNumberOptimal(arr);
//		int answer = 3^0;
		System.out.println(answer);
	}
	
	// 1
	// brute force approach with 2 for loop and check one by one each element n2 complexcity
	public static int singleNumber(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; ) {
				if ( i != j && nums[i] == nums[j] ) {
					break;
				}
				
				j++;
				if ( j == nums.length ) {
					return nums[i];
				}
			}
		}
		
        return -1;
    }
	
	// 2 we have one more way using map and count all and at last with count == 1 we have return that element.
	
	// 3
	// think of something bit related 
	// xor 4^4=0 and 4^0 = 4;
	public static int singleNumberOptimal(int[] nums) {
		
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
	
}

