package com.codingninjas.linkedlist;

public class PalindromeLL {
    
    public static void main(String[] args) {
    	
    	Node<Integer> node = LinkedClassUse.takeInput();
    	System.out.println( isPalindrome(node) );
    }

    public static boolean isPalindrome(Node<Integer> head) {
        
    	Node<Integer> temp = head;
        String s = "";

        while ( temp != null ) {
            s = s + temp.data;
            temp = temp.next;
        }

        if ( isPalindrome(s) ) return true;
        else return false;
        
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        // Compare characters while i < j
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;      
            }
            i++;
            j--;
        }
        return true;      
    }

}