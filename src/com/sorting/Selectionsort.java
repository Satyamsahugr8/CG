package com.sorting;

public class Selectionsort {

	public static int[] sortArray(int[] nums) {
		
		for (int i = 0; i < nums.length - 1; i++) {
			int mini = nums[i];
			int minindex = i;
			
			for (int j = i + 1; j < nums.length; j++) {
				if (mini > nums[j]) {
					mini = nums[j];
					minindex = j;
				}
			}
			
			//swap
			int temp = nums[i];
			nums[i] = nums[minindex];
			nums[minindex] = temp;
		}
		
		return nums;
		
	}

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		sortArray(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}

}
