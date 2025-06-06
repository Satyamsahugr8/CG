package com.codingninjas.stack;

public class StackUsingLL<T> {
	
	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size; 
	}
	
	public T top() throws StackEmptyException {
		if ( size() == 0 ) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public boolean isEmpty() {
		if ( size != 0 ) {
			return false;
		}	
		return true;
	}
	
	public T pop() {
		Node<T> temp = head;
		
		if (temp == null) {  // Check if queue is empty
            return temp.data;
		}

        T data = temp.data;
		temp = temp.next;
		size--;
		
		return data;
	}
	
	public void push(T element) {
		
		if ( head == null ) {
			Node<T> node = new Node<T>(element);
			head = node;
			size++;	
		}
		
		else {
			Node<T> node = new Node<T>(element);
			node.next = head;
			head = node;
			size++;
		}
	}
	
	public void print() {
		Node<T> temp = head;
		int counter = 0;
		while (temp != null) {
			counter++;
			System.out.println("head" + counter + " = " + temp.data);
			temp = temp.next;
		}
	}
	
}
