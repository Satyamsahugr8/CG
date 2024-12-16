package com.codingninjas.linkedlist;

public class Node<T> {
    
	T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
//        this.next = null;
    }
    
    Node(T data2, Node<T> next) {
        this.data = data2;
        this.next = next;
    }


}
