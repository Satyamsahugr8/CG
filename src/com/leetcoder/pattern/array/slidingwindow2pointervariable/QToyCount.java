package com.leetcoder.pattern.array.slidingwindow2pointervariable;

import java.util.HashMap;
import java.util.Map;

/**
 * QToyCount.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 08-Oct-2025
 */
public class QToyCount {

	public static void main(String[] args) {
		String str = "abaccab";
		int k = 2;
		countToy(str, k);
	}
	
	static void countToy(String str, int k) {
		
		char [] arr = str.toCharArray();
		int n = arr.length;
		Map<Character, Integer> map = new HashMap<>();
		int ans = 0;
		int i = 0;
		int j = 0;
		
		while ( j < n ) {
						
			// Step 1: Add current char
		    map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

		    // Step 2: If window has more than k distinct chars, shrink it
		    while (i < j && map.size() > k) {
		        map.put(arr[i], map.get(arr[i]) - 1);
		        if (map.get(arr[i]) == 0) map.remove(arr[i]);
		        i++;
		    }
			
			// Step 3: window not reached size k
			if ( map.size() < k ) {
				j++;
			}
			
			// Step 4: when size == k
			if ( map.size() == k ) {
				
				ans = Math.max(ans, j - i + 1);
				System.out.println("ans : " + ans);
				
				j++;
			}
			
		}
		
		System.out.println("count : " + ans);
	}
}
