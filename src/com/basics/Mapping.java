package com.basics;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

    public static void main(String[] args) {
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        for (Integer entry : map.keySet()) {
            System.out.println("Key: " + entry + ", Value: " + map.get(entry));
        }
        
        map.put(5, map.getOrDefault(1, "Default") + 1);
    

        for (Integer entry : map.keySet()) {
            System.out.println("Key: " + entry + ", Value: " + map.get(entry));
        }

        for ( Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    
}
