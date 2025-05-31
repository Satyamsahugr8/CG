package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
//		combinationSum();
//		combinationSum2();
//		combinationSum3();
		
	}
	
	public static void combinationSum() {
		int[] candidates = {2,3,5,4};
		int target = 7;
		
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> answer = cs.combinationSum(candidates, target);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	       
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        
        for (int num : candidates) {
            v.add(num);
        }
        
        combinationSum(v, 0, target, new ArrayList<>(), ans);
        
        return ans;
    }

    public void combinationSum(List<Integer> v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        
        if ( sum == 0 ) {
            ans.add(new ArrayList<>(v2));
            return;
        }
        
        if ( sum < 0 || i == v.size() ) {
            return;
        }
        
        // Include 
        v2.add(v.get(i));
        combinationSum(v, i, sum - v.get(i), v2, ans);
        
        
        // Exclude the current element and move to the next
        v2.remove(v2.size() - 1);
        combinationSum(v, i + 1, sum, v2, ans);
    }
	
    
	
	public static void combinationSum2() {
		int[] candidates = {2,1,2,7,6,1,5};
		int target = 8;
		
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> answer = cs.combinationSum2(candidates, target);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
		
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        
//        Arrays.sort(candidates);
        
        for (int i : candidates) {
        	candidate.add(i);
		}
        
        Collections.sort(candidate);
        
        // recursive function
        combination2(candidate, arr, 0, answer, target);
        
        return answer;
    }

	private void combination2(List<Integer> candidate, List<Integer> ans, int i, List<List<Integer>> answer, int target) {
		
		if ( target == 0 ) {
			answer.add(new ArrayList<>(ans));
			return;
		}
		
		if ( target < 0 || i == candidate.size() ) {
			return;
		}
		
		// include
		ans.add(candidate.get(i));
		
		combination2(candidate, ans, i + 1, answer, target - candidate.get(i));
		
		// Backtrack by removing the last added candidate
		ans.remove(ans.size() - 1);
		
		// exclude
		for (int j = i + 1; j < candidate.size(); j++) {
			if (candidate.get(j) != candidate.get(i)) {
				combination2(candidate, ans, j, answer, target);
				break;
			}
		}
		
	}
	
	
	
	public static void combinationSum3() {
		
		int k = 3;
		int sum = 9;
		List<List<Integer>> answer = combinationSum3(k, sum);
		
		for (List<Integer> list : answer) {
			System.out.println(list);
		}
	}
	
	private static List<List<Integer>> combinationSum3(int k, int sum) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> ans = new ArrayList<Integer>();
		combinationSum3(sum, 1, ans, k, answer);
		return answer;
	}

	private static void combinationSum3(int sum, int j, List<Integer> nums, int k, List<List<Integer>> answer) {
        
        if ( sum == 0 && nums.size() == k ) {
            answer.add(new ArrayList<>(nums));
            return;
        }
        
        if ( sum <= 0 || nums.size() > k ) return;

        for (int i = j; i <= 9; i++) {
            
            if (i <= sum) {
                nums.add(i);
                combinationSum3(sum - i, i + 1, nums, k, answer);
                nums.remove(nums.size() - 1);
            } 
            
            else {
                break;
            }
    
        }
        
    }

	
}
