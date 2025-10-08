package com.leetcoder.pattern.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMins(nums);
    }

    // public int sumSubarrayMaxs(int[] arr) {

    // }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {1, 2, 3};
		long ans = s.sumSubarrayMins(arr);
		System.out.println(ans);
	}

    public long sumSubarrayMins(int[] arr) {
        
        NextGreaterElement n = new NextGreaterElement();
		
		int [] minR = n.nextSmallestElementRightBest(arr);
		int [] minL = n.nextSmallestElementLeftBest(arr);

        int [] maxR = n.nextLargerElementRightBest(arr);
		int [] maxL = n.nextLargerElementLeftBest(arr);
		
		System.out.println(Arrays.toString(minR));
		System.out.println(Arrays.toString(minL));
		System.out.println(Arrays.toString(maxR));
		System.out.println(Arrays.toString(maxL));
		
		int mod = (int)1e9 + 7; // Mod value
        
        // To store the sum
        long sum = 0;
        long summ = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			int left = i - minL[i];
            int leftt = i - maxL[i];
			int right = minR[i] - i;
            int rightt = maxR[i] - i;
			
			long freq = left * right * 1L;
            long freqq = leftt * rightt * 1L;
            
            // Contribution due to current element 
            long val = ((freq * arr[i]) % mod);
            long vall = ((freqq * arr[i]) % mod);
            
            // Updating the sum
            sum = (sum + val) % mod;
            summ = (summ + vall) % mod;
		}

		return summ - sum;
    }
}

/**
 * NextGreaterElement.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 06-Jul-2025
 */
class NextGreaterElemente {

//	public static void main(String[] args) {
//
//		NextGreaterElement a = new NextGreaterElement();
//
////		int n = arr;
//		int[] arr = { 2, 10, 12, 1, 11 };
////		int[] ans = a.nextLargerElement(arr);
//		int[] ans = a.nextSmallestElementRightBest(arr);
//
//		System.out.println("The next greater elements are: ");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(ans[i] + " ");
//		}
//	}

	// use Stack
	public int[] nextLargerElementRightBest(int[] arr) {

		int n = arr.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stacki = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (arr[i] < stack.peek()) {
					answer[i] = stacki.peek();
					stack.add(arr[i]);
					stacki.add(i);
					break;
				} else {
					stack.pop();
					stacki.pop();
				}
			}
			// check for lefted last one
			if (stack.isEmpty()) {
				answer[i] = n;
				stack.add(arr[i]);
				stacki.add(i);
			}
		}

		return answer;
	}

	public int[] nextLargerElementLeftBest(int[] arr) {

		int n = arr.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stacki = new Stack<>();

		for (int i = 0; i <= arr.length - 1; i++) {
			while (!stack.isEmpty()) {
				if (arr[i] < stack.peek()) {
					answer[i] = stacki.peek();
					stack.add(arr[i]);
					stacki.add(i);
					break;
				} else {
					stack.pop();
					stacki.pop();
				}
			}
			// check for lefted last one
			if (stack.isEmpty()) {
				answer[i] = -1;
				stack.add(arr[i]);
				stacki.add(i);
			}
		}

		return answer;
	}

	public int[] nextSmallesrElementRightBest(int[] arr) {

		int n = arr.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stacki = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (arr[i] >= stack.peek()) {
					answer[i] = stacki.peek();
					stack.add(arr[i]);
					stacki.add(i);
					break;
				} else {
					stack.pop();
					stacki.pop();
				}
			}
			// check for lefted last one
			if (stack.isEmpty()) {
				answer[i] = n;
				stack.add(arr[i]);
				stacki.add(i);
			}
		}

		return answer;
	}

	public int[] nextSmallestElementLeftBest(int[] arr) {

		int n = arr.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stacki = new Stack<>();

		for (int i = 0; i <= arr.length - 1; i++) {
			while (!stack.isEmpty()) {
				if (arr[i] > stack.peek()) {
					answer[i] = stacki.peek();
					stack.add(arr[i]);
					stacki.add(i);
					break;
				} else {
					stack.pop();
					stacki.pop();
				}
			}
			// check for lefted last one
			if (stack.isEmpty()) {
				answer[i] = -1;
				stack.add(arr[i]);
				stacki.add(i);
			}
		}

		return answer;
	}

	// use 2 for loop time n^2
	public int[] nextLargerElement(int[] arr) {

		int n = arr.length; // size of array

		// To store the next greater elements
		int[] ans = new int[n];
		Arrays.fill(ans, -1);

		for (int i = 0; i < n; i++) {

			// Get the current element
			int currEle = arr[i];

			/*
			 * Nested loop to get the next greater element
			 */
			for (int j = 1; j < n; j++) {

				// Getting the hypothetical index
				// this is good
				int ind = (j + i) % n;

				System.out.println(" i : " + i + " j : " + j + " ind : " + ind);

				// If the next greater element is found
				if (arr[ind] > currEle) {

					// Store the next greater element
					ans[i] = arr[ind];

					// Break from the loop
					break;
				}
			}
		}

		// Return the answer
		return ans;
	}

}