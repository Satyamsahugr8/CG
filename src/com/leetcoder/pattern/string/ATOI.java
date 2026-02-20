package com.leetcoder.pattern.string;

public class ATOI {

    public static void main(String[] args) {
        
        String[] s = {"42", " -042", "1337c0d3", "0-1", "words and 987"};

        for (String string : s) {
            int a = myAtoi(string);
            System.out.println(a);
        }


    }

    public static int myAtoi(String s) {
        
        s = s.trim();
        int sign = 1;

        long ans = 0;
        
        int index = 0;
        char firstChar = s.charAt(index);

        if ( firstChar == '-' ) {
            sign = -1;
            index++;
        }

        else if ( firstChar == '+' ) {
            sign = 1;
            index++;
        }

        if ( !Character.isDigit(s.charAt(index)) ) {
            return 0;
        }

        while ( index < s.length() ) {
            char c = s.charAt(index);

            if (!Character.isDigit(c)) {
            break;
            }

            int digit = c - '0';

            
            // ans = ans*10 + Integer.parseInt(c+"");
            // index++;
            
            ans = ans * 10 + digit;
        
            // Check for overflow/underflow against the final INT range
            if (sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            index++;

        }

        return (int) (sign * ans);
    }
    
}
