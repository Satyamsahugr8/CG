package com.codingninjas.dynamicprograming;

public class Q3EqualSumPartitionProblem {
    
    public static void main(String[] args) {

        int arr[] = {1, 5, 11, 5};

        boolean ans = equalSumPartitionProblem(arr);
        System.out.println(ans);
        
    }

    // hypothesis is in my ipad DSA DP Q3
    private static boolean equalSumPartitionProblem(int[] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0 ) return false;

        return Q2SubSetSum.subsetSum(arr, sum/2);
    }

     
}
