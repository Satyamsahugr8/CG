package com.leetcode.array.easy;

public class Q26 {
    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(a, 2));

        for (int j : a) {
            System.out.print(j+",");
        }

    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i< nums.length; i++) {
            if(val!=nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
