package com.leetcoder.pattern.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NextGreaterAndSmaller.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 20-Sep-2025
 */
public class NextGreaterAndSmaller {

	public static void main(String[] args) {

		int [] arr = {120, 100, 60, 80, 90, 110, 115};
		int [] ngl = nextLargerElementLeftBest(arr);
		int [] ans = new int[arr.length];
		
		for (int i = 0; i < ngl.length; i++) {
			ans[i] = i - ngl[i];
		}
		
		System.out.println(Arrays.toString(ans));
		
	}
	
	
	public int largestRectangleArea(int[] heights) {

	    NextGreaterAndSmaller a = new NextGreaterAndSmaller();

	    int[] nsl = a.nextSmallestElementLeftBest(heights);
	    int[] nsr = a.nextSmallestElementRightBest(heights);

	    int n = heights.length;
	    int max = 0;

	    for (int i = 0; i < n; i++) {
	      int width = nsr[i] - nsl[i] - 1;
	      int area = heights[i] * width;
	      max = Math.max(max, area);
	    }

	    return max;
	  }

	  public static int[] nextSmallestElementRightBest(int[] arr) {
	    int n = arr.length;
	    int[] answer = new int[n];
	    Stack<Integer> stack = new Stack<>(); // stores indices

	    for (int i = n - 1; i >= 0; i--) {
	      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
	        stack.pop();
	      }
	      answer[i] = stack.isEmpty() ? n : stack.peek();
	      stack.push(i);
	    }
	    return answer;
	  }

	  public static int[] nextSmallestElementLeftBest(int[] arr) {
	    int n = arr.length;
	    int[] answer = new int[n];
	    Stack<Integer> stack = new Stack<>();

	    for (int i = 0; i < n; i++) {
	      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
	        stack.pop();
	      }
	      answer[i] = stack.isEmpty() ? -1 : stack.peek();
	      stack.push(i);
	    }
	    return answer;
	  }

	  public static int[] nextLargerElementRightBest(int[] arr) {
	    int n = arr.length;
	    int[] answer = new int[n];
	    Stack<Integer> stack = new Stack<>();

	    for (int i = n - 1; i >= 0; i--) {
	      while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
	        stack.pop();
	      }
	      answer[i] = stack.isEmpty() ? n : stack.peek();
	      stack.push(i);
	    }
	    return answer;
	  }

	  public static int[] nextLargerElementLeftBest(int[] arr) {
	    int n = arr.length;
	    int[] answer = new int[n];
	    Stack<Integer> stack = new Stack<>();

	    for (int i = 0; i < n; i++) {
	      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
	        stack.pop();
	      }
	      answer[i] = stack.isEmpty() ? -1 : stack.peek();
	      stack.push(i);
	    }
	    return answer;
	  }
	  
}
