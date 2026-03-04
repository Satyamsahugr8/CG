package com.codingninjas.recursion;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.recursion.Solution;

/**
 * PermutationString.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 27-Sep-2025
 */
public class PermutationString {

	public static void main(String[] args) {

		// permutation
		System.out.println("String permutation : ");
		String st = "adg";
		String[] outtt = returnPermutation(st);
		List<String> outt = returnPermutationList("adg");
		for (String is2 : outtt) {
			System.out.println(is2 + " ");
		}

		System.out.println();
		// printpermutation
		System.out.println("print String permutation : ");
		printpermutation("agd", "");
		
	}

	private static void printpermutation(String str, String output) {

		if (str.length() == 0) {
			System.out.println(output);

		}

		for (int i = 0; i < str.length(); i++) {

			String newStr = "";

			for (int j = 0; j < str.length(); j++) {
				if (i != j) {
					newStr += str.charAt(j);
				}
			}
			String newOut = output + str.charAt(i);

			printpermutation(newStr, newOut);

		}

	}

	private static List<String> returnPermutationList(String str) {

		if (str.length() == 0) {
			List<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}
		
//		System.out.println(str);
		
		if (str.length() == 1) {
			List<String> ans = new ArrayList<String>();
			ans.add(str);
			return ans;
		}

		// recursion call
		List<String> small = returnPermutationList(str.substring(1));
		List<String> answer = new ArrayList<String>();

		for (int i = 0; i < small.size(); i++) {
			String currentString = small.get(i);
			for (int j = 0; j <= currentString.length(); j++) {
				answer.add(
						currentString.substring(j) + str.charAt(0) + currentString.substring(0, j)
					);
			}
		}

		return answer;
	}

	private static String[] returnPermutation(String str) {

		if (str.length() == 0)
			return new String[] { "" };
		if (str.length() == 1)
			return new String[] { str };

		// recursion call
		String[] small = returnPermutation(str.substring(1));
		String[] answer = new String[small.length * str.length()];
		char c = str.charAt(0);

		int t = 0;

		for (int i = 0; i < small.length; i++) {
			String currentString = small[i];
			for (int j = 0; j <= currentString.length(); j++) {
				// main logic for permutation
				answer[t] = currentString.substring(0, j) + c + currentString.substring(j);
				t++;
			}
		}

		return answer;
	}
	
}
