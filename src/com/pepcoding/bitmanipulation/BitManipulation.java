package com.pepcoding.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class BitManipulation {

	public static void main(String[] args) {
		
		BitManipulation obj = new BitManipulation();
		
		int i = 3;
		int y = 4;
		
//		System.out.println( i | y );
//		System.out.println( i & y );
//		System.out.println( i ^ y );
//		System.out.println( y & -y );
//		System.out.println( ~y );
//		System.out.println(Integer.toBinaryString( i ));
//		System.out.println(Integer.toBinaryString( y ));
		
//		rightShift leftShift
		int x = 5;
//		System.out.println(x>>1); // 0101 -> 0010
//		System.out.println(x<<1); // 0101 -> 1010
		
		// rmsb x = x & -x; 
		// or x = x & (x-1);
		// 1101 -> 1100 -> 1000 -> 0000
		
		// bit masking ? 
		// masking means changes property of a particular object like 1 -> 0
		
		// count number of 1's in bit representation
		int a = count1(10);
		System.out.println("count : " + a);
		
		// find i'th bit is 0 or 1
		int b = findith(10, 3);
		System.out.println("findith : " + b);
		
		// set i'th bit = 0 -> 1
		int c = setith(10, 2); // 1010 -> 1110
		System.out.println("setith : " + c); // 14
		
		// clear i'th bit = 1 -> 0
		int d = clearith(15, 3); // 1010 -> 0010
		System.out.println("clearith : " + d);
		
		// find number of bits to changes to create a -> b
		int e = changeaTob(10, 7);
		System.out.println("changeaTob : " + e);
		
		// Input: nums = [1,2,1,3,2]
		// Output: 3
//		int[] arr1 = {1,2,3,1,2};
//		int ans = obj.singleNumber(arr1);
//		System.out.println(ans);
		
		// Input: nums = [1,2,1,3,2,5]
		// Output: [3,5]
//		int[] arr2 = {1,2,1,3,2,5};
//		int[] res = obj.singleNumberII(arr2);
//		
//		for (int j : res) {
//			System.out.print(j+" ");
//		}
//		System.out.println();
		
		// Input: nums = [1,2,1,5,2,1,2]
		// Output: 5
//		int[] arr3 = {1,2,1,5,2,1,2,4,5,4,6,4,3,4,3};
//		int k = 1;
//		int asn1 = obj.singleNumberIIIHashing(arr3, k);
//		System.out.println(asn1);
		
		// Input: nums = [1,2,1,5,2,1,2]
		// Output: 5
//		int[] arr4 = {1,2,1,5,2,1,2};
//		int asn = obj.singleNumberIII(arr4);
//		System.out.println(asn);

		// Input: nums = [1,2,1,5,2,1,2]
		// Output: 5
		int[] arr5 = {1,2,1,5,2,1,2};
		int asn2 = obj.singleNumberIIIArray(arr5, 3);
		System.out.println("Single Number II : " + asn2);

	}
	
	private int singleNumberIIIArray(int[] arr, int k) {
		
		int n = arr.length;
		int [] count = new int[32];
		
		for (int i = 0; i < 32; i++)
            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) != 0)
                	count[i] += 1;
		
//		System.out.println(Arrays.toString(count));
		
		int res = 0;
        for (int i = 0; i < 32; i++) {
            res += ((count[i] % k) * Math.pow(2, i));
        }
		return res;
	}
	
	// using hashing brute force
	private int singleNumberIIIHashing(int[] arr, int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
//			if ( !map.containsKey(arr[i]) ) {
//				map.put(arr[i], 1);
//			} else {
//				map.put( arr[i] , map.get(arr[i]) + 1 );
//			}
			
			map.put(arr[i], (map.getOrDefault(arr[i], 0)) + 1);
			
			
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet() ) {
            
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
//			if (entry.getValue() != k ) {
//                return entry.getKey();
//			}
			
//			System.out.println(entry.getKey() + " : " +entry.getValue());
        }
		
		return -1;
	}
	
	public static int findUniqueElement(int[] arr, int k) {
        
		Map<Integer, Integer> map = new HashMap<>();
        
		for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
		
        for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
            if (entry.getValue() != k) {
                return entry.getKey();
            }
        }
        
        return -1; // or any suitable default value to indicate no unique element found
    }
	
	private int singleNumberIII(int[] arr4) {
		int ones = 0;
		int twos = 0;
		for (int i = 0; i < arr4.length; i++) {
			// Add the number to Ones, if it is not in Twos
			ones = (ones ^ arr4[i]) & ~twos;
            // Add the number to Twos, if it is already in Ones
            twos = (twos ^ arr4[i]) & ~ones;
		}
		return ones;
	}

	private int singleNumber(int[] arr1) {
		
		int ans = 0;
		for (int i = 0; i < arr1.length; i++) {
			ans ^= arr1[i];
		}
		return ans;
	}

	@SuppressWarnings("unused")
	public int[] singleNumberII(int[] nums) {
        
		int n = nums.length;
        int a = 0;
        int b = 0;
        int res = 0;
        
        for ( int i = 0; i < n; i++ ) {
            res ^= nums[i];
        }
        
        int rightmost = (int)(res & (res - 1)) ^ (int)res;
        
        for ( int i = 0; i < n; i++ ) {
            
            if ( (nums[i] & rightmost) != 0 ) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        
        int[] answer = {a, (res^a)};
        return answer;
    }
	
	private static int changeaTob(int i, int j) {
		int a = i^j;
		int ans = count1(a);
		return ans;
	}

	private static int clearith(int i, int j) {
		
		int one = 1;
		// move one right-shift index
		one = one << j;
		
		// 1st
//		return one ^ i;
		
		// 2nd
		one = ~one;
		return one & i;
	}

	private static int setith(int i, int j) {
		
		int one = 1;
		// move one right-shift index
		one = one << j;
		
		return one | i;
	}

	private static int findith(int i, int index) {
		
		int one = 1;
		// move one right-shift index
		one = one << index;
		
		if ( (i & one) == one ) {
			return 1;
		}
		
		return 0;
	}
	
	public static int count1(int n) {
		
		int count = 0;
		while (n > 0) {
		    n = n & (n - 1);
		    count += 1;
		}
		
		return count;
	}

}
