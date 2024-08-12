package com.leetcode.array.medium;

public class MoveZeroToLast {
    public static void main(String[] args) {
        int[] arr = {1,0,4,6,0,2,43};
        moveZeroToEnd(arr);

        for (int a: arr) {
            System.out.print(a+" ");
        }
    }

    private static void moveZeroToEnd(int[] arr) {
        int last = arr.length-1;
        for (int i = 0; i < last; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[last];
                arr[last] = temp;
                last--;
            }
        }
    }
}
