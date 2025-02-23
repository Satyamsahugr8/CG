package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adaptJavaQues.personalhealth.main;
@SuppressWarnings("unused")
public class Recursion3 {

//	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
////		boolean ff = sumsToK2(arr,0, 0, 8);
////		System.out.println(ff);
//		
//		int ss = sumsToK3Count(arr,0, 0, 8);
//		System.out.println(ss);
//	}
	
	public static void main(String[] args) {

		Map<Integer, Character[]> keypad = new HashMap<Integer, Character[]>();
		keypad.put(2, new Character[] { 'a', 'b', 'c' });
		keypad.put(3, new Character[] { 'd', 'e', 'f' });
		keypad.put(4, new Character[] { 'g', 'h', 'i' });
		keypad.put(5, new Character[] { 'j', 'k', 'l' });
		keypad.put(6, new Character[] { 'm', 'n', 'o' });
		keypad.put(7, new Character[] { 'p', 'q', 'r', 's' });
		keypad.put(8, new Character[] { 't', 'u', 'v' });
		keypad.put(9, new Character[] { 'w', 'x', 'y', 'z' });
		
		
		Map<Character, Character[]> keypadChar = new HashMap<Character, Character[]>();
		keypadChar.put('2', new Character[] { 'a', 'b', 'c' });
		keypadChar.put('3', new Character[] { 'd', 'e', 'f' });
		keypadChar.put('4', new Character[] { 'g', 'h', 'i' });
		keypadChar.put('5', new Character[] { 'j', 'k', 'l' });
		keypadChar.put('6', new Character[] { 'm', 'n', 'o' });
		keypadChar.put('7', new Character[] { 'p', 'q', 'r', 's' });
		keypadChar.put('8', new Character[] { 't', 'u', 'v' });
		keypadChar.put('9', new Character[] { 'w', 'x', 'y', 'z' });
		
		
//		String[] asds = new String[4];
//		ArrayList<String> arrstr = (ArrayList<String>) Arrays.asList(asds);

		// 1
		// string subsequences
		System.out.print("subsequences : ");
		String[] answer = findSubSequences("xyz");
		List<String> amss = findSubSequencesReturnList("abc");
		amss.remove(0);
		for (String string : amss) {
			System.out.println(string);
		}

		// 2
		// keyPad problem
		System.out.print("keypad : ");
		String[] str = findkeypadSubSequences(34, keypad);
		List<String> stre = findkeypadSubSequencesReturnList("23", keypadChar);
		String[] str2 = findkeypadSubSequences("23", keypadChar);
//		List<String> stre = findkeypadSubSequencesReturnList("234", keypad);
		for (String string : stre) {
			System.out.println(string);
		}

		// 1.b
		// print subsequences
		// top down process
		System.out.print("print subsequences : ");
		printsubsequences("xyz", "");

		System.out.println();

		// 2.b
		// print keypad
		System.out.print("print keypad : ");
		printkeypadsubsequences(23, keypad, "");

		System.out.println();

		// 3
		System.out.print("checkAB : ");
		boolean aaa = checkAB("bb", true);
		System.out.println(aaa);

		System.out.println();

		System.out.println();
		// 3.b
		System.out.print("checkAbBest : " + checkABBest("abb"));

		// 4
		// staircase problem
		System.out.println();
		System.out.print("stairCase : ");
		int b = stairCaseBest(3);
		System.out.println(b);

		System.out.println();
		System.out.println("return stair case : ");
		ArrayList<String> staircaseWays = PepcodingRecursion.stairCaseBestReturn(3);
		for (String string : staircaseWays) {
			System.out.println(string);
		}

		System.out.println();
		System.out.print("stairCaseDP : ");
		System.out.println(stairCaseBestDP(2));

		System.out.println();

		// 5
		System.out.println("5:");
		System.out.print("arraySubsequences : ");
		int[] arr = { 1, 2, 3 };
		int[] output = new int[0];
		int[][] answeer = arraySubsequences(arr, 0);
//		List<List<Integer>> lst = subsets(arr, 0);
//		for (List<Integer> is : lst) {
//			for (int is2 : is) {
//				System.out.print(is2 + " ");
//			}
//			System.out.println();
//		}

		System.out.println();
		// 5.b
		System.out.print("print arraySubsequences : ");
		printSubsetOfArray(arr, 0, output);

		System.out.println();
		// 6
		// return sums to k
		System.out.println("find sum to k : ");
		int[] arrr = { 3, 2, 5, 1, 4, 6 };
		int[][] annsss = sumsToK(arrr, 0, 8);

		for (int[] is : annsss) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("print find sum to k : ");

		int[] doutput = new int[0];
		printSubsetSumToK(arrr, 0, 8, doutput);

		// 7
		// return all codes

		Map<Integer, Character> map = new HashMap<>();

		// Populate the map
		for (int i = 1; i <= 26; i++) {
			map.put(i, (char) ('a' + i - 1));
		}

		System.out.println();
		System.out.println("All codes : ");
		String[] anssAtr = returnAllCodes("1123", map);
		for (String is2 : anssAtr) {
			System.out.println(is2);
		}

		// print
		System.out.println();
		System.out.println("print allcode : ");
		printAllCodes("1123", "");

		System.out.println();
		// permutation
		System.out.println("String permutation : ");
		String st = "adg";
//		String[] outtt = returnPermutation(st);
		List<String> outtt = returnPermutationList("abc");
		for (String is2 : outtt) {
			System.out.println(is2 + " ");
		}

		System.out.println();
		// printpermutation

		System.out.println("print String permutation : ");
		printpermutation("abc", "");

	}

	

