package com.recursion;

public class replacebTox {

    public static String replacebtox(String str) {

        if (str.length() == 0) {
            return "";
        }

        String newString = "";
        if (str.charAt(0) == 'b') {
            newString += 'q';
        } else
            newString += str.charAt(0);

        return newString + replacebtox(str.substring(1));
    }
    public static void main(String[] args) {
        String str = "bxbcodcbvv";
        System.out.println(replacebtox(str));
    }
}
