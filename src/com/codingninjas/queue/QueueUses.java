package com.codingninjas.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueUses {
	
	public static void main(String[] args) throws QueueEmptyException, QueueFullException {
		
//		 queueUsingArray();
//		 queueUsingLL();
		 queueUsingTwoStack();
	}
	
	
	private static void queueUsingTwoStack() throws QueueEmptyException {
		
		QueueUsingStack queue = new QueueUsingStack();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.deQueue());
		queue.print();
		
		queue.enQueue(60);
		System.out.println(queue.size());
		queue.print();
		
		System.out.println(queue.deQueue());
		queue.print();
		
	}

	public static void queueUsingArray() throws QueueFullException, QueueEmptyException {
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

	public static void queueUsingLL() throws QueueFullException, QueueEmptyException {
		QueueUsingLL<Integer> queue = new QueueUsingLL<Integer>();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.enQueue(70);
		queue.enQueue(80);
		queue.enQueue(90);
		queue.enQueue(100);
		queue.enQueue(60);
		System.out.println(queue.front());
		queue.print();
		System.out.println(queue.deQueue());
		System.out.println(queue.size());
		queue.print();
	}
	
	public static void reverseQueue( QueueUsingLL<Integer> queue, QueueUsingLL<Integer> helper) {
		
	}
	
	public static Queue<Integer> reverseQueue(Queue<Integer> q) {
		  
	      // Write your code here.
	      Stack<Integer> helper = new Stack<>();

	      while (!q.isEmpty()) {
	        helper.push(q.remove());
	      }

	      while(!helper.isEmpty()) {
	        q.add(helper.pop());
	      }
	      return q;
	    }

}
