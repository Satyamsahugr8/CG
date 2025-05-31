package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

	public static void main(String[] args) {
		powerSet();
	}
	
	public static void powerSet() {
		
		int[] nums = {4, 9, 2, 5, 1};
		int sum = 10;
		List<List<Integer>> answer = powerSet(nums, sum);
		int count = 0;
		
		for (List<Integer> list : answer) {
			count++;
			System.out.println(list);
		}
		
		System.out.println(count);
	}

	public static List<List<Integer>> powerSet(int[] nums, int sum) {

		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> ans = new ArrayList<Integer>();
		subsets(nums, 0, sum, ans, answer);

		return answer;
	}

	private static void subsets(int[] nums, int i, int sum, List<Integer> ans, List<List<Integer>> answer) {
		
		if ( sum == 0 ) {
			answer.add(new ArrayList<>(ans));
			return;
		}
		
		if ( sum < 0 ) {
			return;
		}
		
		if (i == nums.length) {
			return;
		}

		// include
		ans.add(nums[i]);
		subsets(nums, i + 1, sum - nums[i], ans, answer);

		// exclude
		ans.remove(ans.size() - 1);
		subsets(nums, i + 1, sum, ans, answer);

	}

}
