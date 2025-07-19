package com.leetcoder.pattern.stack;

import java.util.Arrays;

/**
 * NextGreaterElement.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 06-Jul-2025
 */
public class NextGreaterElement {

	public static void main(String[] args) {

		NextGreaterElement a = new NextGreaterElement();
		
		int n = 4;
		int[] arr = { 2, 10, 12, 1,11 };
		int[] ans = a.nextLargerElement(arr);

		System.out.println("The next greater elements are: ");
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public int[] nextLargerElement(int[] arr) {

		int n = arr.length; // size of array
        
        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
       
        for(int i = 0; i < n; i++) {
           
            // Get the current element
            int currEle = arr[i];
           
            /* Nested loop to get the 
            next greater element */
            for(int j = 1; j < n; j++) {
               
                // Getting the hypothetical index
            	// this is good
                int ind = (j + i) % n;
                
                System.out.println(" i : " + i + " j : " + j + " ind : " + ind );
               
                // If the next greater element is found
                if(arr[ind] > currEle) {
                   
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
