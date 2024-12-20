package com.codingninjas.queue;

import java.util.Stack;

import com.codingninjas.stack.StackEmptyException;

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
	
	public Integer deQueue() throws StackEmptyException {
		
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
		
		throw new StackEmptyException();
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Integer front() throws StackEmptyException {
		
		if ( !stack1.isEmpty() ) {
			
			for (int i = 1; i < stack1.size(); i++) {
				stack2.add(stack1.pop());
			}
			
			return stack1.peek();
		}
		
		throw new StackEmptyException();
	}

	void printStack1() {
		System.out.println(stack1);
	}

	void printStack2() {
		System.out.println(stack2);
	}


	
}
