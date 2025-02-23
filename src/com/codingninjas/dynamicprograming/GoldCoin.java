package com.codingninjas.dynamicprograming;

public class GoldCoin {

	public static void main(String[] args) {
	
		int i = 9;
		int dp = maxDollarDP(i);
		System.out.println(dp);
		int d = maxDollar(i);
		System.out.println(d);
		
	}
	
	//recursion
	private static int maxDollar(int n) {
		
		if ( n == 1 || n == 2 || n == 3 ) {
			return n;
		}
		
		return Math.max(n, maxDollar(n/2) + maxDollar(n/3) + maxDollar(n/4));
	}
	
	//DP
	private static int maxDollarDP(int n) {
		
		int storage[] = new int[n+1];
		
		if ( n == 1 || n == 2 || n == 3 ) {
			return n;
		}
		
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			storage[i] = Math.max(i, storage[i/2] + storage[i/3] + storage[i/4]);
		}
		
		return storage[n];
	}

}
