package com.codingninjas.resursion;

public class Recursion2Assignment {

	public static void main(String[] args) {
		
//		String str = "sipi";
//		String target = replacePi(str);
//		System.out.println(target);
		
//		String str = "1234";
//		System.out.println(stringToInt(str));

//		String str = "aaaa";
//		System.out.println(pairStarAdd(str));
		
	}
	
	public static String replacePi( String str) {
		
		String output;
		
		// base case
		if ( str.length() <= 1 ) {
			return str;
		}

		//recursive call
		String small = replacePi(str.substring(1));
		
		//small calculation
		str = str.charAt(0) + str;
		if (str.charAt(0) == 'p' && small.charAt(0) == 'i') {
			 output = "3.14" + small.substring(1);
		} 
		else {
			output = str.charAt(0) + small;
		}
		
		return output;
	}

	public static int stringToInt(String str) {
		
		int output = 0;
		
		//base 
		if(str.length() <= 0) {
			return 0;
		}
		
		if(str.length() == 1) {
			return Integer.valueOf(str);
		}
		
		//small
		int small = stringToInt(str.substring(0, str.length()-1));
		output = (small * 10) + Integer.valueOf(Character.toString(str.charAt(str.length()-1)));
		return output;
	}
	
	public static String pairStarAdd(String str) {
		
		String output;
		
		// base case
		if ( str.length() <= 1 ) {
			return str;
		}

		//recursive call
		String small = pairStarAdd(str.substring(1));
		
		//small calculation
		if (str.charAt(0) == small.charAt(0)) {
			 output = str.charAt(0) + "*" + small;
		} 
		else {
			output = str.charAt(0) + small;
		}
		
		return output;
	}
	
	
}
