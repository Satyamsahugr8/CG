package com.codingninjas.linkedlist;

public class Node<T> {
    
	public T data;
    public Node<T> next;

    public Node() {
        super();
    }
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
}
