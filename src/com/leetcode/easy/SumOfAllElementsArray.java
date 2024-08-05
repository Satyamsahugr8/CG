package com.leetcode.easy;

public class SumOfAllElementsArray {

	public static void main(String[] args) {
		
		int A[] = { 121, 2, 4, 5, 6, 8, 12, 15 };
		
		sumElementArray(A);
		System.out.println(sumElementArray(A));
		
	}

	private static int sumElementArray(int A[]) {
		
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
				 sum += A[i];
		}
		return sum;
	}
}