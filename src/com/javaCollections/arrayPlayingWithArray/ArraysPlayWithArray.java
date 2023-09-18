package com.javaCollections.arrayPlayingWithArray;

public class ArraysPlayWithArray {
    public static void main(String[] args) {
        int[] a = new int[100];
        a[0] = 20;
        a[1] = 21;
        a[2] = 22;
        a[3] = 22;
        a[4] = 22;
        a[5] = 22;

        for (int i=0; i<=100; i++) {
            System.out.print(a[i]+",");
        }
    }
}
