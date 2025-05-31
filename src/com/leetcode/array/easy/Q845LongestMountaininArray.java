package com.leetcode.array.easy;

import javax.swing.text.Highlighter.Highlight;

/**
 * Q845LongestMountaininArray.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 24-May-2025
 */
public class Q845LongestMountaininArray {

	public static void main(String[] args) {
		Q845LongestMountaininArray instance = new Q845LongestMountaininArray();
		
		int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
		int answer = instance.longestMountainOptimal(arr, arr.length);
		
		System.out.println("answer : " + answer);
		
		

	}
	
	// not optimised
	public int longestMountain(int[] arr, int n) {
		
		// edge case
		// 0 and last
		
		int heighest = 0;
		
		if ( arr.length <= 2 ) {
			return 0;
		}
		
		int i = 1;
		
		// find peak
		while ( i - 1 >= 0 && i + 1 < n ) {
			
			int count = 1;
			
			// peak
			if ( arr[i - 1] < arr[i] && arr[i] > arr[i + 1] ) {
				
				System.out.println(i);
				
				// go to left
				int r = i - 1;
				while ( r >= 0 ) {
					
					if ( r - 1 >= 0 && arr[r - 1] < arr[r] ) {
						System.out.println("if ");
						count++;
					} 

					else {
						System.out.println("else ");
						count++;
						break;
					}
					
					r--;
				}
				
				System.out.println("count : " + count);
				
				// go to right
				int e = i + 1;
				while ( e < n ) {
					
					if ( e + 1 < n && arr[e] > arr[e + 1] ) {
						count++;
					} 
					
					else {
						count++;
						break;
					}
					
					e++;
				}
				
				System.out.println("count : " + count);
				
			}
			
			heighest = Math.max(heighest, count);
			i++;
		}
		
		if ( heighest == 1 ) return 0;
		return heighest;
    }

	public int longestMountainOptimal(int[] arr, int n) {
		
		int diff = 0;
		int heighest = 0;
		int lowest = 0;
		int lowest2 = 0;
		
		if ( arr.length <= 2 ) {
			return 0;
		}
		
		int i = 1;
		
		// find peak and unpeak record there i's
		while ( i - 1 >= 0 && i + 1 < n ) {
			
			// unpeak
			if ( arr[i - 1] > arr[i] && arr[i] < arr[i + 1] ) {
				if ( heighest != 0 ) {
					lowest2 = i;
				}
				lowest = i;
			}
			
			// peak
			else if ( arr[i - 1] < arr[i] && arr[i] > arr[i + 1] ) {
				heighest = i;
			}
			
			// max diff store it
			if ( heighest != 0 ) {
				diff = Math.max(diff, lowest2 - lowest);
				heighest = 0;
			}
			
			i++;
		}
		
		return diff;
	}
}
