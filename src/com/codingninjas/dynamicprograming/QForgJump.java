package com.codingninjas.dynamicprograming;

public class QForgJump {
    
    
    
    public static void main(String[] args) {
        int [] heights = {30,10,60,0,60,50};
        int energy = frogJump(heights);
        System.out.println(energy);
    }

    private static int frogJump(int[] heights) {
        
        int n = heights.length;
        return frogJump(heights, n - 1);
    }

    private static int frogJump(int[] heights, int i) {

        if ( i == 0 ) return 0;

        // left right
        int left = frogJump(heights, i-1) + Math.abs(heights[i] - heights[i-1]);
        int right = Integer.MAX_VALUE;

        if ( i > 1 ) right = frogJump(heights, i-2) + Math.abs(heights[i] - heights[i-2]);
        
        return Math.min(left, right);
    }
}
