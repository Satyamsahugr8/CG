package com.codingninjas.linkedlist;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2 child;

    ListNode2() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode2(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode2(int data1, ListNode2 next1, ListNode2 next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}

public class FlattenLL {

	public static void main(String[] args) {
		

	}
	
	public static ListNode2 mergeTwoLists(ListNode2 head1, ListNode2 head2) {
        
        if ( head1 == null ) {
			return head2;
		}
		
		if ( head2 == null ) {
			return head1;
		}

		ListNode2 t1 = head1;
		ListNode2 t2 = head2;
		ListNode2 mainHead = null;
		ListNode2 tail = null;
		
		// first work on first element then with other
		if ( t1.val <= t2.val ) {
			mainHead = t1;
			tail = t1;
			t1 = t1.child;
		}
		
		else {
			mainHead = t2;
			tail = t2;
			t2 = t2.child;
		}
		
		while ( t1 != null && t2 != null ) {
			
			if ( t1.val <= t2.val ) {
				tail.child = t1;
				tail = tail.child;
				t1 = t1.child;
			}
			
			else {
				tail.child = t2;
				tail = tail.child;
				t2 = t2.child;
			}
		}
		
		while ( t1 != null ) {
			tail.child = t1;
			break;
		}
		
		while ( t2 != null ) {
			tail.child = t2;
			break;
		}
		
		return mainHead;
    }
	
	public static ListNode2 flattenLinkedList(ListNode2 head) {
		
		if ( head == null || head.next == null ) {
			return head;
		}
		
		ListNode2 prev = head;
		ListNode2 curr = prev.next;
		ListNode2 nextNode = prev;
		
		while ( curr != null ) {
			nextNode = curr.next;
			prev = mergeTwoLists(prev, curr);
			curr = nextNode;
		}
		
		return prev;
    }

}



