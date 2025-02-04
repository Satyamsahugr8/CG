package com.codingninjas.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingUsingArray {
	
	public static void main(String[] args) {
		
		//1
		int[] charArray = new int[256];
		
		String str = "abcbacbas";

		char[] charArray1 = str.toCharArray();
		
		for (char i : charArray1) {
			charArray[i]++;
		}
		
		for (int i : charArray) {
			System.out.print(i + " ");
		}
		
		
		
		//2
		System.out.println();
		// 1 - a
		// 2 - b
		// 3 - c
		System.out.println(('a'+ '1' - '0' - 1) );
		System.out.println( (char)('a'+ '1' - '0' - 1));
		
		
		
		
		//3
		
		Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Step 3: Iterate through the string and update the HashMap
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
	}

}
