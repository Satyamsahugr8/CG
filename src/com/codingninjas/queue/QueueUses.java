package com.codingninjas.queue;

import com.codingninjas.stack.Node;
import com.codingninjas.stack.StackEmptyException;
import com.codingninjas.stack.StackFullException;

public class QueueUses {
	
	public static void main(String[] args) throws StackEmptyException, StackFullException {
		
//		 queueUsingArray();
//		 queueUsingLL();
		 queueUsingTwoStack();
	}
	
	private static void queueUsingTwoStack() throws StackEmptyException {
		
		QueueUsingStack queue = new QueueUsingStack();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		
		System.out.println(queue.size);
		System.out.println(queue.isEmpty());
		System.out.println(queue.deQueue());
		queue.printStack1();
		
		queue.enQueue(60);
		System.out.println(queue.size);
		queue.printStack1();
		
		System.out.println(queue.deQueue());
		queue.printStack1();
		
	}

	public static void queueUsingArray() throws StackFullException, StackEmptyException {
		QueueUsingArray queue = new QueueUsingArray();
		queue.enQueue(10);
		System.out.println(queue.front());
		queue.print();
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		System.out.println(queue.front());
		queue.print();
		System.out.println(queue.deQueue());
		System.out.println(queue.size());
		queue.print();
	}

	public static void queueUsingLL() throws StackFullException, StackEmptyException {
		QueueUsingLL<Integer> queue = new QueueUsingLL<Integer>();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		System.out.println(queue.front());
		queue.print();
		System.out.println(queue.deQueue());
		System.out.println(queue.size());
		queue.print();
	}

}
