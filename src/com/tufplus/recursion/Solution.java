package com.tufplus.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public void reverseArray(int[] nums) {
        //your code goes here

        recursionMethod(nums, 0, nums.length - 1);
    }

    public static int[] recursionMethod(int[] nums, int i, int j) {
        //base condition
        if (i>=j) {
            return nums;
        }

        // main logic
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return recursionMethod(nums, i+1, j-1);
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here
        Object[] objects = nums.toArray();
        int[] ints = Arrays.stream(objects).mapToInt(o -> (int)o).toArray();
        return Solution.checkSortedMain(ints);
    }

    public static boolean checkSortedMain(int[] num) {
        //your code goes here
        return checkSorted(num, 0);
    }

    public static boolean checkSorted(int[] arr, int i) {

        //base condition
        if (arr.length <= 1 || i== arr.length-1) {
            return true;
        }

        //calculation
        if (arr[i+1]<arr[i]) {
            return false;
        }

        //smaller case
        return checkSorted(arr, i+1);
    }

    public static boolean checkPrimeMain(int num) {
        //your code goes here
        return checkPrime(num, 2);
    }

    private static boolean checkPrime(int num, int i) {

        //base
        if (num == 0 || num == 1) {
            return false;
        }

        if ( num % i == 0 ) {
            return false;
        }

        if ( num >= i ) {
            return true;
        }

        return checkPrime(num, i+1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2};
        s.reverseArray(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(8);
        s.isSorted(arrayList);

        System.out.println("s.isSorted(arrayList) = " + s.isSorted(arrayList));

    }
}
