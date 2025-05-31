package com.pepcoding.bitmanipulation;

public class BitManipulation {

	public static void main(String[] args) {
		
//		int i = 3;
//		int y = 4;
//		
//		System.out.println( i | y );
//		System.out.println( i & y );
//		System.out.println( i ^ y );
//		System.out.println( y & -y );
//		System.out.println( ~y );
//		System.out.println(Integer.toBinaryString( i ));
//		System.out.println(Integer.toBinaryString( y ));
		
		count1(10);
		
		

	}
	
	public static int count1(int n) {
		
		int count = 0;
		while (n > 0) {
		    n = n & (n - 1);
		    count += 1;
		}
		
		System.out.println("count : " + count);
		
		return 0;
	}

}