	private static void printpermutation(String str, String output) {

		if (str.length() == 0) {
			System.out.println(output);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			String newStr = "";

			for (int j = 0; j < str.length(); j++) {
				if (i != j) {
					newStr += str.charAt(j);
				}
			}
			String newOut = output + str.charAt(i);

			printpermutation(newStr, newOut);

		}

	}

	private static List<String> returnPermutationList(String str) {

		if (str.length() == 0) {
			List<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}
		if (str.length() == 1) {
			List<String> ans = new ArrayList<String>();
			ans.add(str);
			return ans;
		}

		// recursion call
		List<String> small = returnPermutationList(str.substring(1));
		List<String> answer = new ArrayList<String>();

		for (int i = 0; i < small.size(); i++) {
			String currentString = small.get(i);
			for (int j = 0; j <= currentString.length(); j++) {
				answer.add(currentString.substring(j) + str.charAt(0) + currentString.substring(0, j));
			}
		}

		return answer;
	}

	private static String[] returnPermutation(String str) {

		if (str.length() == 0)
			return new String[] { "" };
		if (str.length() == 1)
			return new String[] { str };

		// recursion call
		String[] small = returnPermutation(str.substring(1));
		String[] answer = new String[small.length * str.length()];
		char firstChar = str.charAt(0);

		int t = 0;

//		for (int i = 0; i < small.length; i++) {
//			answer[t] = firstChar + small[i];
//			t++;
//		}
//		
//		for (int i = 0; i < small.length; i++) {
//			answer[t] = small[i] + firstChar + small[i];
//			t++;
//		}
//		
//		for (int i = 0; i < small.length; i++) {
//			answer[t] = small[i] + firstChar;
//			t++;
//		}

		for (int i = 0; i < small.length; i++) {
			String currentString = small[i];
			for (int j = 0; j <= currentString.length(); j++) {
				answer[t] = currentString.substring(0, j) + str.charAt(0) + currentString.substring(j);
				t++;
			}
		}

		return answer;
	}

	private static void printAllCodes(String str, String output) {

		if (str.length() == 0) {
			System.out.println(output);
			return;
		}

		int firstDigit = str.charAt(0) - '0';
		printAllCodes(str.substring(1), output + getChar(firstDigit));

		int firstTwoDigits = 0;
		if (str.length() >= 2) {
			firstTwoDigits = ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0');
			if (firstTwoDigits > 10 && firstTwoDigits <= 26) {
				printAllCodes(str.substring(2), output + getChar(firstTwoDigits));
			}
		}

	}

