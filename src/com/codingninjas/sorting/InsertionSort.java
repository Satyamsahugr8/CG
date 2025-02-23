package com.codingninjas.sorting;

public class InsertionSort {
	
	private static void insertionSort(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			
			int j = i - 1;
			int temp = arr[i];
			
			while( j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			// do nothing if previous value is less
			arr[j+1] = temp;
			
		}
		
	}
	public static void main(String[] args) {
		
		int arr[] = {4,6,3,5,2};
		insertionSort(arr);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
	}

}
