package com.leetcode.array.easy;

import java.util.Arrays;

/**
 * Q2706BuyTwoChocolates.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 19-Jun-2025
 */
public class Q2706BuyTwoChocolates {

	public static void main(String[] args) {

		Q2706BuyTwoChocolates a = new Q2706BuyTwoChocolates();
		int[] prices = {3,2,3};//{1,2,2};
		int money = 3;
		
		int answer = a.buyChoco(prices, money);
		System.out.println("answer : " + answer);

	}
	
	public int buyChoco(int[] prices, int money) {
		Arrays.sort(prices);
		int maxMoney = money;
		int curr = 0;
		
		for (int i = 0; i+1 < prices.length; i++) {
			
			if ( prices[i] + prices[i+1] <= money ) {
				curr = Math.min(curr, money - prices[i] + prices[i+1]);
				maxMoney = curr;
			}
			
		}

		return maxMoney;
    }
}
