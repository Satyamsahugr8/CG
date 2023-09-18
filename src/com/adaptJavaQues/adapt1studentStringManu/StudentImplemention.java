package com.adaptJavaQues.adapt1studentStringManu;

public class StudentImplemention {

    public Student getStudentInfo(String str){
        String name,usn,college;
        int cgpa;
        // str = AmitRai@1PC16CS046-ALU#8
        // str = Name @ Usn - College # cgpa
        int nam = str.indexOf("@");
        name = str.substring(0,nam);
        int us = str.indexOf("-");
        usn = str.substring(nam+1,us);
        int colleg = str.indexOf("#");
        college = str.substring(us+1,colleg);
        String cgp = str.substring(colleg+1,str.length());
        cgpa = Integer.parseInt(cgp);
        System.out.println(cgpa);

        Student a = new Student(name,usn,college,cgpa);
        return a;
    }

    public String getStudentSection(Student s){
        String sa = (s.usn).substring((s.usn).length()-3, (s.usn).length());
        int num = Integer.parseInt(sa);
        if (num>=1 && num<=60){
            return "A";
        } else if (num>=61 && num<=120) {
            return "B";
        } else if (num>=121 && num<=180) {
            return "C";
        } else if (num>180) {
            return "Z";
        }
        return "INVALID_INPUT";
    }

    // solution.java

}
