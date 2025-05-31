package com.tufplus.greedy;

import java.util.Arrays;

/**
 * ShortestJobFirst.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 29-May-2025
 */
public class ShortestJobFirst {

	public static void main(String[] args) {
		ShortestJobFirst instance = new ShortestJobFirst();
		System.out.println(instance);
		
		int bt[] = {1, 2, 3, 4};
		long u = instance.solve(bt);
		
		System.out.println(u);

	}
	
	// using greedy approach 
	public long solve(int[] bt) {
	      //your code goes here
	      int n = bt.length;
	      Arrays.sort(bt);
	      int time = 0;
	      int wt = 0;
	      
	      for (int i = 0; i < n - 1; i++) {
	    	  time += bt[i];
	    	  wt = (wt + time);
	          System.out.println(wt);
	      }

	      return wt/n;
	    }
	
	
}
