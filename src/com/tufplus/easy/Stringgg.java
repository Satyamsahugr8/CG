package com.tufplus.easy;

public class Stringgg {

    public static void main(String[] args) {

        String s = "501";
        System.out.println(Stringgg.largeOddNum(s));
    }

    public static String largeOddNum(String s) {
        //your code goes here
        for ( int i = s.length()-1; i >= 0; i--) {
            if ( ((int)s.charAt(i)) %2 != 0 ) {
                return s.substring(0, i+1);
            }
        }
        return "";
    }
}
