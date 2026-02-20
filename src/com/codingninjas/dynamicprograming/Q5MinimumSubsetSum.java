package com.codingninjas.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class Q5MinimumSubsetSum {
    
    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 6};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int ans = minimumSubsetSum(arr, sum);
        System.out.println(ans);
    }

    public static int minimumSubsetSum(int[] arr, int sum) {

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
        
        // store all true value from t[][] last row
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            if ( t[n][i] ) {
                lst.add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < lst.size(); i++) {
            min = Math.min(min, Math.abs(sum - 2 * lst.get(i)));
        }
        
        return min;
    }

}
