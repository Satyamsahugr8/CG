package com.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		double[] temp = new double[2];
//		
//		for (double d : temp) {
//			System.out.println(d);
//		}
//		
//		stringCon("2","3");

//		String d = occurance("cczazcc", 3);
//		aababab 2
//		String d = occurance("aababab", 2);
//		System.out.println(d);

//		int b = replaceChar("a", "n");
//		System.out.println(b);

//		boolean s = canMakeSubsequence("zc", "ad");
//		System.out.println(s);

//		String[] result = generateIncrementedCombinations("abc");
//
//        for (String s : result) {
//            System.out.println(s);
//        }

//		int a = anyBaseToDecimal(1110, 2);
//		System.out.println(a);
//		
//		int c = decimalToAnyBase(12789, 58);
//		System.out.println(c);

//		int b = anyBaseToAnyBase(178, 10, 2);
//		System.out.println(b);

//		String s = "c";
//		String e = s.substring(1);
//		System.out.println(e.length());

//		boolean isPreSufix = isprefixSuffix("a", "aba");
//		System.out.println("is : "+isPreSufix);

//		String[] words = {"a","aba","ababa","aa"};
//		String[] words = {"pa","papa","ma","mama"};
//		int s = countPrefixSuffixPairs(words);
//		System.out.println(s);

//		String[] words = {"pay","attention","practice","attend"};
//		int count = 0;
//		for (int i = 0; i < words.length; i++) {
//			if (matchPrefix("at", words[i])) {
//				count++;
//			}
//		}
//		
//		System.out.println(count);

//		int[][] ar = new int[3][3];
//		ar[0][0] = 0;
//		ar[0][1] = 1;
//		ar[0][2] = 1;
//		ar[1][0] = 1;
//		ar[1][1] = 0;
//		ar[1][2] = 1;
//		ar[2][0] = 1;
//		ar[2][1] = 0;
//		ar[2][2] = 1;
//		
//		ar = swapVertically(ar);
//		
//		for (int j = 0; j < ar.length; j++) {
//			for (int i = 0; i < ar.length; i++) {
//	            System.out.print(ar[j][i]);
//	        }
//			System.out.println();
//		}

		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "e", "o", "oo" };

		List<String> s = wordSubsets(words1, words2);

		System.out.println(s);
	}

	public static List<String> wordSubsets(String[] words1, String[] words2) {

		HashMap<Character, Integer> charCountMap = new HashMap<>();

		for (int i = 0; i < words2.length; i++) {
			HashMap<Character, Integer> chars = new HashMap<>();
			String str = words2[i];

			for (int j = 0; j < str.length(); j++) {
				Character s = str.charAt(j);
				chars.put(s, charCountMap.getOrDefault(s, 0) + 1);
			}

			charCountMap.putAll(chars);

		}

		System.out.println(charCountMap);

		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < words1.length; i++) {
			
			HashMap<Character, Integer> chars = new HashMap<>();
			String str = words1[i];
		
			//adding in map
			for (int j = 0; j < str.length(); j++) {
				Character s = str.charAt(j);
				chars.put(s, chars.getOrDefault(s, 0) + 1);
			}
			

			
		}
		
		

		return list;
	}

	public static int[][] swapVertically(int[][] arr) {

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length / 2; i++) {
				// Swap elements
				int temp = arr[j][i];
				arr[j][i] = arr[j][arr.length - 1 - i];
				arr[j][arr.length - 1 - i] = temp;
			}
		}

		return arr;

	}

	public static int[][] swap1To0(int[][] arr) {

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[j][i] == 0)
					arr[j][i] = 1;
				else if (arr[j][i] == 1)
					arr[j][i] = 0;
			}
		}

		return arr;

	}

	public static boolean matchPrefix(String pre, String str2) {

		if (str2.length() < pre.length())
			return false;

		for (int i = 0; i < pre.length(); i++) {
			if (str2.charAt(i) != pre.charAt(i))
				return false;
		}

		return true;
	}

	public static int countPrefixSuffixPairs(String[] words) {

		int n = words.length;
		int count = 0;

		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j < n; j++) {

				boolean isPreSufix = isprefixSuffix(words[i], words[j]);

				if (isPreSufix) {
					count = count + 1;
				}

			}
		}

		return count;
	}

	private static boolean isprefixSuffix(String str1, String str2) {

		int n1 = str1.length();
		int n2 = str2.length();

		if (n1 > n2)
			return false;

		// prefix suffix
		for (int i = 0; i < n1; i++) {
			if (str2.charAt(i) != str1.charAt(i)) {
				return false;
			}
		}

		// suffix
		for (int i = n2 - n1, j = 0; j < n1; i++, j++) {
			if (str2.charAt(i) != str1.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	private static int anyBaseToAnyBase(int n, int b1, int b2) {
		// TODO Auto-generated method stub
		int decimal = anyBaseToDecimal(n, b1);
		int any = decimalToAnyBase(decimal, b2);
		return any;
	}

	private static int anyBaseToDecimal(int n, int b) {
		// TODO Auto-generated method stub
		int rv = 0;
		int p = 1;
		while (n > 0) {
			int dig = n % 10;
			n = n / 10;
			rv += dig * p;
			p = p * b;
		}

		return rv;

	}

	private static int decimalToAnyBase(int n, int b) {
		// TODO Auto-generated method stub
		int rv = 0;
		int p = 1;
		while (n > 0) {
			int dig = n % b;
			n = n / b;

			rv += dig * p;
			p = p * 10;
		}

		return rv;

	}

	public static String[] generateIncrementedCombinations(String input) {
		List<String> combinations = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char[] chars = input.toCharArray();

			// Increment the current character
			chars[i] = (char) (chars[i] + 1);
			combinations.add(new String(chars));

			// Increment subsequent characters
			for (int j = i + 1; j < input.length(); j++) {
				char[] tempChars = chars.clone();
				tempChars[j] = (char) (tempChars[j] + 1);
				combinations.add(new String(tempChars));
			}
		}

		return combinations.toArray(new String[0]);
	}

	public static int replaceChar(String S, String T) {
		char[] strArray = T.toCharArray();

		if (S.length() == 1) {
			return 0;
		}

		for (int i = 0; i < strArray.length - 1; i++) {
			// replace 1 and 2
			char temp = strArray[i];
			strArray[i] = strArray[i + 1];
			strArray[i + 1] = temp;

			if (!S.equals(String.valueOf(strArray))) {
				return 1;
			}
		}

		return 0;
	}

	public static String occurance(String str, Integer repeatIndex) {

		String newString = "";

		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		char[] strArray = str.toCharArray();

		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1);
			}
		}

		for (Map.Entry entry : charCountMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			int countM = (Integer) entry.getValue();
			int count = (Integer) entry.getValue();
			Character c = (Character) entry.getKey();

			for (int i = 1; i <= countM; i++) {

				if (i <= repeatIndex) {
					newString += entry.getKey();

					System.out.println(count);
					if (charCountMap.containsKey(c)) {
						count = count - 1;
						charCountMap.put(c, count);
					}
				}

			}
		}

