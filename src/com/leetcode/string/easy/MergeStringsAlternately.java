package com.leetcode.string.easy;

public class MergeStringsAlternately {
	
	public static String mergeAlternately(String word1, String word2) {
		
		int i = 0;
		int j = 0;
		String finalString = "";
		while(i<word1.length() && j<word2.length()) {
			finalString += word1.charAt(i);
			finalString += word2.charAt(j);
			i++;j++;
		}
		
		while(i<word1.length()) {
			finalString += word1.charAt(i);
			i++;
		}
		
		while(j< word2.length()) {
			finalString += word2.charAt(j);
			j++;
		}
		
		return finalString;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		String  ss = "pqr";
		
		System.out.println(mergeAlternately(s, ss));
	}

}