	public static char getChar(int n) {
		return (char) (96 + n);
	}

	private static String[] returnAllCodes(String str, Map<Integer, Character> map) {

		if (str.length() == 0) {
			return new String[] { "" };
		}

		int firstDigit = (str.charAt(0) - '0');

		String[] left = returnAllCodes(str.substring(1), map);
		String[] right = new String[0];

		int firstTwoDigits = 0;
		if (str.length() >= 2) {
//			int one = str.charAt(0);
//			int two = str.charAt(1);
			firstTwoDigits = ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0');
			if (firstTwoDigits > 10 && firstTwoDigits <= 26) {
				right = returnAllCodes(str.substring(2), map);
			}
		}

		int t = 0;
		String[] answer = new String[left.length + right.length];

		char s = getChar(firstDigit);
		for (int j = 0; j < left.length; j++) {
			answer[t] = s + left[j];
			t++;
		}

		char r = getChar(firstTwoDigits);
		for (int j = 0; j < right.length; j++) {
			answer[t] = r + right[j];
			t++;
		}

		return answer;
	}

	private static void printSubsetSumToK(int[] arr, int si, int sum, int[] output) {


		if (sum < 0) {
			return;
		}

		if (si == arr.length) {

			if (sum == 0) {

				for (int i : output) {
					System.out.print(i + " ");
				}
				System.out.println();
				return;
			}

			return;
		}

		int[] newOutput = new int[1 + output.length];

		int j = 0;
		for (int i : output) {
			newOutput[j] = i;
			j++;
		}

		newOutput[j] = arr[si];

		printSubsetSumToK(arr, si + 1, sum - arr[si], newOutput);
		printSubsetSumToK(arr, si + 1, sum, output);

	}
	
	private static int sumsToK3Count(int[] arr, int si, int sum, int target) {
		
		int count = 0;
		
		if ( si == arr.length ) {
			if ( sum == target ) return count+1;
			return count;
		}
		
		if ( sum > target ) {
			return count;
		}
		
		if ( sum == target ) {
			return count+1;
		}
		
		// include
		int leftCall = sumsToK3Count(arr, si + 1, sum + arr[si], target);
		count += leftCall;
		
		// exclude
		int rightCall = sumsToK3Count(arr, si + 1, sum, target);
		count += rightCall;
		
		return count;
	}
	
	private static boolean sumsToK2(int[] arr, int si, int sum, int target) {
		
		if ( si == arr.length ) {
			if ( sum == target ) return true;
			return false;
		}
		
		if ( sum > target ) {
			return false;
		}
		
		if ( sum == target ) {
			return true;
		}
		
		// include
		boolean leftCall = sumsToK2(arr, si + 1, sum + arr[si], target);
		if ( leftCall ) return true;
		
		// exclude
		boolean rightCall = sumsToK2(arr, si + 1, sum, target);
		if ( rightCall ) return true;
		
		return false;
	}

	private static int[][] sumsToK(int[] arr, int si, int sum) {

		if (sum < 0) {
			return new int[0][0];
		}

		if (si == arr.length) {

			if (sum == 0) {
				return new int[1][0];
			}

			return new int[0][0];
		}

		int[][] leftCall = sumsToK(arr, si + 1, sum - arr[si]);
		int[][] rightCall = sumsToK(arr, si + 1, sum);
		int[][] answer = new int[leftCall.length + rightCall.length][];

		int i = 0;

		for (int j = 0; j < leftCall.length; j++) {

			int k = 0;
			int[] temp = new int[1 + leftCall[j].length];
			temp[k] = arr[si];
			k++;

			for (int js : leftCall[j]) {
				temp[k] = js;
				k++;
			}

			answer[i] = temp;
			i++;
		}

		for (int j = 0; j < rightCall.length; j++) {
			answer[i] = rightCall[j];
			i++;
		}

		return answer;
	}

	// 2 steps only with dp memoisation
	public static long stairCaseBestDP(int r) {

		if (r == 1)
			return 1;

		long[] dp = new long[1 + r];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[r];

	}

