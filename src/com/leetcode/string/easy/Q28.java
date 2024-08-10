package com.leetcode.string.easy;

public class Q28 {
    public static int strStr(String haystack, String needle) {
        int i=0,j=0,s=-1;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == needle.length()-1) {
                    i--;
                } else {
                    i++;
                    j = 0;
                }
            }
        }
        if (j==needle.length()) {
            s = i-needle.length();
        }
        return s;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int a = strStr(haystack, needle);
        System.out.println("a = " + a);
    }
}
