package com.codingninjas.resursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class GenerateBalancedParenthesis {
	
	

    public static void main(String[] args) {
    	
    	int n = 3;
    	ArrayList<String> ans = createBalancedParenthesis(n);
    	for (String integer : ans) {
			System.out.println(integer);
		}
    	
    	System.out.println();
    	
    	ArrayList<String> answer = new ArrayList<String>();
    	createBalancedParenthesisUsingTree(3, 0, 0, "", answer);
    	for (String integer : answer) {
			System.out.println(integer);
		}
    }
    
    //using tree "" choose "(" and ")"
    private static void createBalancedParenthesisUsingTree(int i, int open, int close, String str, ArrayList<String> answer) {
    	
    	if ( str.length() == 2*i ) {
    		answer.add(str);
    		return;
    	}
    	
    	if ( open < i ) {
        	str += "(";
        	createBalancedParenthesisUsingTree(i, open+1, close, str, answer);
        	str = str.substring(0, str.length() - 1);
        }
        
        if ( close < open ) {
        	str += ")";
        	createBalancedParenthesisUsingTree(i, open, close+1, str, answer);
        	str = str.substring(0, str.length() - 1);
        } 
        
    }
    
    
    private static ArrayList<String> createBalancedParenthesis(int i) {
    	
    	HashSet<String> arr = createBalancedParenthesis2(i);
//    	ArrayList<Integer> ans = new ArrayList<>(arr);
    	ArrayList<String> aee = (ArrayList<String>)arr.stream().collect(Collectors.toList());
        return aee;
    }

    private static HashSet<String> createBalancedParenthesis2(int i) {
        
        if ( i < 0 ) {
            return null;
        }

        if ( i == 1 ) {
            HashSet<String> ans = new HashSet<>();
            ans.add("()");
            return ans;
        }

        HashSet<String> ans = new HashSet<>();
        HashSet<String> smallAns = createBalancedParenthesis2(i - 1);
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
