package com.tufplus.array.zhard;

import java.util.Arrays;

public class Solution {
	
	private static long counter = 0;

	public static void main(String[] args) {
	
		//1
//		int[] nums = {1, 2, 3, 6, 7, 5, 7};
//		int[] result = findMissingRepeatingNumbers(nums);
//		
//		for (int i : result) {
//			System.out.println(i);
//		}
		
		
		//2
		int arr[] = {-10, -5, 6, 11, 15, 17};
		System.out.println(numberOfInversions(arr));
		
		//3
//		int[] nums = {6, 4, 1, 2, 7};
//		System.out.println(reversePairs(nums));
	}
	
	
	//2
	public static long numberOfInversions(int[] nums) {
		mergeSort(nums);
		return counter;
    }
	
	public static void mergeSort(int[] arr) {

    	mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int si, int ei) {
        
    	if (si >= ei) {
            return;
        }

        int mid = (si+ei)/2;

        //first half
        mergeSort(arr, si, mid);
        //second half
        mergeSort(arr, mid+1, ei);
        //merge
        merge(arr, si,ei);
    }

    private static void merge(int[] arr, int si, int ei) {
        int mid = (si+ei)/2;

        int ans[] = new int[ei - si + 1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            }
            else {
            	counter += ans.length - i + 1;
                ans[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid) {
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j <= ei) {
            ans[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < ans.length; l++) {
            arr[si+l] = ans[l];
        }
        
    }
	
	
	
	//1
	public static int[] findMissingRepeatingNumbers(int[] nums) {
		
		int n = 1;
		int missingN = -1;
		int repeatedN = -1;
		
		
		
		
		return new int[] {repeatedN, missingN};
    }
	
	//2
	public static int reversePairs(int[] nums) {
		 
		return 0;
	}

}
