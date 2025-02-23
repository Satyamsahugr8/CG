package com.codingninjas.string;

public class Solution {
	
	public static void main(String[] args) {
		
//		String answer = stringReformat("Isa-dkj", 4);
//		String aa = stringReformatReverse("Isa-dkj", 4);
//		System.out.println(answer + " " + aa);
		int i = 37;
		int num = methodMP(i);
		System.out.println(num);
	}
	
	// a1-ijklmno-par
	// A1I-JKL-MNO-PQR
	
	public static String stringReformat(String s, int k) {
		
		if ( s.length() == 0 ) return s;
		
		s = s.replace("-", "");
		String ans = "";
		
//		for (String string : p) {
//			System.out.println(string);
//		}
		
		for (int i = 0; i < s.length(); i = i + k) {
			
			if ( i + k < s.length() ) {
				ans += s.substring(i, i + k) + "-";
			} else {
				ans += s.substring(i);
			}
		}
		
		return ans.toUpperCase();
	}
	
	public static String stringReformatReverse(String s, int k) {
		// Write your code here

		if ( s.length() == 0 ) return s;

		String ans = "";
		s = s.replace("-","");

		for ( int i = s.length(); i > 0; i = i - k) {

			if ( i - k > 0 ) {
				ans = "-" + s.substring(i - k, i) + ans;
			}
			else {
				ans = s.substring(0, i) + ans;
			}
		}

		return ans.toUpperCase();
	}

	public static int methodMP(int i) {
		
		int num = 0;
		
		for (int j = 1; j <= i; j++) {
			if ( check(j, j*j, 0) ) {
				System.out.println(j);
				num += j*j;
			}
		}
		
		return num+1;
		
	}
	
	public static boolean check(int n, int s, int sum) {
		
		if ( s == 0) return n == sum;
		
		return check(n, s / 10, sum + s % 10) || check(n, s / 100, sum + s % 100)
		|| check(n, s / 1000, sum + s % 1000) || check(n, s / 10000, sum + s % 10000);
	}
	
	public static boolean check(int n, String s, int sum) {
		
		if ( sum > n ) return false;
		
		if ( sum == n ) return true;
		
		System.out.println("s " + s);
		
		for (int l = 1; l < s.length(); l++) {
			
			String curr = s.substring(0, l);
			
			sum += Integer.parseInt(curr);
			System.out.println("curr " + curr);
 			
			String remain = s.substring(l); 
			System.out.println("remain " + remain);
			
			if ( sum + Integer.parseInt(remain) == n ) return true;
			
			if (check(n, remain, sum)) {
				return true;
			}
			
//			System.out.println("L " +l);
			sum = 0;
		}
		
		return false;
	}
	

}
