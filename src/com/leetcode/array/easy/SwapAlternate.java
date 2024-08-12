package com.leetcode.array.easy;

public class SwapAlternate {
	
	public static void swapAlternate(int[] arr) {
		//[9,3,6,12,4,32]
		//[3,9,12,6,32,4]
		for (int i = 0; i < arr.length; i = i+2) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,3,6,12,4,32};
		swapAlternate(arr);
		
		for (int i : arr) {
			System.out.println(i+" ");
		}

	}

}
