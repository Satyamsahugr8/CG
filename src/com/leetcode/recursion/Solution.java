package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String ss = getHappyString(3, 4 - 1);
//		System.out.println(ss);

//		String u = BinaryStringConverter.toBinaryString(4, 3);
//		System.out.println(u);
		
		String []nums = {"00","01"};
		String ss = findDifferentBinaryString(nums);
		System.out.println(ss);
	}
	public static String getHappyString(int n, int k) {
		String [] ss = {"a", "b", "c"};
        ArrayList<String> ans = createAllHappyString(n, ss, "");
        
        for (String string : ans) {
			System.out.println(string);
		}
        
        if ( k > ans.size() - 1 ) return "";
        return ans.get(k);
    }
	
	static ArrayList<String> createAllHappyString(int n, String [] ss, String answer) {
		
		ArrayList<String> ans = new ArrayList<String>();
		
//		System.out.println(answer.length());
		
		if (answer.length() == n) {
			ans.add(answer);
			return ans;
		}
		
		//choosing a in ans
		if (answer.length() - 1 == -1 || answer.charAt(answer.length() - 1) != 'a') {
			ArrayList<String> aAns = createAllHappyString(n, ss, answer + 'a');
			ans.addAll(aAns);
		}
		
		// choosing b in ans
		if (answer.length() - 1 == -1 || answer.charAt(answer.length() - 1) != 'b') {
			ArrayList<String> bAns = createAllHappyString(n, ss, answer + 'b');
			ans.addAll(bAns);
		}
		
		// choosing c in ans
		if (answer.length() - 1 == -1 || answer.charAt(answer.length() - 1) != 'c') {
			ArrayList<String> cAns = createAllHappyString(n, ss, answer + 'c');
			ans.addAll(cAns);
		}
		
		return ans;
	}

	public static String findDifferentBinaryString(String[] nums) {
        
		Arrays.sort(nums, Comparator.comparingInt(b -> Integer.parseInt(b, 2)));
		
		for (String string : nums) {
			System.out.println(string);
		}
		
		int j = 0;
		for (int i = 0; i < Long.parseLong(nums[nums.length - 1]); i++) {
			if ( i != Integer.parseInt(nums[j]) ) {
				return BinaryStringConverter.toBinaryString(i, nums[0].length());
			}
			else j++;
		}
		
		return BinaryStringConverter.toBinaryString(j+1, nums[0].length());
    }
	

}

class BinaryStringConverter {
    public static String toBinaryString(int i, int l) {
        String binary = Integer.toBinaryString(i); // Convert to binary
        if (binary.length() > l) {
            return binary.substring(binary.length() - l); // Trim to length
        } else {
            return String.format("%" + l + "s", binary).replace(' ', '0'); // Pad with leading zeros
        }
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(5, 8));  // Output: 00000101
        System.out.println(toBinaryString(255, 8)); // Output: 11111111
        System.out.println(toBinaryString(1023, 8)); // Output: 11111111 (trimmed)
    }
}
