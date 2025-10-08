package com.leetcoder.pattern.stack;

import java.util.Stack;

/**
 * RemoveDigit.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 20-Sep-2025
 */
public class RemoveDigit {

	public static void main(String[] args) {

		RemoveDigit a = new RemoveDigit();

	}
	
	
public String removeKdigits(String nums, int k) {
        
        Stack<Character> st = new Stack<>();
        int n = nums.length();

        for( int i = 0; i < n; i++ ) {

            char digit = nums.charAt(i);
            
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            
            // adding every time we loop
            st.push(digit);
        }

        // If more digits can be removed
        while(!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";
        
        // create a string and reverse it
        StringBuilder res = new StringBuilder();
        
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        
        while(res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
    
        res.reverse();

        if(res.length() == 0) return "0";
        
        return res.toString();
    }
}
