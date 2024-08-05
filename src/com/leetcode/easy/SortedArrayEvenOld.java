package com.leetcode.easy;

public class SortedArrayEvenOld {

	public static void main(String[] args) {

		int A[] = { 1, 2, 4, 5, 6, 8, 12, 15 };
		
		sortedArray(A);
		
		System.out.println(sortedArray(A));
		// foreach
		for (int i : sortedArray(A)) {
			System.out.print(i + ",");
		}

	}
	
	private static int[] sortedArray(int A[]) {
		
		int[] sortedArray = new int[A.length]; // sortedArray = new int[8];
		int index = 0;
		
		for (int i = 0; i < A.length; i++) {
			
			if(A[i] % 2 == 0) {
				sortedArray[index] = A[i];
				index++;
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			
			if(A[i] % 2 != 0) {
				sortedArray[index] = A[i];
				index++;
			}
		}
		return sortedArray;
	}

}
