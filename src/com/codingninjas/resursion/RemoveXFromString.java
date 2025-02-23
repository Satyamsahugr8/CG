package com.codingninjas.resursion;

public class RemoveXFromString {
    public static void main(String[] args) {
        String str = "xbbaxbaxad";
        System.out.println(removeX(str));
    }

    private static String removeX(String str) {
        if (str.length() == 0) {
            return "";
        }

        String newString = "";
        if (str.charAt(0) != 'x') {
            newString += str.charAt(0);
        }

        return newString + removeX(str.substring(1));
    }

}

