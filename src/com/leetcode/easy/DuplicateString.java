package com.leetcode.easy;

public class DuplicateString {
	
	public static void main(String[] args) {
		
		String str = "pooja";
		
		System.out.println(str);
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					
				}
			}
		}
		
	}

}
