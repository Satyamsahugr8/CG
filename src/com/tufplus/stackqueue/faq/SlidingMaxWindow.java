package com.tufplus.stackqueue.faq;

import java.util.Arrays;
import java.util.Stack;

import com.leetcoder.pattern.stack.NextGreaterAndSmaller;

/**
 * SlidingMaxWindow.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 21-Sep-2025
 */
public class SlidingMaxWindow {

	public static void main(String[] args) {

//		SlidingMaxWindow a = new SlidingMaxWindow();
//		int[] arr = {};
//		int k = 3;
//		
//		int[] ans = a.maxSlidingWindow(arr, k);
//		System.out.println(Arrays.toString(ans));
		int [][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
		int a = maximalAreaOfSubMatrixOfAll1(matrix);
		System.out.println(a);

	}
	
	public int[] maxSlidingWindow(int[] arr, int k) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
	    return null;
    }
	
	
	public static int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
		
		NextGreaterAndSmaller a = new NextGreaterAndSmaller();
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ( i != 0 ) matrix[i][j] = (matrix[i][j] == 0) ? 0 : matrix[i][j] + matrix[i-1][j];
			}
			max = Math.max(max, a.largestRectangleArea(matrix[i]));
		}
		
		return max;
    }
	
}
