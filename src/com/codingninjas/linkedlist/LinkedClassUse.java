package com.codingninjas.linkedlist;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;
	
	public DoubleNode(Node<Integer> head, Node<Integer> tail) {
		this.head = head;
		this.tail = tail;
	}

	public DoubleNode() {
	}
	
}

@SuppressWarnings({"resource"})
public class LinkedClassUse {

	public static Node<Integer> createLinkedList() {

//    	3,9,8,7,4,5
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		Node<Integer> n5 = new Node<>(5);
//        Node<Integer> n6 = new Node<>(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//        n5.next = n6;
		return n1;
	}

	public static Node<Integer> createLinkedList3() {

//    	3,9,8,7,4,5
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
//		Node<Integer> n5 = new Node<>(5);
//		Node<Integer> n6 = new Node<>(6);
//		Node<Integer> n7 = new Node<>(7);
//		Node<Integer> n8 = new Node<>(8);
//		Node<Integer> n9 = new Node<>(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//		n6.next = n7;
//		n7.next = n8;
//		n8.next = n9;
		return n1;
	}

	public static Node<Integer> createLinkedList2() {
//    	9,2,9,2,8,5
		Node<Integer> n6 = new Node<>(5);
		Node<Integer> n5 = new Node<>(8, n6);
		Node<Integer> n4 = new Node<>(2, n5);
		Node<Integer> n3 = new Node<>(9, n4);
		Node<Integer> n2 = new Node<>(2, n3);
		Node<Integer> n1 = new Node<>(9, n2);
		return n1;
	}

