package com.adaptJavaQues.adapt3arrayAscending;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AscendingArrayElement {
    public static void ascendingArray(String[] a) {
        List ls = Arrays.stream(a).sorted().collect(Collectors.toList());
        System.out.println(ls);
    }
    public static void main(String[] args) {
        String a [] = {"satyam","mayank","Avinash","ritik"};
        ascendingArray(a);
    }
}
