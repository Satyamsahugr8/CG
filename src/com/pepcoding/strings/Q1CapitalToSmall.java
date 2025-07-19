package com.pepcoding.strings;

/**
 * Q1CapitalToSmall.java
 * 
 * Description: pepcoding problem
 * 
 * @author satyamsahu
 * @since 02-Jun-2025
 */
public class Q1CapitalToSmall {

	public static void main(String[] args) {
		Q1CapitalToSmall obj = new Q1CapitalToSmall();
		String answer = obj.capitalizeSmallize("pepCODing");
		System.out.println(answer);
	}
	
	public String capitalizeSmallize(String s) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				sb.append((char) (ch + 'A' - 'a')); // upper case
			} else {
				sb.append((char) (ch - 'A' + 'a')); // lower case
				
			}
			
		}
		
		return sb.toString();
	}

}
