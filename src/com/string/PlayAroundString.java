package com.string;

public class PlayAroundString {

    public static void main(String[] args) {

        String str = "satyam";
        String str2 = "satyam";
        String string = new String("satyam");

        System.out.println(str == str2);
        System.out.println(str == string);


        System.out.println(str.equals(string));

    }
}
