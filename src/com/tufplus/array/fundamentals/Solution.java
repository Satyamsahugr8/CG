package com.tufplus.array.fundamentals;

public class Solution {
	
	public static void main(String[] args) {
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
	
}

