package com.codingninjas.dynamicprograming;

public class FabonacciNumber {

	public static void main(String[] args) {
		
		
		System.out.println(fabDP(44));
		System.out.println(fabM(44));
		System.out.println(fab(44));
		
		
		
	}
	
	//1 normal 
	public static int fab(int n) {
		 if ( n == 0 || n == 1 ) {
			 return n;
		 }
		 
		 return fab(n-1) + fab(n-2);
	}
	
	//3 DP
	private static int fabDP(int n) {
		
		int[] storage = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
	
		for (int i = 2; i <= n; i++) {
			storage[i] = storage[i-1] + storage[i-2];
		}
		 
		 return storage[n];
	}

	
	
	//2 memoization
	public static int fabM(int n) {
		 
		int storage[] = new int[n+1];
		int j = 0;
		
		for (int i : storage) {
			storage[j] = -1;
			j++;
		}
		return fabM(n, storage);
	}

	private static int fabM(int n, int[] storage) {
		
		if ( n == 0 || n == 1 ) {
			storage[n] = n;
			return storage[n]; 
		 }
		
		if ( storage[n] != -1 ) {
			return storage[n];
		}
		
		 storage[n] = fabM(n-1, storage) + fabM(n-2, storage);
		 
		 return storage[n];
	}

	
}
