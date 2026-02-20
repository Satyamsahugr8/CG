package com.leetcoder.pattern.array.slidingwindow2pointervariable;

import java.util.HashMap;
import java.util.Map;

/**
 * QminimumSlidingWindow.java
 * 
 * Description: Longest substring without repeating
 * 
 * @author satyamsahu
 * @since 10-Oct-2025
 */
public class QminimumSlidingWindow {

	public static void main(String[] args) {
		
		String s = "TOTMTAPTaaAT";
		String ss = "TTA";
		minimumSlidingWindow(s, ss);
	}
	
	public static void minimumSlidingWindow(String txt, String pat) {
	    char[] arr = txt.toCharArray();
	    int n = arr.length;
	    Map<Character, Integer> map = new HashMap<>();

	    for (char c : pat.toCharArray()) {
	        map.put(c, map.getOrDefault(c, 0) + 1);
	    }

	    int count = map.size(); // distinct characters left to match
	    int i = 0, j = 0;
	    int minLen = Integer.MAX_VALUE;
	    int startIndex = -1;

	    while (j < n) {

	        // Step 1: expand j
	        if (map.containsKey(arr[j])) {
	            map.put(arr[j], map.get(arr[j]) - 1);
	            if (map.get(arr[j]) == 0) count--; // matched one char completely
	        }

	        // Step 2: try shrinking when all matched
	        while (count == 0) {
	            
	        	// record smallest window
	            if (j - i + 1 < minLen) {
	                minLen = j - i + 1;
	                startIndex = i;
	            }

	            // remove left char
	            if (map.containsKey(arr[i])) {
	                map.put(arr[i], map.get(arr[i]) + 1);
	                if (map.get(arr[i]) == 1) count++; // lost one match
	            }
	            
	            i++;
	        }

	        j++;
	    }

	    if (startIndex == -1) {
	        System.out.println("No such window exists");
	    } else {
	        System.out.println("Minimum window: " + txt.substring(startIndex, startIndex + minLen));
	        System.out.println("Length: " + minLen);
	    }
	}

}
