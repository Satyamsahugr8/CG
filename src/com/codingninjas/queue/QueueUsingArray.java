package com.codingninjas.queue;

public class QueueUsingArray {
	
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void doubleCapacity() {
		
		int[] temp = data;
		data = new int[ 2 * data.length ];
		
		int index = 0;
		for (int i = front; i < temp.length; i++) {
			data[index++] = temp[i];
		}
		
		for (int i = 0; i < front -1; i++) {
			data[index++] = temp[i];
		}
		
		front = 0;
		rear = temp.length -1 ;
	}

	
	public void enQueue(int element) throws QueueFullException {
		
		if ( size == data.length ) {
			doubleCapacity();
		}
		
		if ( size == 0 ) {
			front = 0;
		}
		
		rear++;
		data[rear] = element;
		size++;
		
	}
	
	public int deQueue() throws QueueEmptyException {
		
		if ( !isEmpty() ) {
			
			int temp = data[front];
			data[front] = 0;
			front++;
			size--;
			
			if ( size == 0 ) {
				front = -1;
				rear = -1;
			}
			
			return temp;
		}
		
		throw new QueueEmptyException();
	}
	
	public int front() throws QueueEmptyException {
		if ( !isEmpty()) return data[front];
		throw new QueueEmptyException();
	}
	
	public void print() {
		System.out.print("queue : [ ");
		for (int i = front; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
}
