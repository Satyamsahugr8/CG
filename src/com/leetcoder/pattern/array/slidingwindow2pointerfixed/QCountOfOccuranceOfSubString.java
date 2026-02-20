package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * QCountOfOccurance.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QCountOfOccuranceOfSubString {

	public static void main(String[] args) {
		
//		Input: txt = "forxxorfxdofr", pat = "for"
//		Output: 3
		
		// String txt = "forxxorfxdofr"; //"zbcoejuvpvaboyg";
		// String pat = "for";

		String txt = "abababa"; //"zbcoejuvpvaboyg";
		String pat = "aba";
		
		allAnagram(txt, pat);
		

	}
	
//		Example 1:
//
//		Input: txt = "forxxorfxdofr", pat = "for"
//		Output: 3
//		Explanation: for, orf and ofr appears in the txt, hence answer is 3.
//		
//		Example 2:
//
//		Input: txt = "aabaabaa", pat = "aaba"
//		Output: 4
//		Explanation: aaba is present 4 times in txt.
	
	public static void allAnagram(String txt, String pat) {
	
		char [] arr = txt.toCharArray();
		int n = arr.length;
		int ans = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<Integer>();
		int size = pat.length();
		
		for ( int i = 0; i < pat.length(); i++ ) {
			map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
		}
		
		int count = map.size();
		int i = 0;
		int j = 0;
		
		while ( j < n ) {
			
			// Step 1: calculation for j
			if ( map.containsKey(arr[j]) ) {
				map.put(arr[j], map.get(arr[j]) - 1);
				if (map.get(arr[j]) == 0)
	                count--; // matched one character completely
			}
			
			// Step 2: window not reached size k
			if ( j - i + 1 < size ) {
				j++;
			}
			
			// Step 3: when window size == k
			else if ( j - i + 1 == size ) {
				
				// all characters matched
				if ( count == 0 ) {
					ans++;
					list.add(i);
				}
				
				// Step 4: remove i (slide window)
				if ( map.containsKey(arr[i]) ) {
					map.put(arr[i], map.get(arr[i]) + 1);
					if (map.get(arr[i]) == 1)
	                    count++; // lost one match
				}
				
				i++;
				j++;
			}
			
		}
		
		System.out.println("count : " + ans + " " + list);
		
	}
	
}
