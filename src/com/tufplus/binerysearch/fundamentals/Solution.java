package com.tufplus.binerysearch.fundamentals;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {-1,20,3,5,22,9,12};
		int search = 9;
		
//		int result = search(arr, search);
//		System.out.println(result);
		
		int result = lowerBound(arr, search);
		System.out.println(result);
		
	}
	
	public static int search(int[] nums, int target) {
	       
		int index = 0;
		for (int i : nums) {
			
			if ( target == i) {
				return index;
			}
			
			index++;
			
		}
		return -1;
    }

	public static int lowerBound(int[] nums, int x) {
		
		int index = 0;
		for (int i : nums) {
			
			if ( i >= x) {
				return index;
			}
			
			index++;
			
		}
		return -1; 
    }
}
