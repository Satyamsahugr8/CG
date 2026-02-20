package com.codingninjas.dynamicprograming;

public class Q4CountSubsetSumEqualToSum {

    public static void main(String[] args) {
        
        int arr[] = {2,3,5,6,8,10};
        int sum = 10;

        int ans = countSubset(arr, sum);
        System.out.println(ans);
    }

    public static int countSubset(int[] arr, int sum) {

        // DP
		int n = arr.length;
		int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int j = 1; j <= n; j++) {
            t[0][j] = 0;
        }

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

                if (arr[i-1] <= j) {
                    int include = t[i-1][j - arr[i-1]];
                    int exclude = t[i-1][j];
                    t[i][j] = include + exclude;
                } 
                
                else {
                    t[i][j] = t[i-1][j];
                }
                
            }
        }

        return t[n][sum];
    }

}