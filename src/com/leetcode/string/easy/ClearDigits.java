package com.leetcode.string.easy;

public class ClearDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cb34";
		s = clearDigits(s, 0, s.length());
		System.out.println(s);
	}
	
	static String clearDigits(String str, int i , int strL) {
		
		if ( str.length() == 0 ) return str;
		
//		if ( i >= strL ) return str;
		
		if ( 48 <= str.charAt(i) && str.charAt(i) <= 58 ) {
				String s = (( i-1 < 0 ) ? "" : str.substring(0, i-1)) + str.substring(i+1);
				System.out.println("s : " + s);
				return clearDigits(s, 0, s.length());
		}
		
		return clearDigits(str, i+1, str.length());
	}

}
