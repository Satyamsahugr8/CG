package com.codingninjas.treesbinarytrees;

public class BSTUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		bst.root = BinaryTreeUse.takeInputLevelWise();
		
		//1
		System.out.println();
		BinaryTreeUse.printBinaryTreeBest(bst.root);
		
		
		//2
		System.out.println();
		System.out.print("hasData : ");
		System.out.println(bst.hasData(9));
		
		//3
		System.out.println();
		System.out.println("insert : ");
		bst.insertData(7);
		System.out.println();
		BinaryTreeUse.printBinaryTreeBest(bst.root);
		
		//4
		System.out.println();
		System.out.println("max : " + bst.maximum(bst.root.left));
		
		//5
		System.out.println();
		System.out.println("delete : ");
		bst.deleteData(43);
		BinaryTreeUse.printBinaryTreeBest(bst.root);

	}

}
