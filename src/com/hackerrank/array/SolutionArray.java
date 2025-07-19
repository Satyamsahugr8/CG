package com.hackerrank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 10-Jun-2025
 */
public class SolutionArray {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		SolutionArray a = new SolutionArray();
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 5, 3));
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(Arrays.asList(4, 8, 7));
		List<Integer> list3 = new ArrayList<Integer>();
		list3.addAll(Arrays.asList(6, 9, 1));

		queries.add(list);
		queries.add(list2);
		queries.add(list3);

		long answer = arrayManipulation(10, queries);
		System.out.println("answer : " + answer);

	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		// Write your code here
		long[] arr = new long[n + 1];
		long max = Long.MIN_VALUE;

		// read queries
		for (int i = 0; i < queries.size(); i++) {
			int a = queries.get(i).get(0);
			int b = queries.get(i).get(1);
			int k = queries.get(i).get(2);

			// modify arr with range a & b & k
			manipulateArray(arr, a, b, k, max);

		}
		
		max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			
			max = Math.max(max, max + arr[i]);
//			System.out.println(max);
//			System.out.print(arr[i] + " ");
		}

		return max;
	}

	private static void manipulateArray(long[] arr, int a, int b, int k, long max) {

		long temp = arr[a - 1];
		arr[a -1] = temp + k;
		long temp2 = arr[b - 1 + 1];
		arr[b - 1 + 1 ] = temp2 - k;
		
	}

}
