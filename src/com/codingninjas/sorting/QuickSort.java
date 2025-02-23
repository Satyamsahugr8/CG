package com.codingninjas.sorting;

public class QuickSort {
    public static void main(String[] args) {
        
    	int[] arr = {763,533,2,1,2,32,21};
        
        quickSort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        
    }
    
    public static void quickSort(int[] arr) {
    	quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int si, int ei) {

        if (si >= ei) {
            return;
        }

        int partitionIndex = partition(arr, si, ei);
        quickSort(arr, si, partitionIndex-1);
        quickSort(arr, partitionIndex+1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {

        int pivot = arr[si];
        int count = 0;
        for (int i = si+1; i <= ei; i++) {
            if(arr[i] <= pivot) {
                count++;
            }
        }

        //swap
        int pivotIndex = si + count;
        arr[si] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        int i = si;
        int j = ei;

        while(i<j) {
            while ( i <= ei && arr[i] <= pivot) {
                i++;
            }
            while ( j >= si && arr[j] > pivot) {
                j--;
            }

            if(i<=j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }
}
