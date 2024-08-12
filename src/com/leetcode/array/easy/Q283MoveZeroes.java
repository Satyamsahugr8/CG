package com.leetcode.array.easy;

public class Q283MoveZeroes {

    public void moveZeroes(int[] arr) {
//        {0,1,0,3,12};
//        {1,0,1,0,0};

        int[] tempArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                tempArray[i] = 1;
            }
        }
//        arr[i] = {0,1,0,3,12};
//        tempArray[i] = {1,0,1,0,0};
//        for (int i = 0, j = 0; i < arr.length; i++,j++) {
//            if (tempArray[i] == 1) {
//                int temp = arr[i];
//                while(j<arr.length && arr[j]!=arr[i]) {
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        [1,3,12,3,12]
        int index = 0;
        for (int i = 0, j = 0; i < arr.length; i++,j++) {
            if (tempArray[i] == 0) {
                int temp = arr[i];
                arr[index] = temp;
//              arr[i] = temp;
                index++;
            }
        }

        while(index< arr.length) {
            arr[index] = 0;
            index++;

        }
    }

//


    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        Q283MoveZeroes q = new Q283MoveZeroes();
        q.moveZeroes(a);
        
        for (int i:a) {
            System.out.print(" " + i);
        }
    }
}
