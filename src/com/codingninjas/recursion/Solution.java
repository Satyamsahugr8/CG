package com.codingninjas.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		int[] candidates = {2, 3, 5, 4};
		int target = 7;
		
		List<List<Integer>> answer = CombinationSum.combinationSum(candidates, target);
		
		for (List<Integer> is : answer) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}

		int s = minNum(4, 5, 1);
		System.out.println(s);
		
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(1);
		lst.add(4);
		lst.add(2);
		lst.add(3);
		
		System.out.println(getMinimumCost(lst));
	}

	public static int minNum(int samDaily, int kellyDaily, int difference) {
		// Write your code here
		int count = 0;

		if (samDaily >= kellyDaily) {
			return -1;
		}

		int samD = samDaily + difference;
		int kellyD = kellyDaily;
		count = count + 1;
		
		System.out.println(samD);
		System.out.println(kellyD);

		while (kellyDaily <= samDaily) {
			System.out.println("s");
			count = count + 1;
			samD = samD + samDaily;
			kellyD = kellyD + kellyDaily;
			if (kellyD > samD)
				break;
		}

		return count;

	}
	
	public static long getMinimumCost(List<Integer> arr) {
	    // Write your code here
	        Set<Integer> set = new HashSet<>();
	        List<Integer> answer = new ArrayList<>();
	        for( int i = 0; i < arr.size(); i++) {
	            set.add(arr.get(i));
	            answer.add(set.size());
	        }
	        
	        // for( int i = 0; i < arr.size(); i++) {
	        //     answer.add(set.size());
	        // }
	        
	        long sum = 0;
	        for (Integer integer : answer) {
	           sum += integer; 
	        }
	        return sum;
	    }

}
