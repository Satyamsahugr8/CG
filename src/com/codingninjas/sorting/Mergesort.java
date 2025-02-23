package com.codingninjas.sorting;

public class Mergesort {
	
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
            if(arr[i] <= arr[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            }
            else {
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
    
    public static void main(String[] args) {
   
        int[] arr = {395, 158, 18, 276, 518, 591, 47, 596, 438, 102, 55, 19, 165, 198, 131, 290, 479, 491, 328, 369, 453, 277, 108, 236, 522, 86, 494, 485, 511, 112, 378, 574, 539, 330, 271, 375, 312, 58, 240, 152, 316, 138, 597, 257, 19, 96, 326, 210, 494, 317, 176, 282, 53, 174, 393, 162, 220, 414, 286, 456, 530, 535, 162, 346, 520, 208, 393, 247, 568, 186, 343, 66, 574, 121, 572, 238, 554, 112, 242, 511, 224, 282, 375, 358, 11, 324, 408, 444, 468, 252, 229, 57, 459, 286, 82, 422, 436, 115, 408, 332};
        mergeSort(arr);
        
        for (int i : arr) {
			System.out.print(i+ " ");
		}
        
    }
}
