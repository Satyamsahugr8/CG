package com.codingninjas.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPowerSets {

	public static void main(String[] args) {
		
		powerSet(); // subArray of array 
//		subsetsSums2();
		
	}
	
	public static void powerSet() {
		
		int[] nums = {1,2,3};
		List<List<Integer>> answer = powerSet(nums);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
	}
	
	public static List<List<Integer>> powerSet(int[] nums) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> ans = new ArrayList<Integer>();
        subsets(nums, 0, ans, answer);
        return answer;
        
    }

	private static void subsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> answer) {
		
		if ( i == nums.length )  {
			answer.add(new ArrayList<>(ans));
			return;
		}
		
		// include
		ans.add(nums[i]);
		subsets(nums, i + 1, ans, answer);
		
		// exclude
		ans.remove(ans.size() - 1);
		subsets(nums, i + 1, ans, answer);
		
	}


	
public static void subsetsSums2() {
		
		int[] nums = {1,2,2};
		List<List<Integer>> answer = subsetsSums2(nums);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
		
	}
	
	public static List<List<Integer>> subsetsSums2(int[] nums) {
        return subsets2(nums);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
		subsets2(nums, 0, ans, answer);
       
        return answer;
        
    }

	private static void subsets2(int[] nums, int i, List<Integer> ans, List<List<Integer>> answer) {
		
		if ( i == nums.length )  {
			answer.add(new ArrayList<>(ans));
			return;
		}
		
		// include
		ans.add(nums[i]);
		subsets2(nums, i + 1, ans, answer);
		
		// exclude
		ans.remove(ans.size() - 1);
		
		for( int j = i + 1; j < nums.length; j++ ) {
			
			// if ( j == nums.length ) {
			// 	answer.add(new ArrayList<>(ans));
			// 	return;
			// }
			
			if ( nums[j] != nums[i] ) {
				subsets2(nums, j, ans, answer);
				return;
			}
		}

        subsets2(nums, nums.length, ans, answer);
		
	}
}
