package com.tufplus.easy;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, 5, 6, 8, 12, 15 };
//        int[] rev = reverseArrays(A);

//        public int[] reverse(int[] arr) {
            for(int i = 0, j = arr.length-1; i<arr.length/2 && arr.length/2<j; i++,j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
//            return arr;
//        }

        for (int i : arr) {
            System.out.print(i + ",");
        }

    }
}
