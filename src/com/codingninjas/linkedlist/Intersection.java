package com.codingninjas.linkedlist;

public class Intersection {

	public static void main(String[] args) {
		
		Node<Integer> node1 = LinkedClassUse.takeInput();
//		Node<Integer> node2 = LinkedClassUse.takeInput();
//		Node<Integer> answer = getIntersectionNode(node1, node2);
//		LinkedClassUse.printRecursively(answer);
		
//		System.out.println("rev : ");
//		Node<Integer> rev = LinkedClassUse.reverseRecursivelyBest(node1);
//		LinkedClassUse.printRecursively(rev);
		
		System.out.println(isPalindrome(node1));
	}
	
	public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
		
		Node<Integer> temp1 = headA;
		Node<Integer> temp2 = headB;
		
		
		
		return null;
	}
	
	public static boolean isPalindrome(Node<Integer> head) {
		
		// find middle 
		Node<Integer> temp = head;
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		
		
		while ( fast.next != null && fast.next.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
//		System.out.print("slow : ");
//		LinkedClassUse.printRecursively(slow);
//		
//		System.out.println("rev : ");
		
		Node<Integer> rev = LinkedClassUse.reverseRecursivelyBest(slow.next);
//		LinkedClassUse.printRecursively(rev);
		
		while ( rev != null ) {
			if (rev.data != temp.data) {
				LinkedClassUse.reverseRecursivelyBest(rev);
				return false;
			}
			rev = rev.next;
			temp = temp.next;
		}
		
		LinkedClassUse.reverseRecursivelyBest(rev);
		return true;
    }

}
