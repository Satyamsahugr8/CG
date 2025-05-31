package com.leetcode.recursion;

public class BinaryStringConverter {
    
	public static String toBinaryString(int i, int l) {
        
		String binary = Integer.toBinaryString(i); // Convert to binary
        
		if (binary.length() > l) {
            return binary.substring(binary.length() - l); // Trim to length
        } 
		else {
            return String.format("%" + l + "s", binary).replace(' ', '0'); // Pad with leading zeros
        }
    }

    public static void main(String[] args) {
    	
        System.out.println(toBinaryString(5, 8));  // Output: 00000101
        System.out.println(toBinaryString(255, 8)); // Output: 11111111
        System.out.println(toBinaryString(1023, 8)); // Output: 11111111 (trimmed)
    }
    
}