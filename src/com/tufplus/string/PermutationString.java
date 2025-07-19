package com.tufplus.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PermutationString.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 18-Jun-2025
 */
public class PermutationString {

	static List<String> arrList = new ArrayList<String>();
	
	public static void main(String[] args) {

//		PermutationString a = new PermutationString();

		String s = "abc";
		// ["abc","acb","bac","bca","cab,"cba"]
		
		ArrayList<String> arrList = new ArrayList<String>();
		
		recurrsiveCall(s, 0);
		
		arrList.stream().forEach(System.out::println);
		

	}

	private static ArrayList<String> recurrsiveCall(String s, int start) {
		
		ArrayList<String> answer = new ArrayList<String>();
		
		if ( s.equals("") ) {
			answer.add("");
			return answer;
		}
		ArrayList<String> smallCall = new ArrayList<String>();
		smallCall = recurrsiveCall(s.substring(start+1), start+1);
		
		int a = start;
		
//		while ( ) {
//			for (int i = 0; i < answer.size(); i++) {
//				String s1 = smallCall.get(i);
//				// add at first 
//				answer.add(s1.substring(i) + s.charAt(a) + s1.substring(i));
//			}
//		}
		
		return null;
		
	}
}
