package com.codingninjas.treesbinarytrees;

public class BST {
	
	public BinaryTreeNode<Integer> root;
	
	public boolean hasData(int data) {
		return helperHasData(this.root, data);
	}
	
	private boolean helperHasData(BinaryTreeNode<Integer> root, int data) {
		
		if ( root == null ) {
			return false;
		}
		
		if ( data == root.data ) {
			return true;
		}
		
		else if ( data < root.data ) {
			return helperHasData(root.left, data);
		}
		
		else {
			return helperHasData(root.right, data);
		}
 		
	}
	
	public void insertData(int data) {
		helperInsertData(this.root, data);
	}
	
	private BinaryTreeNode<Integer> helperInsertData(BinaryTreeNode<Integer> root, int data) {
		
		if ( root == null ) {
			BinaryTreeNode<Integer> newTreeNode = new BinaryTreeNode<Integer>(data);
			root = newTreeNode;
			return root;
		}
		
		if ( data < root.data ) {
			root.left = helperInsertData(root.left, data);
		}
		
		if ( data > root.data ) {
			root.right = helperInsertData(root.right, data);
		}
		
 		return root;
	}
	
	public void deleteData(int data) {
		helperDeleteData(this.root, data);
	}

	private BinaryTreeNode<Integer> helperDeleteData(BinaryTreeNode<Integer> root, int data) {
		
		if ( root == null ) return null;
		
		if ( root.data == data && root.left == null && root.right == null ) return null;
		
		else if ( root.data == data && root.right == null ) {
			return root.left;
		}
		
		else if ( root.data == data && root.left == null ) {
			return root.right;
		}
		
		// root.data == data
		else if ( root.data == data ) {
			// find largest from left or smallest from right
			// largest
			int leftLargest = maximum(root.left);
			root.data = leftLargest;
			root.left = helperDeleteData(root.left, leftLargest);
		}
		
		if ( data < root.data ) {
			root.left = helperDeleteData(root.left, data);
		}
		
		if ( data > root.data ) {
			root.right = helperDeleteData(root.right, data);
		}
		
		return root;
	}
	
	public static int maximum(BinaryTreeNode<Integer> left) {

		if (left == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(left.data, Math.max(maximum(left.left), maximum(left.right)));
		
	}

}
