package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Q56MergeIntervals.java
 * 
 * Description: https://leetcode.com/problems/merge-intervals
 * 
 * @author satyamsahu
 * @since 30-May-2025
 */
public class Q56MergeIntervals {

	public static void main(String[] args) {
		Q56MergeIntervals instance = new Q56MergeIntervals();
		System.out.println(instance);
		
//		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		int[][] arr = {{1,3},{5,6}};
		int[][] ans = instance.merge(arr);
		
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// brute force approach using two while loop which is any how single 
	// as i am incrementing wrt i 
	public int[][] mergeBrute(int[][] intervals) {
		
		int [][] ans = new int[intervals.length][];
		
		int k = 0;
		int j = 0;
		int n = intervals.length;
		
		while ( j < n && k < ans.length ) {
			
			int i = j;
			int newArr[] = new int[intervals[i].length]; 
			newArr[0] = intervals[i][0];
			
			while( i < n ) {
	 			
				if ( i+ 1 < n && intervals[i][1] >= intervals[i+1][0] || i+ 1 < n && intervals[i][1]+1 == intervals[i+1][0] ) {
					newArr[1] = intervals[i+1][1];
					i++;
				}
				else {
					newArr[1] = intervals[i][1];
					j = i + 1;
					break;
				}
			}
			
			ans[k] = newArr;
			k++;
		}
		
		while ( k < ans.length ) {
			ans[k] = new int[]{0,0};
			k++;
		}
		
        return ans;
    }
	
	// using extra variable easy to solve
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

		List<int[]> result = new ArrayList<>();

		int[] newInterval = intervals[0];
		result.add(newInterval);

		for (int[] interval : intervals) {
	
			if (interval[0] <= newInterval[1])
				// Overlapping intervals,
				// update the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {
				// Disjoint intervals,
				// add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
			
		}

		return result.toArray(new int[result.size()][]);
	}
	
	
	
	
}
