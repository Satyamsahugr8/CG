package com.codingninjas.dynamicprograming;

public class NoOfBalancedBT {

	public static void main(String[] args) {
		
		System.out.println(countBalancedBT(6));
		System.out.println(countBalancedBTM(6));
//		System.out.println(17%(int)Math.pow(10, 9) + 7);
		System.out.println(countBalancedBTDP(6));
		
	}
	
	
	// use mod of Math.pow(10, 9) * 7;
	static int countBalancedBT(int h) {
		return countBalancedBT(h, (int)Math.pow(10, 9) + 7);
	}
	
	static int countBalancedBT(int h, int mod) {
		
		if ( h == 0 || h == 1 ) {
			return 1;
		}
		
		int x = countBalancedBT(h-1, mod);
		int y = countBalancedBT(h-2, mod);
		
		long val1 = (long)x*x;
		long val2 = (long)2*x*y;

		int v = (int)(val1 % mod);
		int vv = (int)(val2 % mod);
		
		return (v + vv) % mod;
	}
	
	static int countBalancedBTM(int h) {
		
		int storage[] = new int[h+1];
		storage[0] = 1;
		storage[1] = 1;
		
		return countBalancedBTM(h, (int)Math.pow(10, 9) + 7, storage);
	}
	
	static int countBalancedBTM(int h, int mod, int[] storage) {
		
		if ( h == 0 || h == 1 ) {
			return storage[h];
		}
		
		if ( storage[h] != 0 ) {
			return storage[h];
		}
		
		int x = -1;
		if ( storage[h-1] == 0 ) {
			x = countBalancedBTM(h-1, mod, storage);
		}
		x = storage[h-1];
		
		int y = -1;
		if ( storage[h-2] == 0 ) {
			y = countBalancedBTM(h-2, mod, storage);
		}
		y = storage[h-2];
		
		long val1 = (long)x*x;
		long val2 = (long)2*x*y;

		int v = (int)(val1 % mod);
		int vv = (int)(val2 % mod);
		
		storage[h] = (v + vv) % mod;
		return storage[h];
	}

	//DP
	static int countBalancedBTDP(int h) {
		
		int storage[] = new int[h+1];
		
		if ( h == 0 ) return storage[0] = 1;
		if ( h == 1 ) return storage[1] = 1;
		
		storage[0] = 1;
		storage[1] = 1;
		
		return countBalancedBTDP(h, (int) Math.pow(10, 9) + 7, storage);
	}
	
	static int countBalancedBTDP(int h, int mod, int[] storage) {
		
		for (int i = 2; i <= h; i++) {
			
			int x = storage[i-1];
			int y = storage[i-2];
			
			long val1 = (long)x*x;
			long val2 = (long)2*x*y;

			int v = (int)(val1 % mod);
			int vv = (int)(val2 % mod);
			
			storage[i] = (v + vv) % mod;
		}

		return storage[h];
	}

}
