package com.leetcoder.pattern.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharByFreq {
    
    // Input (IP)	Output (OP)
    // "tree"	"eert" (or "eetr")
    // "ccaaabb"	"aaacccbb" (or "cccaaabb", etc.)

    public static void main(String[] args) {


        String[] s = {"tree", "ccaaabb"};

        for (String string : s) {
            String a = frequencySort2(string);
            System.out.println(a);
        }


        // String ans = frequencySort("ccaaabb");
        // System.out.println(ans);
    }


    // sort my keys
    public static String frequencySort1(String s) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqMap = new TreeMap<>();
        
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // sort with wrt to map
        // List<Character> characters = new ArrayList<>(freqMap.keySet());
    
        // // Sort the list based on the frequency in descending order
        // Collections.sort(characters, (a, b) -> freqMap.get(b) - freqMap.get(a));

        freqMap.forEach((k, v) -> { 
            for (int i = 1; i <= v; i++) {
                sb.append(k);
            }
        });

        return sb.toString();
    }


    // sort my values
    // under stood
    public static String frequencySort2(String s) {
        StringBuilder sb = new StringBuilder();

        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort entries by frequency (descending)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // descending

        // Step 3: Build output string
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
