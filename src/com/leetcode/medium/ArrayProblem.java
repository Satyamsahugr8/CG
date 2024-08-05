package com.leetcode.medium;

public class ArrayProblem {

	public static void main(String[] args) {

//		int a[] = { 2, 7, 11, 15 };
//		int ans[] = twoSum(a, 9);
//		System.out.println(ans[0]);
//		System.out.println(ans[1]);
//		
//
//		int [] b = {3,2,4};
//		int anss[] = twoSum(b, 6);
//		System.out.println(anss[0]);
//		System.out.println(anss[1]);
//		
//		int [] c = {3,3};
//		int ansss[] = twoSum(c, 6);
//		System.out.println(ansss[0]);
//		System.out.println(ansss[1]);

		int[] d = { 3, 2, 3, 3 };
		int ansss[] = twoSum(d, 6);
		System.out.print(ansss[0]);
		System.out.print(ansss[1]);

	}

	public static int[] twoSum(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
					return new int[]{i,j};
				}
			}
		}
		return new int[]{};
	}

}
