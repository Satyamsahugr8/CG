package com.codingninjas.recursion;

public class LastIndexInArray {
    public static void main(String[] args) {
        int arr[] = {7,5,3,3,6,5};
        System.out.println(lastIndexReturn(arr,3));
    }

    private static int lastIndexReturn(int []arr, int si, int ei, int x) {

        if (arr.length == 0) {
            return -1;
        }

        if (si == ei) {
            return -1;
        }

        int a = lastIndexReturn(arr, si+1, ei, x);
        if (a == -1) {
            if(arr[si] == x) {
                return si;
            } else
                return -1;
        }
        return a;
    }
    private static int lastIndexReturn(int[] arr, int x) {
        return lastIndexReturn(arr, 0, arr.length, x);
    }
}
