package com.codingninjas.linkedlist;

import java.util.HashMap;

public class CopyLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head = LinkedClassUse.takeInput();
		LinkedClassUse.printRecursively(head);
		Node<Integer> answer = copyRandomList(head);
		System.out.println("answer : ");
		LinkedClassUse.printRecursively(answer);

	}
	
	public static Node<Integer> copyRandomList(Node<Integer> head) {
		
		if ( head == null ) return null;
		
		// create a new node + filling in map
		HashMap<Node<Integer>, Node<Integer>> map = new HashMap<Node<Integer>, Node<Integer>>();
		Node<Integer> temp = head;
		
		while ( temp != null ) {
			
			Node<Integer> newNode = new Node<Integer>(temp.data);
			map.put(temp, newNode);
			
			temp = temp.next;	
		}
		
		// reset to iterate again over map 
		temp = head;
		
		while ( temp != null ) {
			
			Node<Integer> copyNode = map.get(temp);
			
			copyNode.next = map.get(temp.next);
//			copyNode.random = map.get(temp.random);
			
			temp = temp.next;
		}
		
		return map.get(head);
	}
	
	// one more approach add in between and then add add its next & random pointers.
	
}
