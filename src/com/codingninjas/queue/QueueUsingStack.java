package com.codingninjas.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	

	public QueueUsingStack() {
		stack1 = new Stack<Integer>();
		stack2  = new Stack<Integer>();
	}

	public void enQueue(int element) {
		
		if( !stack1.isEmpty() ) {
			while ( !stack1.isEmpty() ) {
				stack2.add(stack1.pop());
			}	
		}
		
		stack1.add(element);
		
		while ( !stack2.isEmpty() ) {
			stack1.add(stack2.pop());
		}
		
		
	}
	
	public Integer deQueue() throws QueueEmptyException {
		
		if ( stack1.isEmpty() ) {
			return -1;
		}
		
		return stack1.pop();
	}
	
	public int size() {
		
		if ( stack1.size() == 0 ) return -1;
		return stack1.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Integer front() throws QueueEmptyException {
		
		if ( stack1.isEmpty() ) {
			return -1;
		}
		
		return stack1.peek();
	}

	void print() {
		System.out.println(stack1);
	}

}
