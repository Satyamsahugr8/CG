package com.codingninjas.treesbinarytrees;

public class BinaryTreeNode<T> {
	
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