	// can climb 3 stairs at once
	public static int stairCaseBest(int r) {

		if (r < 0) {
			return 0;
		}

		if (r == 0) {
			return 1;
		}

		return stairCaseBest(r - 1) + stairCaseBest(r - 2) + stairCaseBest(r - 3);
	}

	private static void printkeypadsubsequences(int i, Map<Integer, Character[]> keypad, String output) {

		if (i == 0) {
			System.out.println(output);
			return;
		}

		int lastDigit = i % 10;
		Character[] charArr = keypad.get(lastDigit);
		// choosing each char of last digit
		for (Character character : charArr) {
			printkeypadsubsequences(i / 10, keypad, output + character);
		}

	}

	private static void printsubsequences(String input, String output) {

		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		// excluding first character
		printsubsequences(input.substring(1), output);
		// including first character
		printsubsequences(input.substring(1), output + input.charAt(0));

	}
	
	private static String[] findkeypadSubSequences(String string, Map<Character, Character[]> keypad) {

		if (string.length() == 0) {
			return new String[] {""};
		}

//		int currentValue = i % 10;
//		int smallProblem = i / 10;
		char currentValue = string.charAt(0);
		String smallProblem = string.substring(1);
		Character[] currentCaracterValue = keypad.get(currentValue);

		// smaller problem call
		String[] smallAns = findkeypadSubSequences(smallProblem, keypad);

		// calculation
		String[] answer = new String[smallAns.length * currentCaracterValue.length];

		int t = 0;

		for (Character ch : currentCaracterValue) {

			for (int j = 0; j < smallAns.length; j++) {
				answer[t] = ch + smallAns[j];
				t++;
			}
		}

		return answer;
	}

	private static List<String> findkeypadSubSequencesReturnList(String string, Map<Character, Character[]> keypadChaMap) {

		// base case
		if (string.length() == 0) {
			List<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}

		char currentValue = string.charAt(0);
		String smallProblem = string.substring(1);
		Character[] currentCaracterValue = keypadChaMap.get(currentValue);

		// smaller problem call
		List<String> smallAns = findkeypadSubSequencesReturnList(smallProblem, keypadChaMap);

		// calculation
		List<String> answer = new ArrayList<String>();

		for (Character ch : currentCaracterValue) {
			for (int j = 0; j < smallAns.size(); j++) {
				answer.add(ch + smallAns.get(j));
			}
		}

		return answer;
	}

	private static String[] findkeypadSubSequences(int i, Map<Integer, Character[]> keypad) {

		// base case
		if (i == 0) {
			return new String[] { "" };
		}

		int currentValue = i % 10;
		int smallProblem = i / 10;
		Character[] currentCaracterValue = keypad.get(currentValue);

		// smaller problem call
		String[] smallAns = findkeypadSubSequences(smallProblem, keypad);

		// calculation
		String[] answer = new String[smallAns.length * currentCaracterValue.length];

		int t = 0;

//		for (int j = 0; j < smallAns.length; j++) {
//			answer[t] = smallAns[j];
//			t++;
//		}

		for (Character ch : currentCaracterValue) {

			for (int j = 0; j < smallAns.length; j++) {
				answer[t] = ch + smallAns[j];
				t++;
			}
		}

		return answer;
	}

	private static List<String> findSubSequencesReturnList(String str) {

		if (str.length() == 0) {
//			String[] ans = {""};
			List<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}

//		String[] smallAns = findSubSequences(str.substring(1));
//		String[] ans = new String[smallAns.length*2];

		List<String> smallAns = findSubSequencesReturnList(str.substring(1));
		List<String> ans = new ArrayList<String>();

		for (int i = 0; i < smallAns.size(); i++) {
			ans.add(smallAns.get(i));
		}

		for (int i = 0; i < smallAns.size(); i++) {
			ans.add(str.charAt(0) + smallAns.get(i));
		}

		return ans;

	}

