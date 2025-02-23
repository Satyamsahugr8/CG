package com.codingninjas.array;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> curr = new ArrayList<Integer>();
		curr.add(1);
		curr.add(3);
		
		ArrayList<Integer> curr1 = new ArrayList<Integer>();
		curr1.add(5);
		curr1.add(7);
		
		ArrayList<Integer> curr2 = new ArrayList<Integer>();
		curr2.add(8);
		curr2.add(12);
		
		ans.add(curr);
		ans.add(curr1);
		ans.add(curr2);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
		}
		
		ArrayList<Integer> add = new ArrayList<Integer>();
		add.add(0);
		add.add(13);
		
		for (int i = 0; i < 1; i++) {
			System.out.println(add.get(0) + " " + add.get(1));
		}
		
		ArrayList<ArrayList<Integer>> as = insertInterval(ans, add);
		
		for (int i = 0; i < as.size(); i++) {
			System.out.println(as.get(i).get(0) + " " + as.get(i).get(1));
		}
		
	}
	
	
	public static ArrayList<ArrayList<Integer>> insertInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval){
        // Write your code here.
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> curr = new ArrayList<Integer>();
		
		if ( intervals.get(0).get(0) > newInterval.get(0) && 
				intervals.get(intervals.size() - 1).get(1) < newInterval.get(1)) {
			ans.add(newInterval);
			return ans;
		}
		
		else if ( intervals.get(0).get(0) < newInterval.get(1) ) {
			ans.add(newInterval);
		}
		
		return intervals;
    }
}
