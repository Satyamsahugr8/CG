package com.leetcoder.pattern.string;

import java.util.HashMap;
import java.util.Map;

public class StringBasics {

    public static void main(String[] args) {
        
        // String str = "  banan   a  ";
        // System.out.println(str);
        // System.out.println(str.trim());

        // int i = 0;
        // System.out.println(String.valueOf(i));

        // String s = "14";
        // System.out.println(Integer.valueOf(s));
        // System.out.println(s.join(",", s, "ss"));

        // use of format
        // String s = "9";
        // int age = 18;
        // String format = s.format("Hello %s, age %d", s, age);
        // System.out.println(format);

        // boolean b = s.matches("\\d+");
        // System.out.println(b);

        // String string1 = new String("Hello");
        // System.out.println(string1.intern());

        // String str = "satyam sahu mayank sahu";
        // System.out.println(str.split("\\s+").length);

        // System.out.println(str.contains("sahu"));
        // System.out.println(str.indexOf("sahu"));


        String str = "satyam sahu mayank sahu";
        String sub = "sahu";

        if (str.contains(sub)) {
            int firstIndex = str.indexOf(sub);
            System.out.println("Substring found at index: " + firstIndex);
        } else {
            System.out.println("Substring not found.");
        }


        // Find first non-repeating character
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : str.toCharArray()) {
            if (countMap.get(c) == 1) {
                System.out.println("First non-repeating character: " + c);
                break;
            }
        }

    }
}
