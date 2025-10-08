package com.tufplus.stackqueue.monotonic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * MonotonicStackImplementation.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 19-Jul-2025
 */
public class MonotonicStackImplementation {

	public static void main(String[] args) {

		MonotonicStackImplementation a = new MonotonicStackImplementation();
//		int[] arr = {6, 8, 0, 1, 3};
//		int [] ans = a.nextLargerElement(arr);
//		
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
		
		
		int[] arr = {10,20,-10};
		int [] ans = a.asteroidCollision(arr);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public int[] nextLargerElement(int[] arr) {
		
		int n = arr.length;
		int [] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
			
        	while ( !stack.isEmpty() ) {
        		
        		if ( arr[i] < stack.peek() ) {
        			answer[i] = stack.peek();
        			stack.add(arr[i]);
        			break;
        		}
        		else {
        			stack.pop();
        		}
        	} 
        	
        	if (stack.isEmpty()) {
        		answer[i] = -1;
        		stack.add(arr[i]);
        	}
        	
        	
		}
		
		return answer;
	}
	
	
	public int[] asteroidCollision(int[] asteroids) {
		
		int n = asteroids.length;
	    Stack<Integer> stack = new Stack<>();

	    for (int i = n - 1; i >= 0; i--) {
	        int curr = asteroids[i];
	        boolean destroyed = false;

	        while (!stack.isEmpty() && curr > 0 && stack.peek() < 0) {
	            if (Math.abs(curr) > Math.abs(stack.peek())) {
	                stack.pop(); // top destroyed, keep checking
	                continue;
	            } else if (Math.abs(curr) == Math.abs(stack.peek())) {
	                stack.pop(); // both destroyed
	            }
	            destroyed = true; // curr destroyed
	            break;
	        }

	        if (!destroyed) {
	            stack.push(curr);
	        }
	    }

	    // Convert stack to array (need to reverse, since we went backwards)
	    int[] answer = new int[stack.size()];
	    for (int i = stack.size() - 1; i >= 0; i--) {
	        answer[i] = stack.pop();
	    }
	    
	    reverseArray(answer);
	    
	    return answer;
    }
	
	public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move pointers
            start++;
            end--;
        }
    }
	
}
