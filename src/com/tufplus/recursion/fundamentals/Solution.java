package com.tufplus.recursion.fundamentals;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public static void main(String[] args) {
		
		System.out.println( generateParenthesis(1));
		
	}
	
    public static List<String> generateParenthesis(int n) {
    	
    	List<String> listOfString = new ArrayList<String>();
    	return recursion(n , 0, 0, listOfString);
    }

//    private List<String> listOfString = new ArrayList<String>();
	
    
    private static List<String> recursion(int n, int open, int close, List<String> listOfString) {
		
		if ( n == 0) {
			return new ArrayList<String>();
		}
		
		StringBuffer st = new StringBuffer(n);
		
		while ( close + open >= n ) {
			
			if ( open >= 0 ) {
				st.append('(');
				open++;
			} 
			
			if ( close >= 0 && open >= 1 ) {
				st.append(')');
				close++;
			}
		}
		
		if ( close == open ) {
			listOfString.add(st.toString());
		}
		
		// recursion call
		listOfString.addAll(recursion(n-1, open, close, listOfString));	
		
		return listOfString;
	}
}