package com.leetcode.easy;

public class FindMaximumElementArray {

	public static void main(String[] args) {
		
		int A[] = { 1, 2212, 4, 52, 6, 8, 12, 15 };
		
		maximumElementArray(A);
		System.out.println(maximumElementArray(A));
		
//		for (int i : maximumElementArray(A)) {
//			System.out.print(i + ",");
//		}
		
	}

	private static int maximumElementArray(int A[]) {
		
		int max = A[0]; //max =1;
		
		for (int i = 1; i < A.length; i++) {
			
			 if( A[i] >= max ) {
				 max = A[i];
			 }
		}
		return max;
	}
}
