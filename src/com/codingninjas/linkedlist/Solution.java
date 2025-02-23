package com.codingninjas.linkedlist;

public class Solution {
	
	public static void main(String[] args) {
	
		Node<Integer> node = LinkedClassUse.takeInput();
		LinkedClassUse.printRecursively(node);
		System.out.println();
		Node<Integer> ans = addFirstAndSecondHalf(node);
		
		System.out.println();
		LinkedClassUse.printRecursively(ans);
		
	}
	
	public static Node<Integer> addFirstAndSecondHalf(Node<Integer> node) {
        // Write your code here.
		
		Node<Integer> head = node;
		Node<Integer> second = null;
 		Node<Integer> tail = node;
 		Node<Integer> i = head;
 		Node<Integer> j = head;
 		
 		
 		while ( j != null && j.next != null ) {
 			
// 			if ( j.next != null ) {
 				tail = tail.next;
// 			}
 			j = j.next.next;
 			
 		}

 		second = tail.next;
 		tail.next = null;
 		
 		Node<Integer> ans = LinkedClassUse.addTwoNodes2(head, second);
 		
		return ans;
    }

}
