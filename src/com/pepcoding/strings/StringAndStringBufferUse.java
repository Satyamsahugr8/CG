package com.pepcoding.strings;

import java.util.Arrays;

/**
 * StringAndStringBufferUse.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 06-Jun-2025
 */
public class StringAndStringBufferUse {

	public static void main(String[] args) {
		StringAndStringBufferUse obj = new StringAndStringBufferUse();
		String str = new String("satyam sahu");
//		int num = obj.countChar(str);
//		System.out.println(num);
		
		System.out.println(str.substring(4)); // am
		System.out.println(str.substring(1,5)); // atya
		System.out.println(str.charAt(4)); // a
		System.out.println(str.concat("d")); // satyamd
		System.out.println(str.startsWith("sat"));
		System.out.println(str.endsWith("am"));
		System.out.println(str.indent(1));
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf("s"));
		System.out.println(str.replace('a', 't'));
		System.out.println(str.replaceAll("s", "ss"));
		System.out.println(str.strip());
		System.out.println(str.trim());
		System.out.println(str.split(" "));
		System.out.println(str.chars());
		
		
		
		

	}
	
	public int countChar(String str) {
		char [] ch = str.toCharArray();
		int count = 0;
		
		for (char c : ch) {
			System.out.println(c);
			count++;
		}
		
		return count;
	}
}
