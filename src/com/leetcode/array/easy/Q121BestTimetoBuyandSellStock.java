package com.leetcode.array.easy;

/**
 * Q121BestTimetoBuyandSellStock.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 30-Jul-2025
 */
public class Q121BestTimetoBuyandSellStock {

	public static void main(String[] args) {

		Q121BestTimetoBuyandSellStock a = new Q121BestTimetoBuyandSellStock();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(a.maxProfit(prices));
		
	}
	
	public int maxProfit(int[] prices) {
		
		int buy = prices[0];
//        int curr_p = Integer.MIN_VALUE;
        int max_p = 0;
        
        for (int i = 1; i < prices.length; i++) {
        	
        	if ( prices[i] < buy ) {
        		buy = prices[i];
        	}
        	
        	else {
        		int curr_p = prices[i] -buy;
        		max_p = Math.max(curr_p, max_p);
        	}
        	
		}
        
        return max_p;
        
    }
}
