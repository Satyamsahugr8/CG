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
//		moveZeroes(nums); 
		
		
		//3rd
		int[] arr1 = {1, 2, 2, 3, 5};
		int[] arr2 = {1, 2, 7};
		
		int[] a = unionArray(arr1, arr2);
		int[] b = intersectionArray(arr1, arr2);
		for (int r : b) {
			System.out.print(r + " ");
		}
	}
	
	public static int missingNumber(int[] nums) {
        
		int N = nums.length;
        int mainSum = N * (1 + N) / 2;
        int sum = 0;
        
        for (int i : nums) {
			sum += i; 
		}

        return mainSum - sum;
    }

	public static void moveZeroes(int[] nums) {
        
		int j = 0;
		int[] valueArray = new int[nums.length];
		
		for (int i : nums) {
			if ( i != 0) {
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
	
	int[] union(int nums1 [], int nums2 []) {
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
