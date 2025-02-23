package com.codingninjas.resursion.backtracking;

public class Solution {
	
	
public static int methodMP(int i) {
		
		int num = 0;
		
		for (int j = 1; j <= i; j++) {
			if ( check(j, j*j, 0) ) {
				System.out.println(j);
				num += j*j;
			}
		}
		
		return num+1;
		
	}
	
	public static boolean check(int n, int s, int sum) {
		
		if ( s == 0) return n == sum;
		
		return check(n, s / 10, sum + s % 10) || check(n, s / 100, sum + s % 100)
		|| check(n, s / 1000, sum + s % 1000) || check(n, s / 10000, sum + s % 10000);
	}
	
	public static boolean check(int n, String s, int sum) {
		
		if ( sum > n ) return false;
		
		if ( sum == n ) return true;
		
		System.out.println("s " + s);
		
		for (int l = 1; l < s.length(); l++) {
			
			String curr = s.substring(0, l);
			
			sum += Integer.parseInt(curr);
			System.out.println("curr " + curr);
 			
			String remain = s.substring(l); 
			System.out.println("remain " + remain);
			
			if ( sum + Integer.parseInt(remain) == n ) return true;
			
			if (check(n, remain, sum)) {
				return true;
			}
			
//			System.out.println("L " +l);
			sum = 0;
		}
		
		return false;
	}
	
	
}
