package com.leetcode.array.easy;

public class ReverseArray {

	public static void main(String[] args) {

		int A[] = { 1, 2, 4, 5, 6, 8, 12, 15 };
		
		reverseArrays(A);
		
		for (int i : reverseArrays(A)) {
			System.out.print(i + ",");
		}

	}
	
	private static int[] reverseArrays(int A[]) {
		
		int[] reverseArray = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			reverseArray[A.length - (1+i)] = A[i];
		}
		
		return reverseArray;
	}

}