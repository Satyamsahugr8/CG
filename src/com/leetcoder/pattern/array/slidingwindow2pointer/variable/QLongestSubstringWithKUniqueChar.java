package com.leetcoder.pattern.array.slidingwindow2pointer.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * QLongestSubstringWithKUniqueChar.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QLongestSubstringWithKUniqueChar {

	public static void main(String[] args) {
		
		String str = "aabacbebebe";
		int k = 3;
		char [] arr = str.toCharArray();
		int n = arr.length;
//		int k = 3; // k unique char 
		int i = 0;
		int j = 0;
		int max = -1;
		
		Map<Character, Integer> map = new HashMap<>();
		
		
		
		while ( j < n ) {
			
			// condition for j
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            // shrink window if sum exceeds k
            while ( map.size() > k && i <= j ) {
            	
            	// remove from map
            	int value = map.get(arr[i]);
            	
            	if ( value == 1 ) {
            		map.remove(arr[i]);
            	} 
            	
            	else {
            		map.put(arr[i], value - 1);
            	}
            	
                i++;
            }

            // check if sum equals k
            if ( map.size() == k ) {
                max = Math.max(max, j - i + 1);
            }

            j++;
			
		}
		
		System.out.println("ans : " + max);

	}
}
