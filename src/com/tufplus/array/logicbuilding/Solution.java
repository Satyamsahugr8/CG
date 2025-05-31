package com.tufplus.array.logicbuilding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
//		int[] nums = {1, 3, 6, 4, 2, 5};
//		int missNum = missingNumber(nums);
//		System.out.println(missNum);
		
//		int[] nums = {1, 0, 6, 4, 0, 5};
//		int[] nums = {0, 0, 0, 0, 0,0 };
//		moveZeroes(nums); 
//		moveZeroesBetterOptimal(nums);
//		for (int i : nums) {
//			System.out.println(i);
//		}
		
//		//3rd
//		int[] arr1 = {1, 2, 2, 3, 5};
//		int[] arr2 = {1, 2, 7};
//		
//		int[] a = unionArray(arr1, arr2);
//		int[] b = intersectionArray(arr1, arr2);
//		for (int r : b) {
//			System.out.print(r + " ");
//		}
		
		int[] arr = {0,0,3,3,5,6};
		int v = removeDuplicates(arr);
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		System.out.println(v);
	}
	
	// remove duplicate from given array 
	// brute force approach
	// use set data structure for unique values
	
	// 2 use one iteration for eliminating duplicate with 2 pointers
	public static int removeDuplicates(int[] nums) {
		
		int j = 0;
		int count = 1;
		
		for (int i = 0; i < nums.length; i++) {
			
			
			
			while ( j < nums.length && nums[i] == nums[j] ) {
				j++;
			}
			
			if ( j < nums.length ) {
				count++;
				nums[i+1] = nums[j];
				j++;
			}
			
		}
		
        return count;
    }
	
	// optimal approach 
	public static int missingNumber(int[] nums) {
        
		int N = nums.length;
        int mainSum = N * (1 + N) / 2;
        int sum = 0;
        
        for (int i : nums) {
			sum += i; 
		}

        return mainSum - sum;
    }

	// basic brute force approach 
	// 1. create a new array store all non zero
	// 2. at last rest fill all as zeros
	public static void moveZeroes(int[] nums) {
        
		int j = 0;
		int[] valueArray = new int[nums.length];
		
		for (int i : nums) {
			if ( i != 0 ) {
				valueArray[j] = i;
				j++;
			}
		}
		
		while ( j < nums.length) {
			valueArray[j] = 0;
			j++;
		}
		
		
		for (int i : valueArray) {
			System.out.println(i);
		}
		
    }
	
	// optimal or better approach is to use 2 pointer methodology
	public static void moveZeroesBetterOptimal(int[] nums) {
		
		for ( int i = 0; i < nums.length; i++ ) {
			
			if ( nums[i] == 0 ) {
				int j = i + 1;
				while ( j < nums.length && nums[j] == 0 ) {
					
					if ( j == nums.length - 1 ) {
						return;
					}
					
					j++;
				}
				swap(nums, i, j);
			}
			else {
				continue;
			}
		}
	}
	
	public static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	
	public static int[] unionArray(int[] nums1, int[] nums2) {
		
		List<Integer> UnionList = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < nums1.length && j < nums2.length) {
			
			if(nums1[i] <= nums2[j]) {
				if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
			}
			
			else {
				if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
				j++;
			}
			
		}

		while(i < nums1.length) {
			if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
		}

		while(j < nums2.length) {
			if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
		}
		
		return UnionList.stream().mapToInt(r->r).toArray();
    }
	
	public static int[] union(int nums1 [], int nums2 []) {
		Set<Integer> set = new HashSet<>();
        List<Integer> union = new ArrayList<>();
        

        // Insert all elements of nums1 into the set
        for (int num : nums1) {
            set.add(num);
        }

        // Insert all elements of nums2 into the set
        for (int num : nums2) {
            set.add(num);
        }

        // Convert the set to list to get the union
        union.addAll(set);
        Integer a[] = new Integer[set.size()];
        return union.stream().mapToInt(i->i).toArray();
	}
	
	public static int[] intersectionArray(int[] nums1, int[] nums2) {
		
		List<Integer> UnionList = new ArrayList<>();
		int i = 0;
		int j = 0;

		while(i < nums1.length && j < nums2.length) {
			
			if (nums1[i] == nums2[j]) {
//				if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
//                }
                i++;
                j++;
			}
            
			else if(nums1[i] < nums2[j]) {
                i++;
			}
			
			else {
				j++;	
			}
			
		}
		
		return UnionList.stream().mapToInt(r->r).toArray();
    }

}
