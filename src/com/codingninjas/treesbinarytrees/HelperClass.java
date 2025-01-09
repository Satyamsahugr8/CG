package com.codingninjas.treesbinarytrees;

import com.codingninjas.linkedlist.Node;

public class HelperClass {

}

class BinaryTreeWithParent<T>{
	BinaryTreeNode<T> root;
	BinaryTreeNode<T> parent;
	public BinaryTreeWithParent(BinaryTreeNode<T> root, BinaryTreeNode<T> parent) {
		super();
		this.root = root;
		this.parent = parent;
	}
	
}

class BalancedTreeReturn {
	int height;
	boolean isBalanced;
	
	public BalancedTreeReturn(int height, boolean isBalanced) {
		super();
		this.height = height;
		this.isBalanced = isBalanced;
	}
}

class Pair<T, V> {
	T diameter;
	V height;
	
	public Pair(T diameter, V height) {
		super();
		this.diameter = diameter;
		this.height = height;
	}
}

class Pairr<T, V> {
	T first;
	V second;
	
	public Pairr(T diameter, V height) {
		super();
		this.first = diameter;
		this.second = height;
	}
}


class Pairrr<T, V, S> {
	T first;
	V second;
	S third;
	
	public Pairrr(T diameter, V height, S third) {
		super();
		this.first = diameter;
		this.second = height;
		this.third = third;
	}
}

class Pairrrr<T, V, S, R> {
	T first;
	V second;
	S third;
	R fouth;
	
	public Pairrrr(T diameter, V height, S third, R fouth) {
		super();
		this.first = diameter;
		this.second = height;
		this.third = third;
		this.fouth = fouth;
	}
}

class DoubleNode<T> {
	Node<T> head;
	Node<T> tail;
	
	public DoubleNode(Node<T> head, Node<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public DoubleNode() {
	}
	
}

