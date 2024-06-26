package com.leetcode;

import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {

    public static ArrayList<Integer> removeconsecutiveduplicates(int arr[]) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {   
                arrayList.add(arr[i]);
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[] arr = {10,10,20,20,20,40,30};
        ArrayList<Integer> result = removeconsecutiveduplicates(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result["+i+"] = " + result.get(i));
        }
    }
}
