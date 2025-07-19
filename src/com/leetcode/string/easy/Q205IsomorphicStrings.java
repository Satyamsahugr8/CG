package com.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q205IsomorphicStrings.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 11-Jun-2025
 */
public class Q205IsomorphicStrings {

	public static void main(String[] args) {

		Q205IsomorphicStrings a = new Q205IsomorphicStrings();
		boolean answer = a.isIsomorphic("egg", "add");
		System.out.println(answer);
		
	}
	
	public boolean isIsomorphic(String s, String t) {
		
		if ( s.length() != t.length() ) return false;
		
//        Map<Character, Integer> maps = new TreeMap<>();
//        Map<Character, Integer> mapt = new TreeMap<>();
//        
//        for (int i = 0; i < s.length(); i++) {
//        	maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
//        	maps.put(t.charAt(i), maps.getOrDefault(t.charAt(i), 0) + 1);
//		}
//        
//        if (maps.entrySet().equals(mapt.entrySet()) ) return true;
//        else return false;
        
        
        Map<Character, Character> mapST = new HashMap<>();
//        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if ( mapST.containsKey(c1) ) {
                if ( mapST.get(c1) != c2 ) return false;
            } else {
                mapST.put(c1, c2);
            }

//            if (mapTS.containsKey(c2)) {
//                if (mapTS.get(c2) != c1) return false;
//            } else {
//                mapTS.put(c2, c1);
//            }
        }

        return true;
    }
	
	
}
