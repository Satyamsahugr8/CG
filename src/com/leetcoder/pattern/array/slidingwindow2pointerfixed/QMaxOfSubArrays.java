package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * QMaxOfSubArrays.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 05-Oct-2025
 */
public class QMaxOfSubArrays {

	public static void main(String[] args) {
		
		int[] arr = {1,-1};
		int k = 1;
		int i = 0;
		int j = 0;
		int n = arr.length;

		Deque<Integer> queue = new LinkedList<>(); 
		List<Integer> ans = new ArrayList<Integer>();
		
		while ( j < n ) {
			

			// remove all smaller from first 
			while (!queue.isEmpty() && queue.peekLast() < arr[j]) {
		        queue.pollLast();
		    }
			
			queue.offerLast(arr[j]);
			
			if ( (j - i + 1) < k ) {
				j++;
			}
			
			else if ( (j - i + 1) == k) {
				
				ans.add(queue.peekFirst()); // front is max
				
				if ( arr[i] == queue.peekFirst()) {
					queue.pollFirst();
				}
				
				i++;
				j++;
			}
		}
		
		System.out.println("ans : " + ans);
		
	}
}
