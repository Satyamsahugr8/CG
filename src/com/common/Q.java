package com.common;

public class Q {
    public static void main(String[] args) {
        
        int []y = {17,13,8, 9, 14, 15, 12, 14, 1 ,9};
        int yr = optimalStrategyOfGame(y, 10);
        System.out.println(yr);
    }
    public static int optimalStrategyOfGame(int[] coins, int n) {
        // Write your code here.

        int sum1 = 0;

        for( int i = n-1; i > 0; i-- ) {
            
            if ( coins[i] < coins[i - 1] ) {
                sum1 += coins[i-1];
            } else {
                sum1 += coins[i];
            }

            i--;

        }


        System.out.println(sum1);

        return sum1;
    }
}
