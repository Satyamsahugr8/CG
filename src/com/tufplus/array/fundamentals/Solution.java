package com.tufplus.array.fundamentals;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		int k = 60;
		
		leftRotateBykPlaces(nums, k);
		
		for (int i : nums) {
			System.out.print(i+ " ");
		}
	}
	
	
	public static void maximumCountOf1() {
		int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
//		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0};
		
		int maxCounter = 0;
		int counter = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if ( nums[i] == 1) {
				counter++;
			} 
			if ( nums[i] == 0) {
				counter = 0;
			}
			
			if ( counter > maxCounter) 
				maxCounter = counter;
		}
		System.out.println(maxCounter);
	}
	
	
	
//	Left Rotate Array by K Places
	public static void leftRotateBykPlaces( int[] nums, int k ) {
		
		// nums = [1, 2, 3, 4, 5, 6], k = 2
		int size = nums.length;
		k = k%size;
		
		if ( k == 0 ) {
			return;
		} 
		
		int i = 0;
		int[] temp = new int[k];
		
		while (i < k) {
			temp[i] = nums[i];
			i++;
		}
		
		int j = 0;
		while ( j < (size-k) ) {
			nums[j] = nums[j+k];
			j++;
		}
		
		int p = 0;
		while ( (size - k) < size ) {
			nums[size - k] = temp[p];
			k--;
			p++;
		}
		
	}
}

