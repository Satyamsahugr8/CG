package com.questionsss;

import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {

        // first repeation character
        String s = "satyamsahu"; // s

        Map<Character, Integer> map = new HashMap<>();

        for (char  c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // map
        // s:2
        // a:3
        // t:1
        // y:1
        // m:1
        // h:1
        // u:1

        // revolving again
        for (char  c : s.toCharArray()) {
            if ( map.get(c) > 1 ) {
                System.out.println(c);
                break;
            }
        }

    }
}
