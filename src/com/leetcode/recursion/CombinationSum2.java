package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = {2,1,2,7,6,1,5};
		int target = 8;
		
		CombinationSum2 cs = new CombinationSum2();
		List<List<Integer>> answer = cs.combinationSum2(candidates, target);
//		List<List<Integer>> answer = cs.combinationSum22(candidates, target);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
	}
	
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        for (int i : candidates) {
        	candidate.add(i);
		}
        
        // recursive function
        combination(candidate, arr, 0, answer, target);
        
        return answer;
    }


	private void combination(List<Integer> candidate, List<Integer> ans, int i, List<List<Integer>> answer, int target) {
		
		if ( target == 0 ) {
			answer.add(new ArrayList<>(ans));
			return;
		}
		
		if ( target < 0 || i == candidate.size() ) {
			return;
		}
		
//		System.out.println(candidate.get(i));
		
		
		
		// include
		ans.add(candidate.get(i));
		
		combination(candidate, ans, i + 1, answer, target - candidate.get(i));
		
		// Backtrack by removing the last added candidate
		ans.remove(ans.size() - 1);
		
		// exclude
		for (int j = i + 1; j < candidate.size(); j++) {
			if (candidate.get(j) != candidate.get(i)) {
				combination(candidate, ans, j, answer, target);
				break;
			}
		}
		
	}
	
	public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        
		List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        // Sort candidates to handle duplicates
        Arrays.sort(candidates);

        // Start the recursive process
        func(0, target, nums, candidates, ans);
        
        return ans;
    }
	
	private void func(int ind, int sum, List<Integer> nums, int[] candidates, List<List<Integer>> ans) {
		// If the sum is zero, add the current combination to the result
		if (sum == 0) {
			ans.add(new ArrayList<>(nums));
			return;
		}

		// If the sum is negative or we have exhausted the candidates, return
		if (sum < 0 || ind == candidates.length)
			return;

		// Include the current candidate
		nums.add(candidates[ind]);

		// Recursively call with updated sum and next index
		func(ind + 1, sum - candidates[ind], nums, candidates, ans);

		// Backtrack by removing the last added candidate
		nums.remove(nums.size() - 1);

		// Skip duplicates: if not picking the current candidate, 
		// ensure the next candidate is different
		for (int i = ind + 1; i < candidates.length; i++) {
			if (candidates[i] != candidates[ind]) {
				func(i, sum, nums, candidates, ans);
				break;
			}
		}
}

}
