package com.codingninjas.linkedlist;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		
		
		Node<Integer> node = LinkedClassUse.takeInput();
		LinkedClassUse.printRecursively(node);
		System.out.println();
		Node<Integer> ans = deleteMiddle(node);
		
		System.out.println();
		LinkedClassUse.printRecursively(ans);
		
	}
	
	public static Node deleteMiddle(Node head) {
		
		Node temp = head;
		Node slow = head;
		Node fast = head;
		
		int count = 0;
		
		while ( fast != null && fast.next != null ) {
			count += 1;
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
//		Node answer = LinkedClassUse.delete(head, count);
		temp.next = slow.next; 
		
		return head;
    }
	
}
