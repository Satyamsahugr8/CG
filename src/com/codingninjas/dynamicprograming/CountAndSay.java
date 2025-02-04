package com.codingninjas.dynamicprograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class CountAndSay {

	public static void main(String[] args) {
//		System.out.println(count(10));
		
		int[][] ar = {{ 3, 4, 5 },{ 2, 7, 6 },{ 1, 2, 4 }};
		int[][] rr = 
				   {{7, 4, 3},
					{6, 10, 6},
					{10, 4, 4}};
		
		int [][]a = {{3, 9},{5, 9},{8, 10}};
		Vector<Integer> ssd = chuninNinja(3,3, rr);
		System.out.println(ssd);
	}
	
	
	// { 3, 4, 5 }, 
	// { 2, 7, 6 },
	// { 1, 2, 4 },
	
	
//	{3, 9},
//	{5, 9},
//	{8, 10}
	public static Vector<Integer> chuninNinja(int n, int m, int arr[][]) {
		
		Vector<Integer> chuni = new Vector<>();
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int minI = -1;
			int minJ = -1;
			
			for (int j = 0; j < arr[0].length; j++) {
				if ( min > arr[i][j]) {
					min = arr[i][j];
					minI = i;
					minJ = j;
				}
				
			}

			System.out.println(minI + " " + minJ);
			System.out.println(min);
			max = min;
			
			// we got row minimum now check if this is maxi in col or not
			for (int j = 0; j < arr.length; j++) {
				 if ( j != minI && max < arr[j][minJ] ) {
					 max = arr[j][minJ];
					 break;
				 }
			}
			
			if ( max == min ) {
				chuni.add(min);
				return chuni;
			}
		}
		
		
		return chuni;
    }
	
	
		// 1
		// 11
		// 21
		// 1211
	private static String describe(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        // Go through the string, counting runs of identical characters
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // Append the count and the character we were counting
                sb.append(count).append(s.charAt(i - 1));
                count = 1; // reset count for the new character
            }
        }
        
        // Append the last run
        sb.append(count).append(s.charAt(s.length() - 1));
        
        return sb.toString();
    }

	static String count(int n) {
		
		String storage[] = new String[n + 1];
		String newStr = "";
		
		if (n == 1) {
			storage[1] = "1";
			return storage[n];
		}
		
		storage[0] = "";
		storage[1] = "1";
		
		for (int i = 2; i <= n; i++) {
			
			String prev = storage[i-1];
			storage[i] = "";
			
			// count and add will return here
			newStr = describe(prev);
			storage[i] = newStr;
		}

		return storage[n];
	}

	private static String countAndAdd(String prev) {
		
		String str = "";
		int count = 1;
		for (int i = 0; i < prev.length(); i++) {
			
			char curr = prev.charAt(i);
			int j = i+1;
			while ( j < prev.length() && curr == prev.charAt(j)  ) {
				++count;
				j++;
				i++;
			}
			
			str += count +""+ curr;
			count = 1;
		}
		
		return str;
	}

	private static Map<Character, Integer> countString(String prev) {
		// TODO Auto-generated method stub
		
		Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Step 3: Iterate through the string and update the HashMap
        for (char ch : prev.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
		return charCountMap;
	}

	static int countBalancedBTDP(int h) {

		int storage[] = new int[h + 1];

		if (h == 0)
			return storage[0] = 1;
		if (h == 1)
			return storage[1] = 1;

		storage[0] = 1;
		storage[1] = 1;

		return countBalancedBTDP(h, (int) Math.pow(10, 9) + 7, storage);
	}

	static int countBalancedBTDP(int h, int mod, int[] storage) {

		for (int i = 2; i <= h; i++) {

			int x = storage[i - 1];
			int y = storage[i - 2];

			long val1 = (long) x * x;
			long val2 = (long) 2 * x * y;

			int v = (int) (val1 % mod);
			int vv = (int) (val2 % mod);

			storage[i] = (v + vv) % mod;
		}

		return storage[h];
	}

}
