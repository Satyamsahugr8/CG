package com.sorting;

public class MergeArray {

	public static int[] mergeArray(int[] arr, int[] brr) {
		int a[] = new int[arr.length + brr.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i<arr.length && j<brr.length) {
			if(arr[i] < brr[j]) {
				a[k] = arr[i];
				i++;
				k++;
			}
			else if(brr[j] < arr[i]) {
				a[k] = brr[j];
				j++;
				k++;
			}
		}

		while(i<arr.length) {
			a[k] = arr[i];
			i++;
			k++;
		}

		while(j<arr.length) {
			a[k] = brr[j];
			i++;
			k++;
		}
		return a;
	}

	public static void main(String[] args) {
		int arr[] = {1,5,9};
		int brr[] = {2,3,8};

		int[] a = mergeArray(arr, brr);

		for (int r : a) {
			System.out.print(r + " ");
		}
		
	}

}