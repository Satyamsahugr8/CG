package com.leetcoder.pattern.array.slidingwindow2pointer.variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * QLongestSubstringWithUniqueChar.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QLongestSubstringWithUniqueChar {

	public static void main(String[] args) {

		
		String s = "abcdefabcbb";
//		char [] arr = str.toCharArray();
//		int n = arr.length;
////		int k = 3; // k unique char 
//		int i = 0;
//		int j = 0;
//		int max = -1;
//		
////		Map<Character, Integer> map = new HashMap<>();
//		Set<Character> set = new HashSet<>();
//		
//		
//		while ( j < n ) {
//			
//			// condition
////			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
//			
//			// shrink
//			if (set.contains(arr[j])) {
//				
//				while ( i <= j ) {
//					
//					set.remove(arr[i]);
//					
//					if ( arr[i] == arr[j] ) {
//						i++;
//						break;
//					}
//					i++;
//				}
//			}
//			
//			set.add(arr[j]);
//
//            // shrink window if sum exceeds k
////            while ( map.size() > k && i <= j ) {
////            	
////            	// remove from map
////            	int value = map.get(arr[i]);
////            	
////            	if ( value == 1 ) {
////            		map.remove(arr[i]);
////            	} 
////            	
////            	else {
////            		map.put(arr[i], value - 1);
////            	}
////            	
////                i++;
////            }
//
//            // check if sum equals k
//            max = Math.max(max, j - i + 1);
//
//            j++;
//			
//		}
//		
//		System.out.println("ans : " + max);
		
		
		
		if (s.length() <= 1) {
//            return s.length();
			System.out.println(s.length());
        }

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        
        while ( right < s.length() ) { 
            
            if (!set.contains(s.charAt(right))) {
                max = Math.max(max, right - left + 1);
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            
        }

//        return max;
        System.out.println(max);
		
	}
}
