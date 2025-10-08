package com.codingninjas.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSum {

	public static void main(String[] args) {
		subsetsSums();

	}
	
	public static void subsetsSums() {
		
		int[] nums = {2,3};
		List<Integer> answer = subsetsSums(nums);
		
		for (Integer i : answer) {
			System.out.println(i);
		}
		
	}
	
	public static List<Integer> subsetsSums(int[] nums) {
		
		List<Integer> answer = new ArrayList<>();
		subsetsSums(nums, 0, 0, answer);
        return answer;
        
    }

	private static void subsetsSums(int[] nums, int i, int sum, List<Integer> answer) {
		
		if ( i == nums.length )  {
			answer.add(sum);
			return;
		}
		
		// exclude sum
		subsetsSums(nums, i + 1, sum, answer);
				
		// include sum
		subsetsSums(nums, i + 1, sum + nums[i], answer);
		answer.remove(answer.size() - 1);
		
		
	}

}
