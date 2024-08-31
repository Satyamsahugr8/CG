package com.leetcode.linkedlist.notes;

import java.util.Scanner;

public class LinkedClassUse {

    public static Node<Integer> createLinkedList() {

        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }
    
    public static Node<Integer> createLinkedList2() {
      Node<Integer> n4 = new Node<>(40);
      Node<Integer> n3 = new Node<>(30, n4);
      Node<Integer> n2 = new Node<>(20, n3);
      Node<Integer> n1 = new Node<>(10, n2);
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

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
            } 
            
            else {
                Node<Integer> tail = head;
                
                while(tail.next != null) {
                    tail = tail.next;
                }
                
                //connecting new element into linkedList
                tail.next = currentNode;
            }

            data = scanner.nextInt();
            
        }

        scanner.close();
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
    
//    public static <T> T printGenericIth(Node<T> head, Integer index) {
//        Node<T> temp = head;
//        int count = 0;
//        while (temp != null) {
//            if (count++ == index) {
//                return temp.data;
//            }
//            temp = temp.next;
//        }
//        return null;
//    }
    

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
        
        if ( index > maximumCount ) {
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
    
    
    //	1 -> 2 -> 3 -> 4
	public static Node<Integer> delete(Node<Integer> head, int index) {
		
		if ( head == null ) {
			return head;
		}
		
		if ( head.next == null ) {
			head = null;
			return head;
		}
		
		Node<Integer> temp = head;
		int i = 0;
		while ( i < (index -1) ) {
			temp = temp.next;
			i++;
		}
		
		// this means we reacted our target position
		temp.next = temp.next.next;
		
	   	return head;
	}

	public static int valuePosition( Node<Integer> head, int value) {
		
		Node<Integer> temp = head;
		int position = 0;
		while ( temp != null ) {
			position++;
			if ( temp.data == value) {
				return position;
			}
			temp = temp.next;
		}
		return -1;
	}
	
	public static Node<Integer> deleteByValue( Node<Integer> head, int value) {
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

    public static void main(String[] args) {

//        Node<Integer> head = createLinkedList();
//        print(head);
//        Node<Integer> head2 = deleteHead(head);
//        System.out.println();
//        print(head2);
//        
//        Node<Integer> head2 = increment(head);
//        print(head2);
//        int countHead = count(head2);
//        System.out.println("countHead = " + countHead);
//
//        int item = printIth(head , 4);
//        System.out.println("item = " + item);
//
//
//        Node<Integer> head22 = takeInput();
//        print(head22);
//
//        System.out.println("/");
//
//        addElementAtIndex(head2, 10, 0);
//        
//        print(head2);
    	
    	
    	
    	
    	Node<Integer> head = createLinkedList2();
        print(head);
//        Node<Integer> newHead = addElementAtIndexEasy(head, 55, valuePosition( head, 40));
//        print(newHead);
         
        
//        int pos = valuePosition(head, 40);
//        
//        System.out.println(pos); 
        
    
      //delete tail
//        System.out.println();
//        Node<Integer> head2 = deleteTail(head);
//        print(head2);
        

    }
    
}
