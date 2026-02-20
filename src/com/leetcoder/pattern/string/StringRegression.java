package com.leetcoder.pattern.string;

import java.util.Arrays;
import java.util.Scanner;

public class StringRegression {
    
    public static void main(String[] args) {
        // System.out.println("satyam");
        // takeInput();


        String str = "1, 3, 4, 7, 13";
        String[] parts = str.split(",\\s*"); // ["1", "3", "4", "7", "13"]

        for (String num : parts) {
            char[] chars = num.toCharArray();
            System.out.println(Arrays.toString(chars));
        }

        // change it to int aarr

        // and
        String s = "abc";
        String ss = "abd";
        System.out.println(ss.compareTo(s));
        System.out.println(s.compareTo(ss));


        String strw = "banana";
        System.out.println(strw.indexOf("na"));

        

    }

    static void takeInput() {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
    }

}
