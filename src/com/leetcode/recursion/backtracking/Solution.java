package com.leetcode.recursion.backtracking;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int i = 2;
		int[] ans = constructDistancedSequence(i);
		for (int j : ans) {
			System.out.print(j + " ");
		}

	}
	
	public static int[] constructDistancedSequence(int n) {
		int[] result = new int[2 * n - 1];
		Arrays.fill(result, -1);
		boolean[] used = new boolean[n + 1];

		solve(0, n, result, used);
		return result;
	}

	public static boolean solve(int i, int n, int[] result, boolean[] used) {
		
		if (i >= result.length) {
			return true;
		}

		if (result[i] != -1) {
			return solve(i + 1, n, result, used);
		}

		for (int num = n; num >= 1; num--) {
			
			if (used[num]) {
				continue;
			}

			// Try
			used[num] = true;
			result[i] = num;

			// Explore
			if (num == 1) {
				if (solve(i + 1, n, result, used)) {
					return true;
				}
			} else {
				
				int j = result[i] + i;
				if (j < result.length && result[j] == -1) {
					result[j] = num;
					
					if (solve(i + 1, n, result, used)) {
						return true;
					}
					
					result[j] = -1;
				}
			}

			// Undo
			used[num] = false;
			result[i] = -1;
		}

		return false;
	}

	

}
