package com.codingninjas.treesbinarytrees;


class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.right = right;
	}
}

public class BTUseSolution {

	public static void main(String[] args) {
		
		System.out.println(Integer.parseInt("401"));
		
		BTUseSolution bt = new BTUseSolution();
		
		TreeNode root = bt.recoverFromPreorder("1-401--349---90--88");
		printBinaryTreeBest(root);

	}
	
	public TreeNode recoverFromPreorder(String traversal) {
		
		TreeNode root = new TreeNode(Integer.parseInt(traversal.charAt(0) + ""));
		TreeNode answer = root; 
		callRoot(traversal, 0, root, 1);
		return answer;
		
    }
	
	public static TreeNode callRoot(String charr, int i, TreeNode root, int d) {
		return null;
	}
	
	public static void printBinaryTreeBest(TreeNode root) {
		
		if ( root == null ) {
			return;
		}
		
		System.out.print(root.val + ": ");
		
		if ( root.left != null ) {
			System.out.print( "L"+root.left.val + ",");
		}
		
		if ( root.right != null ) {
			System.out.print( "R"+ root.right.val + ",");
		}
		
		System.out.println();
		printBinaryTreeBest(root.left);
		printBinaryTreeBest(root.right);
		

	}

}
