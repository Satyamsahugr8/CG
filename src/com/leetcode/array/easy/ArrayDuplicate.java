package com.leetcode.array.easy;

import java.util.Arrays;

public class ArrayDuplicate {

    private static int duplicate(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i<arr.length-1; i++) {
            int b = arr[i]^arr[i+1];
            if (b == 0) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        boolean[] check = new boolean[nums.length];
        for(int i : nums) {
            if(check[i]) {
                return i;
            }
            check[i] = true;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int a[] = {1,1,2,3,4,5,6};
        System.out.println(duplicate(a));

    }
}
