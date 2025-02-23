package com.codingninjas.resursion;

public class CheckNumberIsPresent {

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(checkNumber(num, 4));
    }

    public static boolean checkNumber(int num, int item) {
        if(num == 0) {
            return false;
        }

        int itemImported = num%10;
        if(item == itemImported) {
            return true;
        }

        int shortNum = num/10;
        return checkNumber(shortNum, item);
    }
}
