package com.coderbyte;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 21-Sep-2025
 */
public class Main {

	public static void main(String[] args) {

		Main a = new Main();
		String [] ar = new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
		String as = FindIntersection(ar);
		
		System.out.println(as);

	}
	
	public static String FindIntersection(String[] strArr) {
	    // code goes here
	    String arr[] = strArr[0].split(",\\s*"); //"1, 3, 4, 7, 13"
	    String brr[] = strArr[1].split(",\\s*"); //"1, 2, 4, 13, 15"
	    ArrayList<String> al = new ArrayList<>(); 
	    
	    System.out.println(Arrays.toString(arr));
	    System.out.println(Arrays.toString(brr));
	    
	    int i = 0;
	    int j = 0;
	    
	    while ( i < arr.length && j < brr.length ) {
	    	
	    	if ( Integer.parseInt(arr[i]) == Integer.parseInt(brr[j] ) ) {
	    		al.add(arr[i]);
	    		i++;
	    		j++;
	    	}
	    	
	    	else if ( Integer.parseInt(arr[i]) < Integer.parseInt(brr[j] ) ) {
	    		i++;
	    	}
	    	
	    	else {
	    		j++;
	    	}
	    }
	    
	    System.out.println(al);
	    return al.toString();
	  }
}
