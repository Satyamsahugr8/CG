package com.tufplus.sorting;

import com.leetcode.array.medium.MergeArray;
import com.sorting.Mergesort;
import com.sorting.QuickSort;

public class Sorting {
	
    public static int[] bubbleSort(int[] nums) {
    	
    	for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-1; j++) {
				
				if ( nums[j+1] < nums[j] ) {
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
				
			}
		}
		return nums;
		
    }
    
    public static int[] selectionSort(int[] nums) {
    	
    	for (int i = 0; i < nums.length - 1; i++) {
    		
    		int min = nums[i];
    		int minindex = i;
    		
    		for (int j = i + 1; j < nums.length; j++) {
    			
    			if (nums[j] < min) {
    				min = nums[j];
    				minindex = j;
    			}
			}
    		
    		//swap 
    		int temp = nums[i];
    		nums[i] = min;
    		nums[minindex] = temp;
    	
		}
    	
    	return nums;
    }
    
    public static void insertion_sort(int[] arr) {
    	
    	for (int i = 0; i <= arr.length - 1; i++) {
    		int j = i;
    		while (j > 0 && arr[j - 1] > arr[j]) {
    			int temp = arr[j - 1];
    			arr[j - 1] = arr[j];
    			arr[j] = temp;
    			j--;
    		}
    	}
    	
    }

    
    public static void quickSort(int[] nums) {
    	
    	QuickSort.quickSort(nums);
    }
    
    public static void mergeSort(int[] nums) {
    	
    	Mergesort.mergeSort(nums);
    }
        
        
    public static void main(String[] args) {
		
    	int[] a = {21,16,24,5,3};
//    	bubbleSort(a);
//    	selectionSort(a);
    	insertion_sort(a);
    	quickSort(a);
    	mergeSort(a);
    	
    	for (int i : a) {
			System.out.print(i + " ");
		}
	}
    
}







