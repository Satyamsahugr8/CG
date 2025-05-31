package com.codingninjas.stack;

public class StackUsingArray {
	
	private int[] data;
//	private int maximum;
	private int topIndex;
	
	
	public StackUsingArray() {
		super();
		data = new int[10];
//		maximum = size;
		topIndex = -1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
//		maximum = size;
		topIndex = -1;
	}

//	public void push(int s) throws StackFullException {
//		
//		if( topIndex >= maximum ) {
//			throw new StackFullException();
//		}
//		
//		topIndex++;
//		data[topIndex] = s;
//	}
	
	public void push(int s) {
		
		if( topIndex == data.length - 1 ) {
			doubleCapacity();
		}
		
		topIndex++;
		data[topIndex] = s;
	}

	private void doubleCapacity() {
		
		int[] temp = data;
		data = new int[ 2 * data.length ];
		
		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}

	public int top() throws StackEmptyException {
		
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		
		return data[topIndex];
	}

	public int pop() throws StackEmptyException {
		
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		int returnValue = data[topIndex];
		data[topIndex] = 0;
		topIndex--;
		return returnValue;
	}

	public int size() {
		return topIndex + 1;
	}

	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	public void print() {
		System.out.print("stack : [ ");
		for (int i = 0; i < size(); i++) {
			System.out.print(data[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

}
