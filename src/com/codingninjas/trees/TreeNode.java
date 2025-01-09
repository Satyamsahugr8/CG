package com.codingninjas.trees;

import java.util.ArrayList;

public class TreeNode<T> {
	
	public T data;
	public ArrayList<TreeNode<T>> children;
	
	public TreeNode(T data) {
		super();
		this.data = data;
		this.children = new ArrayList<>();
	}

}
