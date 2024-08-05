package com.leetcode.medium;

public class FindSecondLargestElement {

	public static void main(String[] args) {
		
		int A[] = { 12, 2, 4, 5, 16, 8, 12, 1 };
		int max = A[0];
		int maxIndex = 0;
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] >= max) {
				max = A[i];
				maxIndex = i;
			}
		}
		
		System.out.println("max: "+max);
		System.out.println("maxIndex: "+maxIndex);
		
		
		
		int newMax = A[0];

		for (int i = 0; i < A.length; i++) {
			if(i != maxIndex && A[i] >= newMax) {
				newMax = A[i] ;
			}
		}
		
		System.out.println("newMax: "+newMax);
	}
}
