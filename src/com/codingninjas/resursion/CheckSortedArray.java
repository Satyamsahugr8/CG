package com.codingninjas.resursion;

public class CheckSortedArray {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(checkSorted(arr));
    }

    private static boolean checkSorted(int[] arr) {
        return checkSorted(arr, 0);
    }

    private static boolean checkSorted(int[] arr, int si) {
        if (arr[si] > arr[si+1]) {
            return false;
        }
        if (si == arr.length-2) {
            return true;
        }

        return checkSorted(arr, si+1);
    }


}

