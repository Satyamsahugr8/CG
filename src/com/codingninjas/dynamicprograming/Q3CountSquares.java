package com.codingninjas.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class Q3CountSquares {
	
	public static void main(String[] args) {
//		System.out.println((int)(Math.sqrt(3)));
		int s = countSquareRoot(10);
		System.out.println(s);
	}
	
	// DP
	public static int countSquareRootDP(int n) {
		
		int storage[] = new int[n+1];
		
		if ( n == 0 || n == 1 || n == 2 || n == 3 ) {
			return storage[n] = n;
		}
		
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;

		for (int i = 4; i<= n; i++) {
			
			int minimum  = Integer.MAX_VALUE;
			
			for (int j = 1; j*j <= i; j++) {
				
				int rem = i - j*j;
				minimum = Math.min(minimum, storage[rem]);
				
			}
			
			storage[i] = minimum + 1;
		}
		
		return storage[n];
	}
	
	// memoization
	public static int countSquareRootM(int n) {
		
		int storage[] = new int[n+1];
		return countSquareRootM(n, storage);
	}
	
	public static int countSquareRootM(int n, int[] storage) {
		
		if ( n == 0 || n == 1 || n == 2 || n == 3 ) {
			storage[n] = 1;
			return 1;
		}
		
		if ( storage[n] != 0 ) {
			return storage[n];
		}
		
		int minimum  = Integer.MAX_VALUE;

		for (int i = 1; i*i<= n; i++) {
			minimum = Math.min(1 + countSquareRootM(n - i*i, storage), minimum);
		}
		
		storage[n] = minimum;
		return storage[n];
	}
	
	// recursion
	public static int countSquareRoot(int n) {
		
		if ( n <= 0 ) {
			return 0;
		}
		
		if ( n == 1 ) {
			return 1;
		}
		
		int minimum  = Integer.MAX_VALUE;

		for (int i = (int) Math.round(Math.sqrt(n)); i >= 1; i--) {
			
			if ( i*i > n ) {
				continue;
			}
			
			if ( i*i == n ) {
				return 1;
			}
			
			int ans2 = 1 + countSquareRoot(n - i);
			minimum = Math.min(ans2, minimum);
		}
		
		return minimum;
	}

}
