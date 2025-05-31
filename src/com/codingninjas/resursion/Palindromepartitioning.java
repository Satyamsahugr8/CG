package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.List;

public class Palindromepartitioning {

    public static void main(String[] args) {
        
        List<List<String>> answer = partition("abaa");
        for (List<String> list : answer) {
            System.out.println(list);
        }

    }

    public static List<List<String>> partition(String s) {
        //your code goes here
        List<List<String>> answer = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        partition(s, 0, ans, answer);
        return answer;
    }

    public static void partition(String s, int i, List<String> ans, List<List<String>> answer) {

        if ( i == s.length() ) {
            answer.add(new ArrayList<>(ans));
        }

        for (int j = i + 1; j <= s.length(); j++) {
            
            String curr = s.substring(i, j);
            if ( isPalindrome(curr) ) {
                ans.add(curr);
                partition(s, j, ans, answer);
                ans.remove(ans.size() - 1);
            }
            
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        // Compare characters while i < j
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;      
            }
            i++;
            j--;
        }
        return true;      
    }

}