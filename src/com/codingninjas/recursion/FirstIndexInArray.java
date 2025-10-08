package com.codingninjas.recursion;

public class FirstIndexInArray {

    public static int firstIndexReturn(int arr[], int si, int x) {

        if(arr.length == 0) {
            return -1;
        }

        if(arr[si] == x) {
            return si;
        }

        int ans = firstIndexReturn(arr, si+1, x);
        if(ans == -1) {
            return -1;
        }
        return ans;
    }

    public static int firstIndexReturn(int arr[], int x) {
        return firstIndexReturn(arr, 0, x);
    }
    public static void main(String[] args) {
        int arr[] = {1,3,6,5,4,4,5,4};
        System.out.println(firstIndexReturn(arr,4));
    }
}