//		while (!charCountMap.values().isEmpty()) {
//			newString += charCountMap.keySet();
//			break;
//		}

		for (Map.Entry entry : charCountMap.entrySet()) {
//			for (int i = 0; i < strArray.length; i++) {
//				
//			}
			System.out.println(entry.getKey() + " " + entry.getValue());
			if ((Integer) entry.getValue() != 0 && (Integer) entry.getValue() < repeatIndex) {
				newString += (Character) entry.getKey();
			}

		}

		return newString;
	}

	public static void stringCon(String s1, String s2) {
		int result = Integer.valueOf(s1) + Integer.valueOf(s2);
		System.out.println(String.valueOf(result));
	}

	public static boolean canMakeSubsequence(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {
			return false;
		}

		if (str1.length() == str2.length()) {

			if (str1.equals(str2))
				return true;

			String[] result = generateIncrementedCombinations(str1);

			for (String string : result) {
				System.out.println(string);
				if (string.equals(str2))
					return true;
			}

		}

		if (str1.length() != str2.length()) {

			String[] strArr = stringSubsequent(str1);
			for (String string : strArr) {

				if (string.length() == str2.length()) {

					if (string.equals(str2))
						return true;

					String[] result = generateIncrementedCombinations(string);

					for (String ss : result) {
						if (ss.equals(str2))
							return true;
					}

				}
			}
		}

		return false;

	}

	public static String[] stringSubsequent(String str) {

		if (str.length() == 0) {
			String ans[] = { "" };
			return ans;
		}

		String smallAns[] = stringSubsequent(str.substring(1));
		String ans[] = new String[2 * smallAns.length];

		int k = 0;
		for (int i = 0; i < smallAns.length; i++) {
			ans[k] = smallAns[i];
			k++;
		}

		for (int i = 0; i < smallAns.length; i++) {
			ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
		}

		return ans;
	}
}
