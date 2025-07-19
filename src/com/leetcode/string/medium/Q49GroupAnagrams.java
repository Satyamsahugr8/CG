package com.leetcode.string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q49GroupAnagrams.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 11-Jun-2025
 */
public class Q49GroupAnagrams {

	public static void main(String[] args) {

		Q49GroupAnagrams a = new Q49GroupAnagrams();

		String[] strArray = { "eat", "tea", "tan", "ate", "nat", "bat" };
		boolean[] visited = new boolean[strArray.length];
		List<List<String>> ans = a.groupAnagrams(strArray, visited);

		System.out.println(ans.toString());

	}

	public List<List<String>> groupAnagrams(String[] strArray, boolean[] visited) {

		if (strArray.length == 1) {
			return Arrays.asList(Arrays.asList(strArray));
		}

		List<List<String>> result = new ArrayList<List<String>>();

		for (int i = 0; i < strArray.length; i++) {
			
			List<String> answer = new ArrayList<>();
			
			if (visited[i] == true) {
				// skip
				continue;
			}
			
			visited[i] = true;
			answer.add(strArray[i]);
			
			char[] curr = strArray[i].toCharArray();
			Arrays.sort(curr);
			String scurr = new String(curr);

			for (int j = i + 1; i + 1 < visited.length && j < visited.length; j++) {

				if ( visited[j] == true || strArray[j].length() != scurr.length() ) {
					continue;
				}
				
				char[] next = strArray[j].toCharArray();
				Arrays.sort(next);
				String snext = new String(next);
				
				if ( scurr.equals(snext) ) {
					answer.add(strArray[j]);
					visited[j] = true;
				}
				
			}
			
			result.add(new ArrayList<>(answer));

		}

		return result;
	}
}
