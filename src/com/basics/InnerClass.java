package com.basics;

import java.util.Arrays;

public class InnerClass {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.createInnerInstance();
        int a[] = {11,7,1,13,21,3,7,3};
        int b[] = {11,3,7,7};
        System.out.println(isSubset(a, b));
        Arrays.copyOf(a, a.length);
    }

    public static boolean isSubset(int a[], int b[]) {
        // Your code here
        int i = 0;
        int j = 0;
        
        while ( i < b.length ) {
            
            int bb = b[i];
            while ( j < a.length ) {
                int aa = a[j];
                if ( bb == aa ) {
                    a[j] = -1;
                    break;
                }
                j++;
            }
            
            if ( j == a.length ) {
                return false;
            }

            i++;
            j = 0;
        }
        return true;
    }
}


class OuterClass {
    private String outerField = "Outer Field";

    class Inner {
        void display() {
            System.out.println("Accessing: " + outerField);
        }
    }

    void createInnerInstance() {
        Inner inner = new Inner();
        inner.display();
    }
}


