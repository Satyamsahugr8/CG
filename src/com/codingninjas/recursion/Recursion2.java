package com.codingninjas.recursion;

public class Recursion2 {

	public static void main(String[] args) {
		
		String str = "sipip";
		String target = replacePi(str);
		System.out.println(target);
		
		String str2 = "1234";
		System.out.println(stringToInt(str2));

		String str3 = "aaaa";
		System.out.println(pairStarAdd(str3));
		
		// given input 3 and 3 tower 
		int n = 3;
		int ans = towerOfHanoi(n, "S","A","D");
		System.out.println("ans : "+ ans);
	}
	
	private static int towerOfHanoi(int n, String source, String auxilary, String destination) {
		
		// base case // S A D
		
		if ( n == 1 ) {
			System.out.println(source + " -> " + destination);
			return 1;
		}
		// call for small 
		int small = towerOfHanoi(n - 1, source, destination, auxilary);
		small++;
		System.out.println(source + " -> " + destination);
		int movesmalltofinall = towerOfHanoi(n - 1, auxilary, source, destination);
		small += movesmalltofinall;
		return small;
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
//		str = str.charAt(0) + str;
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
		if 
		(str.length() <= 0) {
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
