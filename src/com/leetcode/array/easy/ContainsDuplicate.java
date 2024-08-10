package com.leetcode.array.easy;

import com.sorting.Mergesort;

public class ContainsDuplicate {
	
	// brute force
	public static boolean containsDuplicate(int [] arr) {
		
		for (int i = 0; i <= arr.length-2; i++) {
			for (int j = i+1; j <= arr.length-1; j++) {
				if((arr[i]^arr[j]) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	//optimal solution
	public static boolean optimalContainsDuplicate(int [] arr) {
		
		// sort the array
		Mergesort.mergeSort(arr);
		// compare the one beside the array index's
		for (int i = 0; i <= arr.length-2; i++) {
			if((arr[i]^arr[i+1])== 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int []arr = {1,2,3,5,1};
		System.out.println(containsDuplicate(arr));
		System.out.println(optimalContainsDuplicate(arr));
	}

}