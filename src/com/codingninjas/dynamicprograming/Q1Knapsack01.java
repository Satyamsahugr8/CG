package com.codingninjas.dynamicprograming;

public class Q1Knapsack01 {

	public static void main(String[] args) {
		
		int weights[] = {6, 1, 2, 4, 5};
		int values[] =  {10, 5, 4, 8, 6};
		int maxWeight = 5;

		// 1 & 4 => 5+8
		int value = knapsackDP(weights, values, maxWeight);
		System.out.println(value);
	}
	
	public static int knapsack(int [] weights, int values[], int maxWeight) {
		int n = weights.length;
		return knapsack(weights, values, maxWeight, n-1);
	}

	private static int knapsack(int[] weights, int[] values, int maxWeight, int i) {
		
		if ( i == 0 || maxWeight == 0 ) return 0;
		
		if ( weights[i] > maxWeight ) {
			return knapsack(weights, values, maxWeight, i-1);
		}
		
		else {
			int op1 = values[i] + ( ( maxWeight - weights[i] ) == 0 ? 0 : knapsack(weights, values, maxWeight - weights[i], i - 1) );
			int op2 = knapsack(weights, values, maxWeight , i-1);
			return Math.max(op1, op2);
		}
		
	}

	// memoization
	public static int kansackM(int [] weights, int values[], int maxWeight) {
		int n = weights.length;
		int w = maxWeight;
		int[][] t = new int[n+1][w+1];

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		return knapsackM(weights, values, maxWeight, n-1, t);
	}

	private static int knapsackM(int[] weights, int[] values, int maxWeight, int i, int[][] t) {
		
		if ( i == 0 || maxWeight == 0 ) return 0;

		if ( t[i][maxWeight] != -1 ) {
			return t[i][maxWeight];
		}

		if ( weights[i] > maxWeight ) {
			return t[i][maxWeight] = knapsack(weights, values, maxWeight, i-1);
		}
		
		else {
			int include = values[i] + ( ( maxWeight - weights[i] ) == 0 ? 0 : knapsack(weights, values, maxWeight - weights[i], i - 1) );
			int exclude = knapsack(weights, values, maxWeight , i-1);
			return t[i][maxWeight] = Math.max(include, exclude);
		}
	}

	// DP
	public static int knapsackDP(int [] weights, int values[], int maxWeight) {
		int n = weights.length;
		int[][] t = new int[n+1][maxWeight+1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= maxWeight; j++) {

				// base condition
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (weights[i-1] <= j) {
                    int include = values[i-1] + t[i-1][j - weights[i-1]];
                    int exclude = t[i-1][j];
                    t[i][j] = Math.max(include, exclude);
                } else {
                    t[i][j] = t[i-1][j];
                }

            }
        }
        return t[n][maxWeight];
	}

}
