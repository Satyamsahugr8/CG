package com.tufplus.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		
//		int[] arr = {-3, 4, 5, 1, -4, -5}; 
//		int[] re = leaders(arr);
		
//		int[] arr2 = {1,-1,-3,-4,2,3};
//		int[] re = rearrangeArray(arr2);
		
		
		int[] arr3 = {1,2,3,4}; 
		reverseArray(arr3);
//		int[] re = 
		for (int i : arr3) {
			System.out.print(i + " ");
		}

	}
	
	public static int[] leaders(int[] nums) {
		
		int n = nums.length;
		
		Set<Integer> indexList = new TreeSet<>();
		
		for ( int i = 0; i < n; i++ ) {
			
			boolean leader = true;
			
			for ( int j = i + 1 ; j < n; j++) {

				if ( nums[i] < nums[j]) {
					leader = false;
					break;
				}
			}
			
			if ( leader == true ) {
				indexList.add(i);
			}
			
		}

		int x = 0;
		int[] newArray = new int[indexList.size()];
		for (int k : indexList) {
			newArray[x] = nums[k];
			x++;
		}

		return newArray;

    }
	

	public static int[] optimalLeaders(int[] nums) {
		
		int n = nums.length;
		int maxRight = Integer.MIN_VALUE;
		
		List<Integer> list = new ArrayList<>();
		
		for ( int i = n-1 ; i >= 0; i-- ) {
			
			if ( nums[i] > maxRight ) {
				list.add(nums[i]);
				maxRight = nums[i];
			}
	
		}

		int x = 0;
		int[] newArray = new int[list.size()];
		for (int k : list) {
			newArray[x] = k;
			x++;
		}
		
		for (int i = 0; i < newArray.length / 2; i++) {
            int temp = newArray[i];
            newArray[i] = newArray[newArray.length - 1 - i];
            newArray[newArray.length - 1 - i] = temp;
        }
		
		return newArray;

    }

	
	public static void sortZeroOneTwo(int[] nums) {
		
    }

	
	public static int[] rearrangeArray(int[] nums) {
		
		// [1,-1,-3,-4,2,3]
		int n = nums.length;
		for (int i = 0; i < nums.length-1; i++) {
			
			// even index -> negative value
			if ( i%2 == 0 && nums[i] < 0 ) {
					
					int temp = nums[i];
					int j = i+1;
					
					while ( j < n ) {
						
						if ( nums[j] > 0 ) {
							nums[i] = nums[j];
							nums[j] = temp;
							break;
						}
						
						j++;
					}
						
			}
			
			// odd index / negative
			else if ( i%2 != 0 ) {
				
				int temp = nums[i];
				int j = i+1;
				
				while ( j < n ) {
					
					if ( nums[j] < 0 ) {
						nums[i] = nums[j];
						nums[j] = temp;
					}
					
					j++;
				}
					
			}
			
		}
		
        return nums;
    }

	
	// {};
	public static void reverseArray ( int[] arr ) {
		
		int i = 0;
		int n = arr.length-1;
		
		while ( i<n ) {
			
			int temp = arr[i];
			arr[i] = arr[n];
			arr[n] = temp;
			
			i++;
			n--;
		}
        
    } 

	
	
}
