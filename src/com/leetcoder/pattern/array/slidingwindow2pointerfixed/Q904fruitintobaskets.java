package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Q904fruitintobaskets.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 28-Jun-2025
 */
public class Q904fruitintobaskets {

	public static void main(String[] args) {

		Q904fruitintobaskets a = new Q904fruitintobaskets();
		
		int [] arr = {1,2,3,2,2};
		int answer = a.totalFruit(arr);
		System.out.println("answer : " + answer);
	}


	public int totalFruit(int[] fruits) {
		
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		while ( i <= j && j < fruits.length ) {
			
			map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
			
			if ( map.size() <= 2 ) {
				max = Math.max(max, j - i + 1); 
			}
			
			if ( map.size() > 2 ) {
				map.put(fruits[i], map.get(fruits[i]) - 1);
				if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
				i++;
			}
			
			j++;
			
		}
		
		return max;
    }
	
}
