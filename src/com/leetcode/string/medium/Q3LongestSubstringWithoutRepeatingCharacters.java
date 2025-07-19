package com.leetcode.string.medium;

import java.util.HashSet;

/**
 * Q3LongestSubstringWithoutRepeatingCharacters.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 13-Jun-2025
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		Q3LongestSubstringWithoutRepeatingCharacters a = new Q3LongestSubstringWithoutRepeatingCharacters();
		String str = "asjrgapa";//"dvdf";//"pwwkew";//"bbbbb";//"abcabcbb";
		int i = a.lengthOfLongestSubstring(str);
		System.out.println("count : " + i);
		
	}
	
	public int lengthOfLongestSubstring(String s) {
		
		if ( s.length() <= 1 ) {
			return s.length();
		}
		
		HashSet<Character> set = new HashSet<>();
		HashSet<Character> setB = new HashSet<>();
		int max = 0;
		int count = 0;
		int countB = 0;
		int p = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			if (!set.contains(s.charAt(i))) {
				count += 1;
				max = Math.max(max, count);
				set.add(s.charAt(i));
			} else {
				i = p;
				p += 1;
				count = 1;
				set = new HashSet<Character>();
				set.add(s.charAt(i));
			}
			
		}
		
		for (int j = s.length() - 1; j >= 0; j--) {
			
			if (!setB.contains(s.charAt(j))) {
				countB += 1;
				max = Math.max(max, countB);
				setB.add(s.charAt(j));
			} else {
				countB = 1;
				setB = new HashSet<Character>();
				setB.add(s.charAt(j));
			}
			
		}

        return max;
    }
	
}
