package com.tufplus.string;

import java.util.*;

class Solution {
    public int secondMostFrequentElement(int[] nums) {
            int maxFreq = 0;
            int maxEle = 0;

            Map<Integer, Integer> hashMap = new HashMap<>();

            // Iterating on the array
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
                int ele = it.getKey();
                int freq = it.getValue();

                if (freq > maxFreq) {
                    maxFreq = freq;
                    maxEle = ele;
                } else if (freq == maxFreq) {
                    maxEle = Math.min(maxEle, ele);
                }
            }

            int secondMaxFreq = 0;
            int secondMaxEle = -1;
            
            for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
                int ele = it.getKey();
                int freq = it.getValue();

                if (freq > secondMaxFreq && freq != maxFreq) {
                    secondMaxFreq = freq;
                    secondMaxEle = ele;
                } else if (freq == secondMaxFreq) {
                    secondMaxEle = Math.min(secondMaxEle, ele);
                }
            }
            return secondMaxEle;
    }

    public int mostFrequentElement(int[] nums) {
        int maxFreq = 0;
        int maxEle = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        // Iterating on the array
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            int ele = it.getKey();
            int freq = it.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
        }

        return maxEle;
    }

    public static int stringWithLowestFrequency(int[] nums) {
        int maxFreq = 0;
        int minFreq = nums.length;

        Map<Integer, Integer> hashMap = new HashMap<>();

        // Iterating on the array
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            int freq = it.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
            }

            if (freq < minFreq) {
                minFreq = freq;
            }
        }
        System.out.println("hashMap = " + hashMap);
        System.out.println("maxFreq = " + maxFreq);
        System.out.println("minFreq = " + minFreq);
        return maxFreq + minFreq;

//        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
//            int freq = it.getValue();
//
//            if (freq < minFreq) {
//                minFreq = freq;
//            }
//        }
//        return maxEle;
    }

    public static String stringWithLowestFrequency(String[] nums) {
        String minEle = "";
        int minFreq = Integer.MAX_VALUE;

        Map<String, Integer> hashMap = new HashMap<>();

        // Iterating on the array
        for (String num : nums) {
            hashMap.put(num, num.length());
        }

        for (Map.Entry<String, Integer> it : hashMap.entrySet()) {
            int freq = it.getValue();
            String ele = it.getKey();
            if (freq < minFreq) {
                minFreq = freq;
                minEle = ele;
            }
        }
        return minEle;
    }

    public static String longestCommonPrefix(String[] str, String str2) {
        //your code goes here
        boolean b = false;

        //base
        if (str2.isEmpty()) {
            return "";
        }

        for (String s : str) {
            b = s.startsWith(str2);
            if (!b) {
                break;
            }
        }
        if (b) {
            return str2;
        } else {
            return longestCommonPrefix(str, str2.substring(0, str2.length()-1));
        }
    }

    public String longestCommonPrefix(String[] v) {
        // Use StringBuilder to build the result
        StringBuilder ans = new StringBuilder();

        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] a = {1,2,2,3,3,3,1,0};
//        int aw = stringWithLowestFrequency(a);
//        System.out.println(aw);
//        String[] a = {"lazy", "land", "ssty"};

//        String[] a = {"satyam", "sahu", "sat"};
//        // "la"
//        String shortestString = stringWithLowestFrequency(a);
//        System.out.println(longestCommonPrefix(a, shortestString));


//        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.anagramStrings("anagram", "nagaram"));

    }

    public List<Character> frequencySort(String s) {
        //your code goes here
//
//        char[] characters = s.toCharArray();
//        int maxFreq = 0;
//        char minEle;
//
//
//        Map<Character, Integer> hashMap = new HashMap<>();
//
//        // Iterating on the array
//        for (char c: characters) {
//            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> it : hashMap.entrySet()) {
//            int freq = it.getValue();
//            Character ele = it.getKey();
//            if (freq > maxFreq) {
//                maxFreq = freq;
//                minEle = ele;
//            }
//        }
//
//        List<Character> list = new ArrayList<>();
//
//        for (Character c: list) {
//            list.add()
//        }
//        list.sort((a,b)-> a.compareTo(b));
////        list.sort();
//        return list;




        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) {
                return p2.freq - p1.freq;
            }
            return p1.ch - p2.ch;
        });

        // Collect result
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0) result.add(p.ch);
        }
        return result;
    }

    class Pair {
        int freq;
        char ch;
        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }

    public boolean anagramStrings(String s, String t) {
        //your code goes here

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
//
//    public boolean rotateString(String s, String goal) {
//        //your code goes here
//    }
//

    public boolean isomorphicString(String s, String t) {
        //your code goes here
        Map<Character,Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))) {

                // check if the value we are going to map
                // isn't mapped to another value of s
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                
            } else if( map.get(s.charAt(i)) != t.charAt(i) ) {
                return false;
            }
        }
        return true;
    }

}

