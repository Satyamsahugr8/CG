package com.codingninjas.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2  = new Stack<Integer>();
	int size;
	

	public QueueUsingStack() {
		super();
		size = 0;
	}

	public void enQueue(int element) {
		stack1.add(element);
		size++;
	}
	
	public Integer deQueue() throws QueueEmptyException {
		
		if ( !stack1.isEmpty() ) {
			
			int size = stack1.size();
			for (int i = 1; i < size; i++) {
				stack2.add(stack1.pop());
			}
			
			//last element
			int store = stack1.pop();
				
			while ( !stack2.isEmpty() ) {
				stack1.add(stack2.pop());
			}
			
			size--;
			return store;
		}
		
		throw new QueueEmptyException();
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Integer front() throws QueueEmptyException {
		
		if ( !stack1.isEmpty() ) {
			
			for (int i = 1; i < stack1.size(); i++) {
				stack2.add(stack1.pop());
			}
			
			return stack1.peek();
		}
		
		throw new QueueEmptyException();
	}

	void printStack1() {
		System.out.println(stack1);
	}

	void printStack2() {
		System.out.println(stack2);
	}


	
}
