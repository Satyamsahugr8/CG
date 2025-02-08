package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.HashSet;

public class BalancedParenthesis {

    public static void main(String[] args) {

        HashSet<String> arr = createBalancedParenthesis(1);
        for (String string : arr) {
            System.out.print(string + " ");
        }
    }

    private static HashSet<String> createBalancedParenthesis(int i) {
        
        if ( i < 0 ) {
            return null;
        }

        if ( i == 1 ) {
            HashSet<String> ans = new HashSet<>();
            ans.add("()");
            return ans;
        }

        HashSet<String> ans = new HashSet<>();
        HashSet<String> smallAns = createBalancedParenthesis(i - 1);
        String s = "()";

        for (String string : smallAns) {
            String str1 = string + s;
            String str2 = s + string;
            String str3 = s.charAt(0) + string + s.charAt(1);

            ans.add(str1);
            ans.add(str2);
            ans.add(str3);
        }
        
        return ans;
    }

}
