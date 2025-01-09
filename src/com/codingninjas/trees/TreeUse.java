package com.codingninjas.trees;

import java.util.Scanner;

@SuppressWarnings({"resource", "unused"})
public class TreeUse {

	public static void main(String[] args) {
		
//		buildTree();
		
		// 4 2 3 2 2 0 1 0 5 1 3 0
//		Scanner sc = new Scanner(System.in);
//		TreeNode<Integer> root = takeInputRecursively(sc);
//		print(root);
//		printRecursiveImproved(root);
		
		// 1 2 2 3 2 4 5 1 6 0 0 0
		TreeNode<Integer> root = takeInputLevelVise();
		printRecursiveImproved(root);
//		System.out.println(numOfNodes(root));
//		System.out.println(largestNode(root));
//		System.out.println(findHeight(root));
//		printKDepthNode(root, 2);
		System.out.println();
		System.out.println("countLeaf : "+ countNoOfLeaf(root));
		
		// print with level-wise
		System.out.println("Print-levelwise");
		printLevelwise(root, 0);
		
		System.out.println();
		
		// print pre-order
		System.out.println("Pre-order");
		preOrder(root);
		
		System.out.println();
		
		// print post-order
		System.out.println("Post-order");
		postOrder(root);
		
		System.out.println();
		
		
	}

	private static void printLevelwise(TreeNode<Integer> root, int k) {
		
		if ( root == null ) {
			return;
		}
	
		if ( k == 0 ) {
			System.out.print(root.data + " ");
		}
		
		if ( !root.children.isEmpty() ) {
			for (int i = 0; i < root.children.size(); i++) {
				System.out.print(root.children.get(i).data + " ");
			}
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			printLevelwise(root.children.get(i), k+1);
		}
		
	}

	private static void postOrder(TreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			postOrder(root.children.get(i));
		}
		
		System.out.print(root.data + " ");
		
	}

	private static void preOrder(TreeNode<Integer> root) {

		if ( root == null ) {
			return;
		}
		
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			preOrder(root.children.get(i));
		}
	
	}

	private static int countNoOfLeaf(TreeNode<Integer> root) {
	
		if ( root == null ) {
			return 0;
		}
		
		int count = 0;
		int countLeaf = 0;
		
		if ( root.children.isEmpty() ) {
			return ++count;
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			countLeaf += countNoOfLeaf(root.children.get(i));
		}
		
		return countLeaf;
	}

	private static TreeNode<Integer> takeInputLevelVise() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data : ");
		int rootData = sc.nextInt();
		
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enQueue(root);
		
		while ( !pendingNodes.isEmpty() ) {
			TreeNode<Integer> frontNode = pendingNodes.deQueue();
			System.out.println("Enter number of children of " + frontNode.data);
			int numChildren = sc.nextInt();
			
			for (int i = 0; i < numChildren; i++) {
				System.out.println("Enter " + (i+1) + "th child of " + frontNode.data );
				int child = sc.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
				frontNode.children.add(childNode);
				pendingNodes.enQueue(childNode);
			}
		}
		
		return root;
	}

	private static void buildTree() {
		
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		TreeNode<Integer> c1 = new TreeNode<Integer>(3);
		TreeNode<Integer> c2 = new TreeNode<Integer>(5);
		TreeNode<Integer> c11 = new TreeNode<Integer>(2);
		TreeNode<Integer> c12 = new TreeNode<Integer>(1);
		TreeNode<Integer> c21 = new TreeNode<Integer>(3);
		
		root.children.add(c1);
		root.children.add(c2);

		c1.children.add(c11);
		c1.children.add(c12);
		
		c2.children.add(c21);
		
		print(root);
	}
	
	private static void print(TreeNode<Integer> root) {
		
		if ( root == null ) {
			System.out.println("null");
			return;
		}
		
		System.out.print(" " + root.data + " ");
		
		int i = 0;
		System.out.print("no of children :" + root.children.size() + ",");
		while( i < root.children.size() ) {
			print(root.children.get(i));
			i++;
		}
//		System.out.println();
		
	}

	private static void printRecursiveImproved(TreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		System.out.print(root.data + " : ");
		
		for (int i = 0; i < root.children.size(); i++) {
			System.out.print(root.children.get(i).data + " ");
		}
		
		System.out.println();
		
		// call for small tree or child tree
		for (int i = 0; i < root.children.size(); i++) {
			printRecursiveImproved(root.children.get(i));
		}
	}
	
	private static TreeNode<Integer> takeInputRecursively(Scanner sc) {
		
		System.out.println("Enter node data : ");
		int n = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = sc.nextInt();
		
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInputRecursively(sc);
			root.children.add(child);
		}
		
		return root;
	}
	
	private static int numOfNodes(TreeNode<Integer> root) {
		
		if ( root == null ) {
			return 0;
		}
		
		int count = 1;
		
		// where is base case ?
		// base case from this below for loop
		// if there is no child root
		
		for (int i = 0; i < root.children.size(); i++) {
			count += numOfNodes(root.children.get(i));
		}
		return count;
	}
	
	private static int largestNode(TreeNode<Integer> root ) {
		
		int largestData = root.data;
		
		for (int i = 0; i < root.children.size(); i++) {
			int smallLargest = largestNode(root.children.get(i));
			if (smallLargest > largestData) {
				largestData = smallLargest;
			}
		}
		
		return largestData;
	}
	
	private static int findHeight(TreeNode<Integer> root) {

		if ( root == null ) {
			return 0;
		}
		
		int height = 1;
		
		if (root.children.size() == 0 ) {
			return height;
		}
		
		int childMaxHeight = 1;
		for (int i = 0; i < root.children.size(); i++) {
			int smallLargest = findHeight(root.children.get(i));
			if ( smallLargest > childMaxHeight ) {
				childMaxHeight = smallLargest;
			}
		}
		
		height += childMaxHeight;
		
		return height;
	}
	
	private static void printKDepthNode(TreeNode<Integer> root, Integer k) {
		
		if ( root == null ) {
			return;
		}
		
		if ( k == 0 ) {
			System.out.print(root.data + " ");
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			printKDepthNode(root.children.get(i), k-1);
		}
		
	}
	
	
	
	
	
}
