package com.sorting;

public class MergesortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {9,2,32,21};
        mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
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
}
