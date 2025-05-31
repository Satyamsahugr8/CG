package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequnces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String atr ="abc";
		List<String> ans = new ArrayList<String>();
		subSequences(atr, 0, "", ans);
		
		for (String string : ans) {
			System.out.println(string);
		}
	}
	
	public static void subSequences(String str, int i, String answer, List<String> ansList) {
		
		if ( i == str.length() ) {
			ansList.add(answer);
			return;
		}
		
		// include
		subSequences(str, i + 1, answer + str.substring(i, i+1), ansList);
		
		// exclude
		subSequences(str, i + 1, answer, ansList);
		
		return;
	}

}
