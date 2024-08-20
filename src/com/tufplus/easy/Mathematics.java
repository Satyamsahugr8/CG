package com.tufplus.easy;

public class Mathematics {

    public boolean isPerfect(int n) {
        int properNum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                properNum += i;
            }
        }
        return properNum == n;
    }

    public static void main(String[] args) {

        int n = 0;
        Mathematics math = new Mathematics();
        boolean rr = math.isPerfect(6);
        System.out.println(rr);

    }
}
