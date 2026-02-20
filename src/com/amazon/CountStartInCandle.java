package com.amazon;

import java.util.Arrays;

public class CountStartInCandle {

    public static void main(String[] args) {
        
        // usecase 1
        // String s = "**|**|***|";
        // int[][] queries = {{2,5},{5,9}};

        // usecase 2
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        CountStartInCandle c = new CountStartInCandle();
        int [] ans = c.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(ans));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] result = new int[queries.length];
        
        int idx = 0;
        for (int[] is : queries) {
            int left = is[0];
            int right = is[1];
            result[idx++] = countStar(s, left, right);
        }

        return result;
    }

    public int countStar(String s, int left, int right) {
        int count = 0;
        int firstCandle = -1;
        int lastCandle = -1;

        // Find the first candle from the left
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '|') {
                firstCandle = i;
                break;
            }
        }

        // Find the last candle from the right
        for (int i = right; i >= left; i--) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
                break;
            }
        }

        if ( firstCandle != -1 && lastCandle != -1 && firstCandle < lastCandle ) {
            for (int i = firstCandle + 1; i < lastCandle; i++) {
                if (s.charAt(i) == '*') {
                    count++;
                }
            }
        }
        
        return count;
    }
    
}
