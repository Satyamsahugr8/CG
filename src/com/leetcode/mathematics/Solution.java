package com.leetcode.mathematics;

import java.util.Scanner;

public class Solution {

	static int takeInput() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n = " + n);
		return n;
	}

	static long sumOfDivisors(int N) {
        // code here
		long sum = 0;
		return functioning(N, sum);
    }

	static long sumOfDivisorsNewOptimisedFunction(int n) {
		// code here
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (long) i *(n/i);
		}
		return sum;
	}

	private static long functioning(long N, long sum) {

		if (N <= 0) {
			return sum;
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

	public static int countDigits(int s){
		// Write your code here.
		int ss = 0;
		while(s > 0) {
			ss++;
			s = s/10;
		}
		return ss;
	}

	static int evenlyDivides(int s){
		// code here
		int ss = 0;
		int originals = s;
		while(s > 0) {
			int remain = s % 10;
			if(remain == 0) {
				s = s/10;
				continue;
			} else if(originals%remain == 0) {
				ss++;
			}
			s = s/10;
		}
		return ss;
	}

	public static int reverse(int n) {
		int rev = 0;
		while(n != 0){
			int l = n % 10;
			if(rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10) {
				return 0;
			}
			rev = (rev * 10) + l;
			n = n / 10;
		}
		return rev;
	}

	public static boolean palindromeNumber(int n){
		// Write your code here.

		int rev = 0;
		int originalN = n;
		while(n != 0){
			int l = n % 10;
			rev = (rev * 10) + l;
			n = n / 10;
		}
		// return rev;
		if (rev == originalN) {
			return true;
		}
		return false;
	}

	public static boolean armstrong(int s) {
		int sum = 0;
		int originalS = s;
		while(s > 0) {
			int remain = s % 10;
			sum = sum + (int) Math.pow(remain, countDigits(originalS));
			System.out.println("sum = " + sum);
			s = s/10;
		}
        return originalS == sum;
    }

	public static void main(String[] args) {

		int input = takeInput();
		int n = 123456;
		switch (input) {

			case 1:
				//count
				int n1 = 12345;
				System.out.println("countDigits = " + countDigits(n1));
				break;

			case 2:
				//evenlyDivides
				int n2 = 342;
				System.out.println("evenlyDivides = " + evenlyDivides(n2));
				break;

			case 3:
				//reverse
				int n3 = 32;
				System.out.println("reverse = " + reverse(n3));
				break;

			case 4:
				//palindromeNumber
				int n4 = 32;
				System.out.println("palindromeNumber = " + palindromeNumber(n4));
				break;

			case 5:
				//sumOfDivisors
				int n5 = 4;
				long result1 = sumOfDivisors(n5);
				System.out.println("result1 = " + result1);
				long result2 = sumOfDivisorsNewOptimisedFunction(n5);
				System.out.println("result2 = " + result2);
				break;

			case 6:
				//armstrong
				int n6 = 1634;
				System.out.println(armstrong(n6));
				break;

			case 7:
				break;

			case 8:
				break;

			case 9:
				break;

			default:
				System.out.println("default: wrong input");
				break;

		}
	}

}