package com.tufplus.string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SubsetOfString.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 18-Jun-2025
 */
public class SubsetOfString {

	public static void main(String[] args) {

		SubsetOfString a = new SubsetOfString();
		
		String s = "AABABBA";
		
		// output
		// ["","a","b","c","ab","abc","bc"]
		
//		ArrayList<String> arrList = new ArrayList<String>();
//		recurrsiveCall(arrList, s, "", 0);
//		arrList.stream().forEach(System.out::println);
		
		a.iteration(s);

	}
	
	// s = "AABABBA";
	// A,AA,AAB,AABA,AABAB,AABABB,AABABBA
	// A,AB,ABA,ABAB,ABABB,ABABBA
	//
	public static void iteration(String s) {
		
//		int n = s.length();
//		int i = 0;
//		int j = n;
		
		ArrayList<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int max = 0;
        int i = 0;
        int j = 0;

        while ( i < n ) {
        
            j = i + 1;
            while ( j <= n ) {
                
            	String ss = s.substring(i,j);
//            	list.add(s.substring(i,j).toString());
            	
//            	for ( ) {
//            		
//            	}
//            	map.put() {
//            		
//            	}
                
                j++;
            }
            
            i++;
        }
        
        System.out.println(list.toString());
        
		return;
	}
	
	// using recursion 
	private static void recurrsiveCall(ArrayList<String> arrList, String s, String ans, int start) {
		
		if (s.equals("")) {
			return;
		}
		
		if ( start == s.length() ) {
			arrList.add(ans);
			return;
		}

		// not choose
		recurrsiveCall(arrList, s, ans, start+1);
		
		// choose
		ans = ans + s.charAt(start);
		recurrsiveCall(arrList, s, ans, start+1);
		
	}
}
