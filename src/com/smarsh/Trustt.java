package com.smarsh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Trustt.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 24-Sep-2025
 */
public class Trustt {

	public static void main(String[] args) {

		Trustt a = new Trustt();
		String[] arr = {"satyam", "mayank", "mukul", "satyam", "mayank"};
		String [] ans = a.uniqueString(arr);
		System.out.println("1");
		System.out.println(Arrays.toString(ans));
		
		System.out.println("2");
		int[] arri = {-2,1,3,4,5,-1,-2};
		int ansi = a.minimumSum(arri);
		System.out.println(ansi);
		
	}
	
	public int minimumSum(int[] arr) {
		
		int n = arr.length;
		int i = 0;
		int j = n-1;
		
		int sum = 0;
		
		while ( i < j ) {
			 
		}
		
		return 0;
	}
	
	public String[] uniqueString(String[] str) {
		
		Set<String> set = new LinkedHashSet<String>();
		
		for (String string : str) {
			set.add(string);
		}
		
		String[] ans = new String[set.size()];
		
		int i = 0;
		for (String string: set) {
			ans[i] = string;
			i++;
		}
		
		return ans;
	}
}
