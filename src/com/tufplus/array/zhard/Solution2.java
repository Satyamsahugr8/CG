package com.tufplus.array.zhard;

public class Solution2 {

	public static void main(String[] args) {
		
		//3
		int[] nums = { 
//				6, 4, 1, 2, 7 
				5, 4, 4, 3, 3};
		System.out.println(reversePairs(nums));
		
	}
	
	public static int reversePairs(int[] nums) {
		 return mergeSort(nums);
	}
	
	public static int mergeSort(int[] arr) {
    	
    	return mergeSort(arr, 0, arr.length-1);
    }

    private static int mergeSort(int[] arr, int si, int ei) {
        
    	int counter = 0;
    	
    	if (si >= ei) {
            return counter;
        }

        int mid = (si+ei)/2;

        //first half
        counter += mergeSort(arr, si, mid);
        //second half
        counter += mergeSort(arr, mid+1, ei);
        //merge
        counter += merge(arr, si,ei);
        
        return counter;
    }

    private static int merge(int[] arr, int si, int ei) {
        
    	int mid = (si+ei)/2;
    	int counter = 0;

        int ans[] = new int[ei - si + 1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] <= arr[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            }
            else {
            	if (arr[i] > 2 * arr[j]) {
            		counter += ei - si + 1;
            	}
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
        
        return counter;
        
    }

}
