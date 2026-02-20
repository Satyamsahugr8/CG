package com.leetcoder.pattern.string;

import java.util.Stack;

public class KarpRabin {
    

    public static void main(String[] args) {
        
        // String s = "satyam";
        // System.out.println(s.hashCode());

        // String aa = "sahu satyam mayank";

        // String [] srr = aa.split("\\s+");

        // for (String string : srr) {
            
        //     if ( string.length() == s.length() ) {
        //         if ( string.hashCode() == s.hashCode() ) {
        //             System.out.println("Found");
        //         }
        //     }

        //     else {
        //         continue;
        //     }
        // }


        String asns = decodeString("3[a]2[bc]");
        System.out.println(asns);
    }



    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0; // Current number count

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number k
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 1. Push current count k and current string
                countStack.push(k);
                stringStack.push(currentString);
                
                // 2. Reset for the inner string
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // Pop the previous state
                int repeatCount = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Append currentString (the inner decoded content) repeatCount times
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                
                // The result becomes the new currentString for the outer scope
                currentString = decodedString;
            } else {
                // Must be a letter: append to currentString
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
    // Time Complexity (Optimal): O(max\_k * n), where n is the length of the string and max\_k is the max repeat value.̵


}
