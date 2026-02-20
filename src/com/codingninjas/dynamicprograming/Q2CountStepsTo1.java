package com.codingninjas.dynamicprograming;

public class Q2CountStepsTo1 {

	public static void main(String[] args) {
		
//		System.out.println("");
		int mm = countSteps(100);
		System.out.println(mm);
		System.out.println(countStepsDP(100));
	}
	
	//3 DP
	private static int countStepsDP(int n) {
		
		int storage[] = new int[n + 1];
		
		// setting as 0 as we are already at 1 dest.
		storage[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			
			// op1
			int op1 = storage[i-1];
			int minSteps = op1;
			
			// op2
			if ( i%3 == 0 ) {
				int op2 = storage[i/3];
				minSteps = Math.min(minSteps, op2);
			}
			
			// op3
			if ( i%2 == 0 ) {
				int op3 = storage[i/2];
				minSteps = Math.min(minSteps, op3);
			}
			
			storage[i] = 1 + minSteps;
		}
		
		return storage[n];
	}

	//2 memoization
	private static int countStepsM(int n) {
		
		int storage[] = new int[n + 1];
		return countStepsM(n, storage);
	}
	
	private static int countStepsM(int n, int[] storage) {
		
		if ( n == 1 ) { 
			storage[n] = 0;
			return storage[n];
		}

		if ( storage[n] != 0 ) {
			return storage[n];
		}

		// op1
		int op1 = countStepsM(n - 1);
		int minSteps = op1;
		
		// op2
		if ( n%3 == 0 ) {
			int op2 = countStepsM(n /3, storage);
			minSteps = Math.min(minSteps, op2);
		}
		
		// op3
		if ( n%2 == 0 ) {
			int op3 = countStepsM(n/2, storage);
			minSteps = Math.min(minSteps, op3);
		}
		
		storage[n] = 1 + minSteps;
		return storage[n];
	}

	//1 normal
	private static int countSteps(int n) {
		
		if ( n == 1 ) return 0;
		
		int op1 = countSteps(n - 1);
		int minSteps = op1;
		
		if ( n%3 == 0 ) {
			int op2 = countSteps(n /3);
			minSteps = Math.min(minSteps, op2);
		}
		
		if ( n%2 == 0 ) {
			int op3 = countSteps(n/2);
			minSteps = Math.min(minSteps, op3);
		}

		return minSteps + 1;
	}

}
