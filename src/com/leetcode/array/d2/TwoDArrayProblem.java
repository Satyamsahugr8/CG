package com.leetcode.array.d2;

/**
 * TwoDArrayProblem.java
 * 
 * Description: {Add class description here}
 * 
 * @author satyamsahu
 * @since 30-Jul-2025
 */
public class TwoDArrayProblem {

	public static void main(String[] args) {

		TwoDArrayProblem a = new TwoDArrayProblem();
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		boolean answer = a.searchMatrix(matrix, target);
		System.out.println(answer);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
			
        	if ( target == matrix[i][0] && target == matrix[i][n-1] ) {
        		return true;
        	}
        	
        	else if ( target > matrix[i][0] && target < matrix[i][n-1] ) {
        		return searchBinary(matrix, i, n-1, target);
        	}
        	
		}
        
        return false;
    }
	
	public boolean searchBinary(int[][] matrix, int r, int c, int element) {
		
		int left = r;
		int right = c;
		
		while ( left <= right ) {
	        
			int mid = left + (right - left) / 2;
	        int midVal = matrix[r][mid];

	        if (midVal == element) {
	            return true;
	        } 
	        
	        else if (midVal < element) {
	            left = mid + 1;
	        } 
	        
	        else {
	            right = mid - 1;
	        }
	    }

	    return false;
	}
}