	public static Node<Integer> increment(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			temp.data++;
			temp = temp.next;
		}
		return head;
	}

	public static Node<Integer> takeInput() {
		
		Scanner scanner = new Scanner(System.in);
		Integer data = scanner.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail  = null;

		while (data != -1) {
			Node<Integer> currentNode = new Node<>(data);

			if (head == null) {
				head = currentNode;
				tail = currentNode;
			}

			else {
				
//				Node<Integer> tail = head;
//
//				while (tail.next != null) {
//					tail = tail.next;
//				}
//
//				// connecting new element into linkedList
//				tail.next = currentNode;
				
				
				
				tail.next = currentNode;
				tail = currentNode; // tail  = tail.next;
			}

			data = scanner.nextInt();

		}

//		scanner.close();
		return head;

	}

	public static Integer count(Node<Integer> head) {
		int count = 0;
		Node<Integer> temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		int counter = 0;
		while (temp != null) {
			counter++;
			System.out.println("head" + counter + " = " + temp.data);
			temp = temp.next;
		}
	}

	public static Integer printIth(Node<Integer> head, Integer index) {
		Node<Integer> temp = head;
		int count = 0;
		while (temp != null) {
			if (count++ == index) {
				return temp.data;
			}
			temp = temp.next;

		}
		return -1;
	}

	public static <T> T printGenericIth(Node<T> head, Integer index) {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			if (count++ == index) {
				return temp.data;
			}
			temp = temp.next;
		}
		return null;
	}

	public static Node<Integer> addElementAtIndex(Node<Integer> head, Integer item, Integer index) {
		int count = 0;
		int maximumCount = count(head);
		Node<Integer> temp = head;
		Node<Integer> itemToBeAdded = new Node<>(item);

		if (index == 0) {
			itemToBeAdded.next = head;
			head = itemToBeAdded;
			return head;
		}

		if (index > maximumCount) {
			return head;
		}

		while (count < index - 1) {
			count++;
			temp = temp.next;
		}

		itemToBeAdded.next = temp.next;
		temp.next = itemToBeAdded;

		return head;
	}

	public static Node<Integer> addElementAtIndexEasy(Node<Integer> head, Integer item, Integer index) {

		int count = 0;
		Node<Integer> temp = head;

		if (head == null) {
			if (index == 1)
				return new Node<Integer>(item);
			else
				return head;
		}

		if (index == 1)
			return new Node<Integer>(item, head);

		while (temp != null) {

			count++;

			if (count == index - 1) {
				Node<Integer> newNode = new Node<Integer>(item, temp.next);
				temp.next = newNode;
				break;
			}

			temp = temp.next;
		}

		return head;
	}

	public static Node<Integer> delete(Node<Integer> head, int index) {

		if (head == null) {
			return head;
		}

		if (head.next == null) {
			head = null;
			return head;
		}

		Node<Integer> temp = head;
		int i = 0;
		while (i < (index - 1)) {
			temp = temp.next;
			i++;
		}

		// this means we reacted our target position
		temp.next = temp.next.next;

		return head;
	}

	public static int valuePosition(Node<Integer> head, int value) {

		Node<Integer> temp = head;
		int position = 0;
		while (temp != null) {
			position++;
			if (temp.data == value) {
				return position;
			}
			temp = temp.next;
		}
		return -1;
	}

	public static Node<Integer> deleteByValue(Node<Integer> head, int value) {
		return delete(head, valuePosition(head, value));
	}

	public static Node<Integer> deleteHead(Node<Integer> head) {

		head = head.next;
//    	1 -> 2 -> 3
//    	2 -> 3
		return head;
	}

	public static Node<Integer> deleteTail(Node<Integer> head) {
		return delete(head, 0);
	}
	
	public static void printRecursively(Node<Integer> head) {

		if (head == null) {
			System.out.print("null ");
			return;
		}
		
		System.out.print(head.data + " ");
		printRecursively(head.next);
	}

	public static void printReverseNodeRecursively(Node<Integer> head) {

		if (head == null) {
			System.out.print("null ");
			return;
		}

		printReverseNodeRecursively(head.next);
		System.out.print(head.data + " ");
	}

	public static Node<Integer> insertionUsingRecursion(Node<Integer> head, Integer newNumber, Integer index) {

		if (index == 0) {
			Node<Integer> newNode = new Node<Integer>(newNumber);
			newNode.next = head;
			return newNode;
		}

		if (head == null) {
			return null;
		}

		head.next = insertionUsingRecursion(head.next, newNumber, index - 1);

		return head;
	}

	public static Node<Integer> deletionUsingRecursion(Node<Integer> head, Integer index) {

		if (index == 0) {
			return head.next;
		}

		if (head == null)
			return head;

		head.next = deletionUsingRecursion(head.next, index - 1);
		return head;

	}

	public static int findNode(Node<Integer> head, Integer nodeData) {
		int count = 0;
		Node<Integer> temp = head;
		while (temp != null) {
			count++;
			if (nodeData == temp.data) {
				return count;
			}
			temp = temp.next;
		}
		return -1;
	}

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, Integer n) {
		int length = count(head);
		int dis = length - n;
		Node<Integer> dummy = new Node<Integer>(0);
		Node<Integer> node1 = dummy;
		Node<Integer> dummy2 = new Node<Integer>(0);
		Node<Integer> node2 = dummy2;
		Node<Integer> node3 = node2;

		if (n == 0 || n % length == 0) {
			return head;
		}

		int i = 1;
		dummy.next = head;

		while (i <= dis) {
			dummy = dummy.next;
			i++;
		}

		dummy2.next = dummy.next;
		dummy.next = null;

		while (node2 != null) {
			node2 = node2.next;
			if (node2.next == null) {
				node2.next = node1.next;
				break;
			}
		}

		return node3.next;
	}

	public static Node<Integer> appendLastNToFirst2(Node<Integer> head, Integer n) {

		int length = count(head);

		if (n > length) {
			n = n % length;
		}

		if (n < -1 * length) {
			n = n % length;
		}

		int count = length - n;

		if (n < 0) {
			count = -1 * n;
		}

		System.out.println("n : " + n);
		System.out.println("count : " + count);

		Node<Integer> currentNode = head;
		Node<Integer> head2 = new Node<Integer>(0);
		Node<Integer> finalNode = head2;

		if (n == 0 || n % length == 0) {
			return head;
		}

		int i = 1;
		while (i < count) {
			currentNode = currentNode.next;
			i++;
		}

		head2.next = currentNode.next;
		currentNode.next = null;

		System.out.println("head");
		print(head);

		System.out.println("head2");
		print(head2);

		while (head2.next != null) {
			head2 = head2.next;
		}

		System.out.println("head2");
		print(head2);
		head2.next = head;

		System.out.println("finalNode");
		print(finalNode);

		return finalNode.next;
	}

	public static Node<Integer> addTwoNodes(Node<Integer> head, Node<Integer> head2) {

		Node<Integer> dummy = new Node<Integer>(0);
		Node<Integer> node2 = dummy;
		int carry = 0;

		if (head == null) {
			return head2;
		}

		if (head2 == null) {
			return head;
		}

		while (head != null && head2 != null && dummy != null) {
			int sum = head.data + head2.data;

			System.out.println((sum + carry) % 10);
			Node<Integer> node = new Node<Integer>((sum + carry) % 10);
			carry = (sum + carry) / 10;
			System.out.println(carry);
			dummy.next = node;
			dummy = dummy.next;
			head = head.next;
			head2 = head2.next;
		}

		while (head != null && dummy != null) {
			Node<Integer> node = new Node<Integer>(head.data);
			dummy.next = node;
			dummy = dummy.next;
			head = head.next;

		}

		while (head2 != null && dummy != null) {
			Node<Integer> node = new Node<Integer>(head2.data);
			dummy.next = node;
			dummy = dummy.next;
			head2 = head2.next;
		}

		if (carry != 0) {
			Node<Integer> node = new Node<Integer>(carry);
			dummy.next = node;
			dummy = dummy.next;
		}
		return node2.next;
	}

	public static Node<Integer> removeNFromLast(Node<Integer> head, Integer n) {

		Node<Integer> currentNode = head;
		int i = 1;
		int length = count(head);
		int count = length - n;

		if (head == null) {
			return head;
		}

		if (n > length) {
			return head;
		}

		if (n == length) {
			return head.next;
		}

		if (n == 1) {
			while (i < count) {
				currentNode = currentNode.next;
				i++;
			}
			currentNode.next = null;
			return head;
		}

		while (i < count) {
			currentNode = currentNode.next;
			i++;
		}

		currentNode.next = currentNode.next.next;

		return head;
	}

	public static Node<Integer> eleminateSortedDuplicate(Node<Integer> head) {

		if (head == null) {
			return head;
		}

		int length = count(head);

		if (length == 1) {
			return head;
		}

		Node<Integer> t1 = head;
		Node<Integer> t2 = t1.next;

		while (t2 != null) {

			if (t1.data != t2.data) {
				t1.next = t2;
				t1 = t1.next;
			}
			t2 = t2.next;
		}

		t1.next = t2;

		return head;
	}

	public static Node<Integer> deleteSortedDuplicateNode(Node<Integer> head) {

		if (head == null) {
			return head;
		}

		int length = count(head);

		if (length == 1) {
			return head;
		}

		Node<Integer> t1 = head;
		Node<Integer> t2 = t1.next;

		while (t2.next != null) {

			if (t1.data != t2.data && t2.next.data != t2.data) {
				t1.next = t2;
				t1 = t1.next;
			}
			t2 = t2.next;
		}

		t1.next = t2;

		return head;
	}

	public static Node<Integer> insertRecursively(Node<Integer> head, Integer item, Integer index) {

		if (head == null)
			return head;

		if (index == 0) {
			Node<Integer> newNode = new Node<Integer>(item);
			newNode.next = head;
			return newNode;
		}

		head.next = insertionUsingRecursion(head.next, item, index - 1);
		return head;
	}

	public static Node<Integer> deleteRecursively(Node<Integer> head, Integer index) {

		if (head == null)
			return head;

		if (index == 0) {
			return head.next;
		}
		
		head.next = deleteRecursively(head.next, index-1);
		return head;
	}

	public static Node<Integer> reverseRecursively(Node<Integer> head) {
		
//		if ( head == null ) return null;
		
		if ( head == null || head.next == null ) return head;
		
		Node<Integer> smallHead = reverseRecursively(head.next);
		Node<Integer> tail = smallHead;
		
//		while ( newNode != null) {
//			if ( newNode.next == null) {
//				newNode.next = head;
//				newNode.next.next = null;
//				break;
//			}			
//			newNode = newNode.next;	
//		}
		
		
		while ( tail.next != null ) {
			tail = tail.next;
		}
		
		tail.next = head;
		head.next = null;
		return smallHead;
	}
	
	public static DoubleNode reverseRecursivelyBetter(Node<Integer> head) {
		
		DoubleNode answer;
		
		if ( head == null || head.next == null ) {
			answer = new DoubleNode(head, head);
			return  answer;
		}
		
		DoubleNode smallNode = reverseRecursivelyBetter(head.next);
		smallNode.tail.next = head;
		head.next = null;
		answer = new DoubleNode(smallNode.head, head);
		return answer;
	}
	
	public static Node<Integer> reverseRecursivelyBest(Node<Integer> head) {
		
		if ( head == null || head.next == null ) return head;
		
		Node<Integer> smallHead = reverseRecursivelyBest(head.next);
		Node<Integer> reversedTail = head.next;
		reversedTail.next = head;
		head.next = null;
		
		return smallHead;
		
	}

	public static Node<Integer> middleOfLinkedList(Node<Integer> head) {
		
		if ( head == null) return head;
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while ( head != null ) {
			
			if ( fast.next == null ) {
				return slow;
			}
			
			if ( fast.next.next == null) {
				return slow;
			}
			
			slow = slow.next;
			fast = fast.next.next;
			head = head.next;
		}
		
		return slow;
	}
	
	public static Node<Integer> mergeTwoSortedLL(Node<Integer> head1, Node<Integer> head2) {
		
		if ( head1 == null ) {
			return head2;
		}
		
		if ( head2 == null ) {
			return head1;
		}

		Node<Integer> t1 = head1;
		Node<Integer> t2 = head2;
		Node<Integer> head = null;
		Node<Integer> tail = null;
		
		// first work on first element then with other
		if ( t1.data <= t2.data ) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		}
		
		else {
			head = t2;
			tail = t2;
			t2 = t2.next;
		}
		
		while ( t1 != null && t2 != null ) {
			
			if ( t1.data <= t2.data ) {
				tail.next = t1;
				tail = tail.next;
				t1 = t1.next;
			}
			
			else {
				tail.next = t2;
				tail = tail.next;
				t2 = t2.next;
			}
		}
		
		while ( t1 != null ) {
			tail.next = t1;
			break;
		}
		
		while ( t2 != null ) {
			tail.next = t2;
			break;
		}
		
		return head;
		
	}
	
	// 4,6,2,8,3,1,9
	public static Node<Integer> mergeSortUsingLL(Node<Integer> head) {
		
		if ( count(head) == 1 || count(head) == 0 ) {
			return head;
		}
		
		Node<Integer> mid = middleOfLinkedList(head);
		Node<Integer> head1 = head;
		Node<Integer> head2 = mid.next;
		mid.next = null;
		
		Node<Integer> head1Sorted = mergeSortUsingLL(head1);
		Node<Integer> head2Sorted = mergeSortUsingLL(head2);
		
		Node<Integer> sortedHead = mergeTwoSortedLL(head1Sorted, head2Sorted);

		return sortedHead;
	}
	
	public static Node<Integer> swappingLL(Node<Integer> head, Integer index) {
		
		Node<Integer> head1 = head;
		int length = count(head);

		Node<Integer> p1 = null;
		Node<Integer> c1 = null;
		Node<Integer> p2 = null;
		Node<Integer> c2 = null;
		
		int i = index;
		int j = length - index + 1;
		int count = 0;
		
		if ( i == j ) {
			return head;
		}
		
		if ( i > length/2 ) {
			int temp = i;
			i = j;
			j = temp;
		}
		
		while ( head1 != null ) {
			count++;
			
			if ( count < i ) {
				p1 = head1;
			}
			
			if ( count == i ) {
				c1 = head1;
			}
			
			if ( count > i && count < j ) {
				p2 = head1;
			}
			
			if ( count == j ) {
				c2 = head1;
			}

			head1 = head1.next;
		}
		
//		printRecursively(p1);
//        printRecursively(c1);
//        printRecursively(p2);
//        printRecursively(c2);
		
        
//        91 56 48 77 91 96 55 53 68 -1
		if ( i == 1 && length == 2 ) {
            c2.next = c1;
            c1.next = null;
            return c2;
        }
		
		if ( i == 1 ) {
			p2.next = c1;
			c2.next = c1.next;
			c1.next = null;
			return c2;
		}

        if ( j-i == 1 || i-j == 1 ) {
            p1.next = c2;
            c1.next = c2.next;
            c2.next = c1;
        }
        
		else {
			p1.next = c2;
			p2.next = c1;
			Node<Integer> temp = c1.next;
			c1.next = c2.next;
			c2.next = temp;
		}
		
		return head;
	}
	
	@SuppressWarnings("null")
	public static Node<Integer> seperateEvenOdd(Node<Integer> head) {
		
		if( head == null && head.next == null ) {
			return head;
		}
		
		Node<Integer> temp = head;
		Node<Integer> evenHead = null;
		Node<Integer> evenTail = null;
		Node<Integer> oddHead = null;
		Node<Integer> oddTail = null;
		
		while ( temp != null ) {
			
			if ( temp.data % 2 == 0 ) {
				
				if ( evenHead == null && evenTail == null ) {
					evenHead = temp;
					evenTail = temp;
				} else {
					evenTail.next = temp;
					evenTail = temp;
				}
			} else {
				//odd
				if ( oddHead == null && oddTail == null ) {
					oddHead = temp;
					oddTail = temp;
				} else {
					oddTail.next = temp;
					oddTail = temp;
				}
			}
			
			temp = temp.next;
		}
		
		evenTail.next = null;
		oddTail.next = null;
		
//		printRecursively(evenHead);
//		System.out.println();
//		printRecursively(oddHead);
		
		if ( head.data %2 == 0) {
			evenTail.next = oddHead;
			return evenHead;
		}
		
		oddTail.next = evenHead;
		return oddHead;
	}
	
	public ListNode sortList(ListNode head) {
        return null;
    }
 	
	public static void main(String[] args) {

//    	Node<Integer> head = createLinkedList2();
//    	print(head);
//        System.out.println(":::::");
//        printReverseNode(head);
//        System.out.println();
//        System.out.println(":::::");
//        Node<Integer> neew = insertionUsingRecursion(head, 50, 0);
//        print(neew);
//        System.out.println(":::::");
//        Node<Integer> nodww = deletionUsingRecursion(neew, 3);
//        print(nodww);

//    	Node<Integer> head = createLinkedList2();
//    	System.out.println(":::::::");
//    	print(head);
//    	Node<Integer> head2 = createLinkedList();
//    	System.out.println(":::::::");
//    	print(head2);
//    	Node<Integer> head3 = addTwoNodes(head, head2);
//    	System.out.println(":::::::");
//    	print(head3);

//    	Node<Integer> head = createLinkedList();
//    	System.out.println("head");
//    	print(head);

//    	Node<Integer> head = createLinkedList();
//    	System.out.println("head2");
//        print(head2);

//    	Node<Integer> head = createLinkedList();
//    	
//    	Node<Integer> head2 = removeNFromLast(head, 1);
//    	System.out.println("head2");
//        print(head2);

//    	1,1,2,2,3,3,4
//    	Node<Integer> head = createLinkedList3();
//    	System.out.println("head");
//    	print(head);
//    	Node<Integer> head2 = eleminateSortedDuplicate(head);
//    	System.out.println();
//    	System.out.println("head2");
//        print(head2);

		
		
//		Node<Integer> head = createLinkedList3();
//		System.out.println("head");
//		print(head);
//		Node<Integer> result = insertRecursively(head, 3, 1);
//		System.out.println("head2");
//		print(result);
		
		
		
//		Node<Integer> head = createLinkedList3();
//		System.out.println("head");
//		print(head);
//		Node<Integer> result = deleteRecursively(head, 9);
//		System.out.println("head2");
//		print(result);
		
		
//		Node<Integer> head = createLinkedList3();
//		System.out.println("head");
//		print(head);
//		System.out.println();
//		Node<Integer> head2 = reverseRecursively(head);
//		System.out.println("head2");
//		print(head2);
		
		
//		Node<Integer> head = takeInput();
//		System.out.println("head");
//		print(head);
//		System.out.println();
//		DoubleNode head2 = reverseRecursivelyBetter(head);
//		System.out.println("head2");
//		print(head2.head);
		

//		Node<Integer> head = createLinkedList3();
//		System.out.println("head");
//		print(head);
//		System.out.println();
//		Node<Integer> head2 = reverseRecursivelyBest(head);
//		System.out.println("head2");
//		print(head2);
		
		
//		Node<Integer> head = takeInput();
//		System.out.println("head");
//		print(head);
//		System.out.println();
//		Node<Integer> head2 = middleOfLinkedList(head);
//		System.out.println("head2");
//		print(head2);
//		
		
//		Node<Integer> head = takeInput();
//		System.out.println("head");
//		print(head);
//		System.out.println();
//		Node<Integer> head2 = takeInput();
//		System.out.println("head2");
//		print(head2);
//		
//		System.out.println();
//		System.out.println("final output");
//		Node<Integer> finalOutput = mergeTwoSortedLL(head, head2);
//		print(finalOutput);
		
		
//		Node<Integer> head = takeInput();
//		System.out.println("head");
//		printRecursively(head);
//		
//		System.out.println();
//		System.out.println("final output");
//		Node<Integer> finalOutput = mergeSortUsingLL(head);
//		printRecursively(finalOutput);
		
		
		
//		Node<Integer> head = takeInput();
//		System.out.println("head");
//		printRecursively(head);
//		
//		System.out.println();
//		
//		Node<Integer> finalOutput = seperateEvenOdd(head);
//		System.out.println("final output");
//		printRecursively(finalOutput);
		
		
		
		
		
		
		Node<Integer> head = takeInput();
		System.out.println("head");
		printRecursively(head);
		
		System.out.println();
		
		Node<Integer> finalOutput = swappingLL(head, 7);
		System.out.println("final output");
		printRecursively(finalOutput);
		
		
		
		
		
		
//      Node<Integer> head = createLinkedList();
//      print(head);
//      Node<Integer> head2 = deleteHead(head);
//      System.out.println();
//      print(head2);
//      
//      Node<Integer> head2 = increment(head);
//      print(head2);
//      int countHead = count(head2);
//      System.out.println("countHead = " + countHead);
//
//      int item = printIth(head , 4);
//      System.out.println("item = " + item);
//
//
//      Node<Integer> head22 = takeInput();
//      print(head22);
//
//      System.out.println("/");
//
//      addElementAtIndex(head2, 10, 0);
//      
//      print(head2);

//        Node<Integer> newHead = addElementAtIndexEasy(head, 55, valuePosition( head, 40));
//        print(newHead);

//        int pos = valuePosition(head, 40);
//        
//        System.out.println(pos); 

		// delete tail
//        System.out.println();
//        Node<Integer> head2 = deleteTail(head);
//        print(head2);

	}

}