	private static String[] findSubSequences(String str) {

		if (str.length() == 0) {
			String[] ans = { "" };
			return ans;
		}

		String[] smallAns = findSubSequences(str.substring(1));
		String[] ans = new String[smallAns.length * 2];
		int j = 0;

		for (int i = 0; i < smallAns.length; i++) {
			ans[j] = smallAns[i];
			j++;
		}

		for (int i = 0; i < smallAns.length; i++) {
			ans[j] = str.charAt(0) + smallAns[i];
			j++;
		}

		return ans;

	}

	public static boolean checkABBest(String str) {

		if (str.length() == 0) {
			return true;
		}

		if (str.charAt(0) == 'a') {

			if (str.substring(1).length() > 1 && str.substring(1, 3).equals("b")) {
				return checkABBest(str.substring(3));
			}

			else {
				return checkABBest(str.substring(1));
			}

		}

		return false;
	}

	public static boolean checkAB(String str, boolean first) {

		if (first && str.charAt(0) != 'a') {
			return false;
		}

		if (str.length() == 1 && str.equals("a")) {
			return true;
		} else if (str.length() == 1 && str.equals("b")) {
			return false;
		}

		if (str.length() == 2 && str.equals("bb")) {
			return true;
		} else if (str.length() == 2 && str.equals("ab") || str.length() == 2 && str.equals("aa")
				|| str.length() == 2 && str.equals("bb") || str.length() == 2 && str.equals("ba")) {
			return false;
		}

		boolean small = false;

		if (str.charAt(0) == 'b') {
			if (str.charAt(1) != 'b') {
				return false;
			} else {
				small = checkAB(str.substring(3), false);
			}
		} else {
			small = checkAB(str.substring(1), false);
		}

		if (small) {
			char nxtChar = str.substring(1).charAt(0);
			char strs = 'a';
			if (nxtChar == strs) {
				return false;
			}
			return small;
		}

		return small;
	}
	
	public static List<List<Integer>> subsets(int[] arr, int si) {
		
		if ( arr.length == si ) {
			List<List<Integer>> lstlst = new ArrayList<List<Integer>>();
			List<Integer> temp = new ArrayList<>();
			int[] nus = temp.stream().mapToInt(Integer::intValue).toArray();
			lstlst.add(temp);
			return lstlst;
		}

		List<List<Integer>> smallAns = subsets(arr, si + 1);
		
		System.out.println("smallAns : ");
		for (List<Integer> is : smallAns) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}
		
		List<List<Integer>> answer = new ArrayList<>();

		// adding current smaller answer
//		for (int j = 0; j < smallAns.size(); j++) {
//			answer.add(smallAns.get(j));
//		}
		
		answer.addAll(smallAns);

		// adding current first element with smaller answer
		for (int j = 0; j < smallAns.size(); j++) {

			List<Integer> temp = new ArrayList<>();
			temp.add(arr[si]);
			
			for (int js : smallAns.get(j)) {
				temp.add(js);
			}

			answer.add(temp);
		}

		return answer;
    }

	public static int[][] arraySubsequences(int[] arr, int si) {

		if (arr.length == si) {
			return new int[1][0];
		}

		int[][] smallAns = arraySubsequences(arr, si + 1);
		int[][] answer = new int[2 * smallAns.length][];

		int i = 0;

		for (int j = 0; j < smallAns.length; j++) {
			answer[i] = smallAns[j];
			i++;
		}

		for (int j = 0; j < smallAns.length; j++) {

			int k = 0;
			int[] temp = new int[1 + smallAns[j].length];
			temp[k] = arr[si];
			k++;
			for (int js : smallAns[j]) {
				temp[k] = js;
				k++;
			}

			answer[i] = temp;
			i++;
		}

		return answer;
	}

	private static void printSubsetOfArray(int[] arr, int si, int[] outputTillNow) {

		if (si == arr.length) {
			for (int i : outputTillNow) {
				System.out.print(i);
			}
			System.out.println();
			return;
		}

		int[] newOutput = new int[1 + outputTillNow.length];

		int j = 0;
		for (int i : outputTillNow) {
			newOutput[j] = i;
			j++;
		}

		newOutput[j] = arr[si];

		printSubsetOfArray(arr, si + 1, newOutput);
		printSubsetOfArray(arr, si + 1, outputTillNow);
	}

}
