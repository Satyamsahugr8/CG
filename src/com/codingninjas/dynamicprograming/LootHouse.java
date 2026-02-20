package com.codingninjas.dynamicprograming;

public class LootHouse {

	public static void main(String[] args) {

		int arr[] = {10, 2, 30, 20, 3, 50};
		int n = arr.length;
		int ans =  maxiSumRobber(arr, 0, n - 1);
		System.out.println(ans);
		
		int ans2 = maxiSumRobberDP(arr);
		System.out.println(ans2);
	}
	
	// recursion 
	public static int maxiSumRobber(int[] arr, int i, int j) {
		
		if ( i < 0 || j < 0 || j < i ) {
			return 0;
		}
		
		int sum = Integer.MIN_VALUE;
		
		int sumInclude = maxiSumRobber(arr, 0, i - 2) + arr[i];
		int sumExclude = maxiSumRobber(arr, i + 1, j);
		sum = Math.max(sum, Math.max(sumInclude, sumExclude));
		
		return sum;
	}
	
	
	//DP 
	public static int maxiSumRobberDP(int[] arr) {
		
		int[] dp = new int[arr.length + 1];
		
		int sum = Integer.MIN_VALUE;
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			
			int sumI = arr[i];
			if ( i - 2 >= 0 ) {
				sumI += dp[i-2];
			}
			int sumE = 0;
			if ( i + 1 < n ) 
				sumE += dp[i+1];
			
			sum = Math.max(sum, Math.max(sumI, sumE));
			dp[i] = sum;
		}
		
		return sum;
	}
	
	
}
