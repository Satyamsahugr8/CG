package com.leetcode.array.medium;

import java.util.Iterator;

/**
 * Q48RotateImage.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 31-Jul-2025
 */
public class Q48RotateImage {

	public static void main(String[] args) {

		Q48RotateImage a = new Q48RotateImage();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		a.rotate(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void rotate(int[][] matrix) {
        
		int n = matrix.length;
		int ans[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				ans[i][j] = matrix[n-(j+1)][i];
			}
		}
		
		matrix = ans;	
    }
	
	
}
