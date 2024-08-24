package com.tufplus.hashing;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static int mostFrequentElement(int[] nums) {
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

            if (freq > secondMaxFreq && freq != maxFreq ) {
                secondMaxFreq = freq;
                secondMaxEle = ele;
            } else if (freq == secondMaxFreq) {
                secondMaxEle = Math.min(secondMaxEle, ele);
            }
        }

            return secondMaxEle;
        }


    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(mostFrequentElement(a));
//        System.out.println(checkSortedMain(a));
//        System.out.println(checkPrimeMain(15));


    }
}
