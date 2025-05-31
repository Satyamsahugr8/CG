package com.codingninjas.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> extraQueue = new LinkedList<Integer>();
	
	public void push(int element) {
		
		if( !queue.isEmpty() ) {
			while ( !queue.isEmpty() ) {
				extraQueue.add(queue.poll());
			}	
		}
		
		queue.add(element);
		
		while ( !extraQueue.isEmpty() ) {
			queue.add(extraQueue.poll());
		}
		
	}

	public int top() throws StackEmptyException {
		
		if ( isEmpty() ) {
			throw new StackEmptyException();
		}
		
		return queue.peek();
	}

	public int pop() throws StackEmptyException {
		
		if ( isEmpty() ) {
			throw new StackEmptyException();
		}
		
		return queue.poll();
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return size() == -1;
	}
	
	public void print() {
		System.out.print("stack : ");
		System.out.print(queue.toString() + " ");
//		System.out.print("]");
		System.out.println();
	}

}
