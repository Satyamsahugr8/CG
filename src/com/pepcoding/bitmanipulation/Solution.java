package com.pepcoding.bitmanipulation;

public class Solution {

    public static void main(String[] args) {
        
        System.out.println("Hello World");
        System.out.println("Hello World");

        int a = 9;
        int b = 5;

        Integer c = a ^ b; // 1001 ^ 0101 -> 1100 -> 12
        // count bit set in c -> 2
        int count = 0;

        while (c > 0) {

            c = c & (c - 1); // 1100 -> 1000 -> 0000
            // this is called as Brian Kernighan’s Algorithm
            System.out.println(c);
            count++;
        }
        System.out.println(count);

        // good
        System.out.println(Integer.bitCount(a ^ b)); // 2
    }

}
