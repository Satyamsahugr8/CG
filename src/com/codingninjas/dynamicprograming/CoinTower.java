package com.codingninjas.dynamicprograming;

public class CoinTower {
	
	public static void main(String[] args) {

		int N = 4, one = 1, X = 2, Y = 3;  //A	
//		int N = 10, one = 1, X = 2, Y = 4;  //B
		String answer = lastPickWillLose(N, one, X, Y);
		System.out.println(answer);
		String answer1 = lastPickWillLose2(N, one, X, Y);
		System.out.println(answer1);
	}

	
	
	public static String lastPickWillLose(int N, int one, int X, int Y) {

		int dp[] = new int[N + 1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {

			if ( i < X ) 
				dp[i] = dp[i - 1] ^ 1;
			if ( i < Y ) {
				dp[i] = dp[i - X] ^ 1;
			} else {
				dp[i] = dp[i - Y] ^ 1;
			}

		}

		if (dp[N] == 0)
			return "A";
		else
			return "B";
	}
	
	//CN
	public static String lastPickWillLose2(int n, int one, int x, int y) {

		if (x > y) {
			int temp = x;
			x = y;
			y = temp;
		}
	
		boolean dp[] = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			
			if ( i == 1 || i == x || i == y ) {
				dp[i] = true;
			}
			
			else if ( i < x ) {
				dp[i] = !dp[i - 1];
			}
			
			else if ( i < y ) {
				dp[i] = !(dp[i - x] && dp[i - 1]);
			}
			
			else {
				dp[i] = !(dp[i - x] && dp[i - y] && dp[i - 1]);
			}
			
		}
		
		boolean result = dp[n];
		
		if ( !result ) return "A";
		return "B";
		
	}
}
