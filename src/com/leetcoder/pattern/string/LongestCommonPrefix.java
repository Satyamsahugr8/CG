package com.leetcoder.pattern.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixBest(arr));
    }

    // naive approach
    static String longestCommonPrefix(String[] arr) {
        
        if (arr == null || arr.length == 0) return "";
        String prefix = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                
                System.out.println(i);
                System.out.println(arr[i]);
                System.out.println(prefix);

                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    static String longestCommonPrefixBest(String[] arr) {

        if (arr == null || arr.length == 0) return "";
        
        // sort array 
        Arrays.sort(arr);

        // now just we have to first and last how much they are same 
        String s1 = arr[0];
        String s2 = arr[arr.length - 1];

        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}