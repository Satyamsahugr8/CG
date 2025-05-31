package com.codingninjas.stack;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] a = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
		int[] ans = nextGreaterElements(a);
		
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] nextLargerElement(int[] arr) {
        
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			
			// check if stack is empty push it
			while ( !stack.isEmpty() ) {
					
					if ( stack.peek() > arr[i] ) {
						int temp = arr[i];
						arr[i] = stack.peek();
						stack.add(temp);
						break;
					}
                    
					else {
                        stack.pop();
                    }
					
				}
				
				if ( stack.isEmpty() ) {
					stack.add(arr[i]);
					arr[i] = -1;
				}
				
		}
		
		return arr;
    }

	public static int[] nextGreaterElements(int[] arr) {
        
        int[] arr2 = new int[arr.length * 2];
        
        int j = 0;
        
        for (int i = 0; i < arr2.length; i++, j++) {
			
        	if ( j == arr.length ) {
				j = 0;
			}
        	
        	arr2[i] = arr[j];
				
		}
        
        arr2 = nextLargerElement(arr2);
        
        arr2[arr.length - 1] = -1;
        
        for (int i = 0; i < arr.length; i++) {
			arr[i] = arr2[i];
		}
        
		return arr;

    }

}
