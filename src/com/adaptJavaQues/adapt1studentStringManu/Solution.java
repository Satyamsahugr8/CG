package com.adaptJavaQues.adapt1studentStringManu;

public class Solution {
    public static void main(String[] args) {

        StudentImplemention s = new StudentImplemention();

        String str = "AmitRai@1PC16CS046-ALU#8";
        Student st = s.getStudentInfo(str);
        String sa = s.getStudentSection(st);
        System.out.println(sa);

        String str2 = "SatyamSahu@IT64-OCT#9";
        Student st2 = s.getStudentInfo(str);
        String sa2 = s.getStudentSection(st);
        System.out.println(sa2);

    }
}
