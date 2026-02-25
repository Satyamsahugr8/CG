package com.codingninjas.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> node = LinkedClassUse.takeInput();
		LinkedClassUse.printRecursively(node);
		System.out.println();
		boolean ans = hasCycle(node);
		
		System.out.println(ans);
		

	}
	
	 public static boolean hasCycle(Node<Integer> head) {
         
		 Node<Integer> temp = head;
         Map<Node<Integer>, Integer> map = new HashMap<>();	
         
         // Traverse through array elements and
         // count frequencies
         while ( temp != null ) {	
             
        	 if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
                return true;
             }
        	 
             else {
                map.put(temp, 1);
                temp = temp.next;
             }
        	 
         }
         
         return false;
     }


    // using slow and fast pointer
    public boolean hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if( slow == fast ) {
                return true;
            }
        }
        return false;
    }
    
    
    
    public Node<Integer> findStartingPoint(Node<Integer> head) {
    	
    	Node<Integer> temp = head;
        Map<Node<Integer>, Integer> map = new HashMap<>();	
        
        // Traverse through array elements and
        // count frequencies
        while ( temp != null ) {	
            
       	 if (map.containsKey(temp)) {
                return temp;
            }
       	 
            else {
                map.put(temp, 1);
                temp = temp.next;
            }
       	 
        }
    	
    	return null;
    	
    }
    
 // using slow and fast pointer
    public Node<Integer> findStartingPoint2(Node<Integer> head) {

    	Node<Integer> slow = head;
    	Node<Integer> fast = head;

        while( fast != null && fast.next != null ){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if( slow == fast ){

                slow = head;

                while ( slow != fast ) {

                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }

        }

        return null;
    }

}
