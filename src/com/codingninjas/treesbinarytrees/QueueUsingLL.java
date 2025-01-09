package com.codingninjas.treesbinarytrees;

import com.codingninjas.linkedlist.Node;
import com.codingninjas.queue.QueueEmptyException;

public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	
	
	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(T element) {
		
		Node<T> elem = new Node<T>(element); 
		
		if ( size == 0 ) {
			front = elem;
		} else {
			rear.next = elem;
		}
		
		rear = elem;
		size++;
		
	}
	
	public T front() throws QueueEmptyException {
		if ( size == 0 ) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	public T deQueue() {
		Node<T> temp = front;
		front = front.next;
		size--;
		return temp.data;
	}
	
	public void print() {
		Node<T> temp = front;
		int counter = 0;
		while (temp != null) {
			counter++;
			System.out.println("head" + counter + " = " + temp.data);
			temp = temp.next;
		}
	}
	
}
