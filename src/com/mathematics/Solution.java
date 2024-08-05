package com.mathematics;

public class Solution {

	static long sumOfDivisors(int N) {
        // code here
		return function(N);
    }

	private static long function(long N) {
		long sum = 0;
//		return functioning(N, sum);
		return newOptimisedFunction(N);

	}

	private static long newOptimisedFunction(long n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i*(n/i);
		}
		return sum;
	}

	private static long functioning(long N, long sum) {

		if (N <= 0) {
			return 0;
		}

		if (N == 1) {
			return sum+1;
		}

		for (int i = 1; i <= N; i++) {
			if (N%i == 0) {
				sum += i;
			}
		}
		return functioning(N-1, sum);
	}

	public static void main(String[] args) {
		int n = 5;
		long result = sumOfDivisors(n);
		System.out.println("result = " + result);
	}

}