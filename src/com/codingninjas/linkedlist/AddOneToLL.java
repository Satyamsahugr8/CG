package com.codingninjas.linkedlist;

public class AddOneToLL {

	public static void main(String[] args) {
		
		addOne();

	}
		
	public static void addOne() {
		
		LinkedClassUse ll = new LinkedClassUse();
		Node<Integer> node = LinkedClassUse.takeInput();
		
//		Node<Integer> answer = addOneToLast(node);

		PP answer = addOneToLast2(node, true);
		
		ll.printRecursively(answer.node);
		
    }
	
	public static Node<Integer> addOneToLast(Node<Integer> head) {
		
		Node<Integer> temp = head;
		
		while ( temp.next != null ) {
			temp = temp.next;
		}
		
		temp.data += 1;
		
		return head;
		
    }
	
	public static PP addOneToLast2(Node<Integer> head, boolean b) {
		
		Node<Integer> temp = head;
		int carry = 0;
		
		if ( temp.next == null ) {
			
			temp.data += 1;
			
			if ( temp.data == 10 ) {
				temp.data = 0;
				carry = 1;
				return new PP(temp, carry);
			}
			
			return new PP(temp, carry);
		}
		
		// small call 
		PP smallCall = addOneToLast2(temp.next, false);
		
		temp.next = smallCall.node;
		temp.data += smallCall.carry;
		
		if ( temp.data == 10 ) {
			temp.data = 0;
			carry = 1;
		}
		
		if ( !b ) return new PP(temp, carry);
		
		else {
			
			if ( carry == 1 ) {
				Node<Integer> newNode = new Node<Integer>(1);
				newNode.next = temp;
				carry = 0;
				
				return new PP(newNode, carry);
			}
			
		}
		
		return new PP(temp, carry);
    }

}

class PP {
	
	Node<Integer> node;
	int carry;
	
	public PP(Node<Integer> node, int carry) {
		super();
		this.node = node;
		this.carry = carry;
	}
	
}
