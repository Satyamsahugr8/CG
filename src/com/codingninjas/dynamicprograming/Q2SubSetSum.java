package com.codingninjas.dynamicprograming;

public class Q2SubSetSum {

    // return if present or not
    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
	    int sum = 11;
        boolean ans = subsetSumM(arr, sum);
        System.out.println(ans);
    }

    public static boolean subsetSum(int [] arr, int sum) {
		int n = arr.length;
		return subsetSum(arr, sum, n-1);
	}

	private static boolean subsetSum(int[] arr, int sum, int i) {

		if ( sum == 0 ) return true;
        if ( i < 0 ) return false;

		if ( arr[i] > sum ) {
			return subsetSum(arr, sum, i-1);
		}
		
		else {
			// check for rest true then include
			boolean included = subsetSum(arr, sum - arr[i], i - 1);
			// exclude current element and check for rest
			boolean excluded = subsetSum(arr, sum , i-1);
			// return true if any of the two cases is true
			return included || excluded;
		}
		
	}

	// memoization
	public static boolean subsetSumM(int [] weights, int maxWeight) {
		
		int n = weights.length;
		int w = maxWeight;
		Boolean[][] t = new Boolean[n+1][w+1];

		// for (int i = 0; i < t.length; i++) {
		// 	for (int j = 0; j < t[0].length; j++) {
		// 		t[i][j] = false;
		// 	}
		// }

		return subsetSumM(weights, maxWeight, n-1, t);
	}

	private static boolean subsetSumM(int[] weights, int maxWeight, int i, Boolean[][] t) {

		if ( maxWeight == 0 ) return true;
        
		if ( i < 0 ) return false;

		if ( t[i][maxWeight] != null ) {
			return t[i][maxWeight];
		}

		if ( weights[i] > maxWeight ) {
			return t[i][maxWeight] = subsetSumM(weights, maxWeight, i-1, t);
		}
		
		else {
			boolean include = subsetSumM(weights, maxWeight - weights[i], i - 1, t);
			boolean exclude = subsetSumM(weights, maxWeight , i-1, t);
			return t[i][maxWeight] = include || exclude;
		}
		
	}


    public static boolean subsetSumDP(int[] arr, int sum) {
        
        // DP
		int n = arr.length;
		boolean[][] t = new boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true; // A sum of 0 can always be achieved
        }

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
                if (arr[i-1] <= j) {
                    boolean include = t[i-1][j - arr[i-1]];
                    boolean exclude = t[i-1][j];
                    t[i][j] = include || exclude;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
    
}
