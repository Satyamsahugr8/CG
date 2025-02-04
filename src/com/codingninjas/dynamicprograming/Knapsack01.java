package com.codingninjas.dynamicprograming;

public class Knapsack01 {

	public static void main(String[] args) {
		
		int weights[] = {6, 1, 2, 4, 5};
		int values[] =  {10, 5, 4, 8 ,6};
		int maxWeight = 5;
		
		int value = kansack(weights, values, maxWeight);
		System.out.println(value);
		

	}
	
	public static int kansack(int [] weights, int values[], int maxWeight) {
		return knapsack(weights, values, maxWeight, 0);
	}

	private static int knapsack(int[] weights, int[] values, int maxWeight, int i) {
		
//		if ( maxWeight == 0 ) {
//			return values[i-1];
//		}
		
		if ( i == weights.length || maxWeight == 0 ) return 0;
		
		if ( weights[i] > maxWeight ) {
			return knapsack(weights, values, maxWeight, i+1);
		}
		
		else {
			
//			if ( maxWeight - weights[i] == 0 ) {
//				return values[i];
//			}
			
			int op1 = values[i] + (( maxWeight - weights[i] ) == 0 ? 0 : knapsack(weights, values, maxWeight - weights[i], i + 1));
			int op2 = knapsack(weights, values, maxWeight , i + 1);
			
			return Math.max(op1, op2);
			
		}
		
	}

}
