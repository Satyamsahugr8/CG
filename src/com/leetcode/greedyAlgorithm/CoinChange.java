package com.leetcode.greedyAlgorithm;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;

		System.out.println(coinChangeDynamic(coins, amount));

	}

	// dynamic approach
	public static int coinChangeDynamic(int[] coins, int amount) {

        // Check edge case
        if (amount < 1) return 0;

        // Create DP array
        int[] minCoinsDP = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {

        minCoinsDP[i] = Integer.MAX_VALUE;

        // Try each coin
        for (int coin : coins) {
            if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE)
            minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
        }
        }

        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];

    }

	// some cases will fail with greedy approach
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int n = coins.length;
		int count = 0;

		for (int i : coins) {
			System.out.print(i + " ");
		}

		System.out.println();
		return coinChange2(coins, amount, n, count);
	}

	public static int coinChange2(int[] coins, int amount, int n, int count) {

		if (amount == 0)
			return 0;

		int i = n - 1;

		while (i >= 0) {
			if (amount >= coins[i]) {
				amount = amount - coins[i];
				count++;
				continue;
			} else {
				i--;
			}
		}

		if (amount == 0)
			return count;
		return -1;
	}
}
