package com.common;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] temp = new double[2];
		
		for (double d : temp) {
			System.out.println(d);
		}
		
		
		stringCon("2","3");
		
	}
	
	public static void stringCon(String s1, String s2){
		int result = Integer.valueOf(s1)+ Integer.valueOf(s2);
		System.out.println(String.valueOf(result));
	}
}
