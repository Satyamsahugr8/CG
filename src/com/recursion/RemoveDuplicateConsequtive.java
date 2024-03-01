package com.recursion;

public class RemoveDuplicateConsequtive {

    public static String removeDup(String str) {

        if (str.length() <= 1) {
            return str;
        }


        if (str.charAt(0) == str.charAt(1)) {
            return removeDup(str.substring(1));
        } else {
            String newstring = removeDup(str.substring(1));
            return str.charAt(0) + newstring;
        }
    }
    public static void main(String[] args) {
        String str = "BBBBBBBB";
        System.out.println(removeDup(str));
    }
}
