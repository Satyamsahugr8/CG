package com.leetcoder.pattern.array.slidingwindow2pointerfixed;

import java.util.HashSet;
import java.util.Set;

public class QcontainsNearbyDuplicate {
    /**
     * Returns true if there are two distinct indices i and j in the array such that
     * nums[i] == nums[j] and abs(i - j) <= k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        System.out.println("ss");
    }
}