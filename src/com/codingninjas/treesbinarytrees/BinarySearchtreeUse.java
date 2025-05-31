package com.codingninjas.treesbinarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.codingninjas.linkedlist.LinkedClassUse;
import com.codingninjas.linkedlist.Node;
import com.codingninjas.stack.StackEmptyException;
import com.codingninjas.stack.StackUsingLL;

@SuppressWarnings({ "unused" })
public class BinarySearchtreeUse {

	public static void main(String[] args) {

		// 0 input tree
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println();
		BinaryTreeUse.printBinaryTreeBest(root);

		// 1
//		System.out.println("Enter element for search : ");
//		Scanner sc = new Scanner(System.in);
//		int element = sc.nextInt();
//		BinaryTreeNode<Integer> bst = searchBST(root, element);
//		System.out.println("searchInSortedBinarySearchtree : ");
//		BinaryTreeUse.printBinaryTreeBest(bst);

		// 2
//		System.out.println();
//		System.out.print("search is range :");
//		printInRange(root, 5, 6);
//
//		//3
//		System.out.println();
//		int summ = rangeSumBST(root, 5, 6);
//		System.out.print("sum in range : ");
//		System.out.println(summ);
		
		// 4.1 4.2
		// testing minimum and maximum
		System.out.println();
//		System.out.println("maximum of root : " + maximum(root));
//
//		System.out.println();
//		System.out.println("minimum of root : " + minimum(root));
//		
//		// 4.3
//		System.out.println();
//		System.out.println("checkBST : " + checkBSTBest(root));
//		
//		// 5
//		Pairrr<Boolean, Long, Long> s = isBST(root);
//		System.out.println("isBST : " + s.first);

		// DONE: left question and assignment question
		// TUF+
		
		// 6
		// sorted Array to Binary completed tree
//		System.out.println();
//		int[] array = {1,2,3,4,5,6,7};
//		BinaryTreeNode<Integer> rootq = sortedArrayToBinaryTree(array, 0, array.length - 1);
//		System.out.println("Sorted array to binaryTree creatation : ");
//		BinaryTreeUse.printBinaryTreeBest(rootq);
//		
//		// 6
//		//Binary Tree to linkedList	
//		System.out.println();
//		DoubleNode<Integer> doub = binaryTreeToLinkedList(root);
//		Node<Integer> nodee = doub.head;
//		System.out.println("BT to linkedlist is : ");
//		LinkedClassUse.printRecursively(nodee);
//		
//		// TODO:
//		//7
//		//replace with sum of greater nodes
////		int sum = 0;
////		int sss = replaceSum(root, sum);
////		System.out.println(sss);
////		System.out.println("replace with greatest sum : ");
////		BinaryTreeUse.printBinaryTreeBest(root);
//		
//		//8
//		// LevelWise linkedList
		List<Node<Integer>> node = levelWiseBestReturnLinkedListNode(root);
		System.out.println();
		System.out.print("list of linkedListNode : ");
		
		for (Node<Integer> node2 : node) {
			LinkedClassUse.printRecursively(node2);
		}
//		
//		//9
//		// Largest BST
//		System.out.println();
//		System.out.print("isBSTMaxHeight : ");
//		Pairrrr<Boolean, Integer, Integer, Integer> pyar = isBSTMaxHeight(root);
//		System.out.println(pyar.fouth);
//		
//		//10 
//		//largest size of BST
//		System.out.println();
//		System.out.print("isBSTMaxHeight : ");
//		Pairrrr<Boolean, Integer, Integer, Integer> pyare = isBSTMaxSize(root);
//		System.out.println(pyare.fouth);
//		
//		//11
//		//DONE : Pair sum
//		// first approach put all node data to form a  sorted Array and then traverse on array 
//		// with out using extra space use in-order and reverse in-order
//		System.out.println();
//		System.out.println();
//		boolean s = pair(root, 28);
//		System.out.println("s : " + s);
//		
//		//12
////		System.out.println();
////		System.out.println("pair : ");
////		ArrayList<ArrayList<Integer>> pair = pairReturn(root, 28);
////		
////		for (ArrayList<Integer> arrayList : pair) {
////			System.out.print(arrayList);
////		}
//		
//		//13
//		System.out.println();
//		System.out.print("inorder : ");
//		BinaryTreeUse.inOrder(root);
//		
//		System.out.println();
//		System.out.print("reverse Inorder  : ");
//		BinaryTreeUse.ReverseInOrder(root);
		
		// floor and ceil
		
//		int[] arr = {8, 5, 1, 7, 10, 12};
//		BinaryTreeNode<Integer> root = bstFromPreorder(arr);
//		System.out.println();
//		BinaryTreeUse.printBinaryTreeBest(root);
		
		succPredBST(root, 10);
		
	}
	
	public static Integer getNextFromNormalReverseInOrder(
			StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
//		List<Integer> ans = new ArrayList<Integer>();
		while ( !leftStackOrIn_OrderStack.isEmpty() ) {
			try {
				
				Pairr<BinaryTreeNode<Integer>, Integer> top = leftStackOrIn_OrderStack.top();
				
				// pre, s++ , left
				if ( top.second == 1 ) { 

					if ( top.first.right != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.right, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					if ( top.first.left != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.left, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
//					ans.add(top.first.data);
					return top.first.data;
				}
				
				// post, pop
				else {
					leftStackOrIn_OrderStack.pop();
				}
				
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	public static Integer getNextFromNormalInOrder(StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
		List<Integer> ans = new ArrayList<Integer>();
		while ( !leftStackOrIn_OrderStack.isEmpty() ) {
			try {
				
				Pairr<BinaryTreeNode<Integer>, Integer> top = leftStackOrIn_OrderStack.top();
				
				// pre, s++ , left
				if ( top.second == 1 ) { 

					if ( top.first.left != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.left, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					if ( top.first.right != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.right, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
//					ans.add(top.first.data);
					return top.first.data;
				}
				
				// post, pop
				else {
					leftStackOrIn_OrderStack.pop();
				}
				
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
		
	}
	
	public static boolean succPredBST(BinaryTreeNode<Integer> root, int k) {
        //your code goes here
		if (root == null) return false;

		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> rightStackOrReverseIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		
		leftStackOrIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		rightStackOrReverseIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		
		
        // Initialize two iterators
        Integer i = getNextFromNormalInOrder(leftStackOrIn_OrderStack); // normal inorder
        Integer j = getNextFromNormalReverseInOrder(leftStackOrIn_OrderStack); // reverse inorder

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = getNextFromNormalInOrder(leftStackOrIn_OrderStack);
            else j = getNextFromNormalReverseInOrder(leftStackOrIn_OrderStack);
        }
        
        return false;
    }
	
	public static BinaryTreeNode<Integer> bstFromPreorder(int[] preorder) {
        //your code goes here
		if ( preorder.length == 0 ) {
			return null;
		}
		
		if ( preorder.length == 1 ) {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[0]);
			return root;
		}
		
		if ( preorder.length == 2 ) {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[0]);
			
			if ( preorder[1] < preorder[0] ) {
				root.left = new BinaryTreeNode<Integer>(preorder[1]);
			} else {
				root.right = new BinaryTreeNode<Integer>(preorder[1]);
			}
			
			return root;
		}
		
		
		int leftStart = 0;
		int leftEnd = preorder.length;
		int rightStart = 0;
		int rightEnd = preorder.length;
		
		BinaryTreeNode<Integer> root = bstFromPreorder(preorder, leftStart, leftEnd, rightStart, rightEnd);
		return root;
    }
	
//	int[] arr = {8, 5, 1, 7, 10, 12};
	private static BinaryTreeNode<Integer> bstFromPreorder(int[] preorder, int leftStart, int leftEnd, int rightStart,
			int rightEnd) {
		
		// create root of root
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[leftStart]);
		leftStart = leftStart + 1;
		int count = 1;
		
		for (int i = leftStart; i < preorder.length; i++) {
			if ( root.data > preorder[i] ) {
				break;
			}
			count++;
		}
		
		leftEnd = leftStart + count - 1;
		
		root.left = bstFromPreorder(preorder, leftStart, leftEnd, rightStart, rightEnd);
		
		rightStart = leftEnd + 1;
//		rightEnd = rightEnd;
	
		root.right = bstFromPreorder(preorder, leftStart, leftEnd, rightStart, rightEnd);
		
		
		return root;
	}

	public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
		
		
		return null;
    }
	
	public static void inOrder(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		
		
		if ( root.left != null )  {
			inOrder(root.left);
		}
		
//		System.out.print(root.data + " ");
//	
//		if ( root.right != null ) {
//			inOrder(root.right);
//		}
		
	}
	
	public static void ReverseInOrder(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		if ( root.right != null ) {
			ReverseInOrder(root.right);
		}
		
		System.out.print(root.data + " ");
		
		if ( root.left != null )  {
			ReverseInOrder(root.left);
		}

	}
	private static boolean pair(BinaryTreeNode<Integer> root, int t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static ArrayList<ArrayList<Integer>> pairReturn(BinaryTreeNode<Integer> root, int t) {
		// TODO Auto-generated method stub
		
		if ( root == null ) return null;
		
		if ( root.left == null ) {
			
		}
		
		pairReturn(root.left, t);
		
		pairReturn(root.right, t);
		
		return null;
	}

	public static Pairrrr<Boolean, Integer, Integer, Integer> isBSTMaxSize(BinaryTreeNode<Integer> root) {

		if (root == null) {
			// isBST, minimum, maximum
			return new Pairrrr<Boolean, Integer, Integer, Integer>(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		Pairrrr<Boolean, Integer, Integer, Integer> leftOutput = isBSTMaxHeight(root.left);
		Pairrrr<Boolean, Integer, Integer, Integer> rightOutput = isBSTMaxHeight(root.right);
		
		Integer min = Math.min(root.data, Math.min(leftOutput.second, rightOutput.second));
		Integer max = Math.max(root.data, Math.max(leftOutput.third, rightOutput.third));
		boolean isBST = (root.data > leftOutput.third) && (root.data < rightOutput.second) && leftOutput.first && rightOutput.first;
		
		Integer maxSize = Math.max(leftOutput.fouth, rightOutput.fouth);
		
		if ( isBST ) {
			maxSize = 1 + leftOutput.fouth + rightOutput.fouth;
		}
		
		System.out.println("maxSize : " + maxSize);
		

		return new Pairrrr<Boolean, Integer, Integer, Integer>(isBST, min, max, maxSize);
	}

	
	public static Pairrrr<Boolean, Integer, Integer, Integer> isBSTMaxHeight(BinaryTreeNode<Integer> root) {

		if (root == null) {
			// isBST, minimum, maximum
			return new Pairrrr<Boolean, Integer, Integer, Integer>(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		Pairrrr<Boolean, Integer, Integer, Integer> leftOutput = isBSTMaxHeight(root.left);
		Pairrrr<Boolean, Integer, Integer, Integer> rightOutput = isBSTMaxHeight(root.right);
		
		Integer min = Math.min(root.data, Math.min(leftOutput.second, rightOutput.second));
		Integer max = Math.max(root.data, Math.max(leftOutput.third, rightOutput.third));
		boolean isBST = (root.data > leftOutput.third) && (root.data < rightOutput.second) && leftOutput.first && rightOutput.first;
		
//		if ( )
//		Integer maxHeight = 1 + Math.max(leftOutput.fouth, rightOutput.fouth);
		Integer maxHeight = Math.max(leftOutput.fouth, rightOutput.fouth);
		
//		if ( leftOutput.first ) {
//			maxHeight = leftOutput.fouth;
//		}
//		if ( rightOutput.first ) {
//			maxHeight = rightOutput.fouth;
//		}
		
		if ( isBST ) {
			maxHeight = 1 + Math.max(leftOutput.fouth, rightOutput.fouth);
		}
		
		System.out.println("maxHeight : " + maxHeight);
		

		return new Pairrrr<Boolean, Integer, Integer, Integer>(isBST, min, max, maxHeight);
	}
	
	
	public static List<Node<Integer>> levelWiseBestReturnLinkedListNode(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return new ArrayList<Node<Integer>>();
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<BinaryTreeNode<Integer>>();
		queue.enQueue(root);
		queue.enQueue(null);
		
		List<Node<Integer>> listOfList = new ArrayList<Node<Integer>>();
		DoubleNode<Integer> doubleNode = new DoubleNode<Integer>();
		
		while ( !queue.isEmpty() ) {
						
			BinaryTreeNode<Integer> front = queue.deQueue();
			
			if ( !queue.isEmpty() ) {
				
				if ( front == null ) {
					
					if ( doubleNode.head != null ) {
						listOfList.add(doubleNode.head);
						doubleNode = new DoubleNode<Integer>();
					}
					
//					System.out.println();
					queue.enQueue(null);
				}
				
			
				else {
//					System.out.print(front.data + " ");
					// add this to doubleNode
//					list.add(front.data);
					if ( doubleNode.head == null ) {
						Node<Integer> head = new Node<Integer>(front.data);
						doubleNode.head = head;
						doubleNode.tail = head;
					} else {
						Node<Integer> head = new Node<Integer>(front.data);
						doubleNode.tail.next = head;
						doubleNode.tail = doubleNode.tail.next;
					}
					
					if ( front.left != null ) {
						queue.enQueue(front.left);
					}
					
					if ( front.right != null ) {
						queue.enQueue(front.right);
					}
					
				}
				
			}

		}
		
		if ( doubleNode.head != null ) listOfList.add(doubleNode.head);

		return listOfList;
	}


	public static int replaceSum(BinaryTreeNode<Integer> root, int sum) {
		
		if ( root == null ) return 0;
		
		// right
		int rightSum = replaceSum(root.right, sum);
		
		// root
		if ( rightSum != 0 ) {
			root.data = root.data + rightSum;
		}
		
		else {
			root.data = root.data + sum + rightSum;
		}
		
		// left
		int leftSum = replaceSum(root.left, root.data);
		
		if ( leftSum != 0 ) {
			return leftSum;
		}
		// return 
		
		return root.data;
	}

	public static DoubleNode<Integer> binaryTreeToLinkedList(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return null;
		}
		
		// root is not null
		// create treenode
		Node<Integer> node = new Node<Integer>(root.data);
		DoubleNode<Integer> doubleNode = new DoubleNode<Integer>(node, node);
		
		DoubleNode<Integer> leftLinkedList = null;
		if (root.left != null) {
			leftLinkedList = binaryTreeToLinkedList(root.left);
		}
		DoubleNode<Integer> rightLinkedList = null;
		if (root.right != null) {
			rightLinkedList = binaryTreeToLinkedList(root.right);
		}
		
		if ( leftLinkedList != null && rightLinkedList != null ) {
			leftLinkedList.tail.next = doubleNode.head;
			doubleNode.head.next = rightLinkedList.head;
			doubleNode.tail = rightLinkedList.head;
			leftLinkedList.tail = rightLinkedList.tail;
			return leftLinkedList;
		}
		
		return doubleNode;
	}

	public static BinaryTreeNode<Integer> sortedArrayToBinaryTree(int[] arr, int i, int j) {
		
		if ( arr.length == 0 ) {
			return null;
		}
		
		if ( j<i) {
			return null;
		}
		
		// here array have some size
		int mid =  ( i + j )/2;
		int midPoint = arr[mid];
		
		//create a tree node
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(midPoint);
		
		BinaryTreeNode<Integer> leftCall = sortedArrayToBinaryTree(arr, i, mid - 1);
		BinaryTreeNode<Integer> rightCall = sortedArrayToBinaryTree(arr, mid + 1, j);
		
		root.left = leftCall;
		root.right = rightCall;
		
		return root;
	}

	public static BinaryTreeNode<Integer> searchBST(BinaryTreeNode<Integer> root, int element) {

		if (root == null)
			return null;

		if (root.data == element)
			return root;

		if (root.left != null && element < root.data) {
			return searchBST(root.left, element);
		}

		else if (root.right != null && root.data < element) {
			return searchBST(root.right, element);
		}

		return null;
	}

	public static void printInRange(BinaryTreeNode<Integer> root, int r1, int r2) {

		if (root == null)
			return;

		if (r1 < root.data && r2 < root.data) {
			printInRange(root.left, r1, r2);
		}

		else if (r1 > root.data && r2 > root.data) {
			printInRange(root.right, r1, r2);
		}

		else {
			printInRange(root.left, r1, r2);
			System.out.print(root.data + " ");
			printInRange(root.right, r1, r2);
		}

	}

	public static int rangeSumBST(BinaryTreeNode<Integer> root, int r1, int r2) {

		if (root == null)
			return 0;

		int sum = 0;

		if (r1 < root.data && r2 < root.data) {
			sum += rangeSumBST(root.left, r1, r2);
		}

		else if (r1 > root.data && r2 > root.data) {
			sum += rangeSumBST(root.right, r1, r2);
		}

		else {
			sum += rangeSumBST(root.left, r1, r2);
//			System.out.print(root.data + " ");
			sum += root.data;
			sum += rangeSumBST(root.right, r1, r2);
		}
		return sum;
	}

	public static int minimum(BinaryTreeNode<Integer> right) {

		if (right == null) {
			return Integer.MAX_VALUE;
		}

		return Math.min(right.data, Math.min(minimum(right.left), minimum(right.right)));
	}

	public static int maximum(BinaryTreeNode<Integer> left) {

		if (left == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(left.data, Math.max(maximum(left.left), maximum(left.right)));
	}
	
	public static boolean checkBSTBest(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return true;
		}

		int leftMax = maximum(root.left);
		int rightMinimum = minimum(root.right);

		if (root.data <= leftMax) {
			return false;
		}

		if (root.data > rightMinimum) {
			return false;
		}

		boolean isLeftBST = checkBSTBest(root);
		boolean isRightBST = checkBSTBest(root);

		return isLeftBST && isRightBST;
	}

	public static Pairrr<Boolean, Long, Long> isBST(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return new Pairrr<Boolean, Long, Long>(true, Long.MAX_VALUE, Long.MIN_VALUE);
		}

		Pairrr<Boolean, Long, Long> leftOutput = isBST(root.left);
		Pairrr<Boolean, Long, Long> rightOutput = isBST(root.right);

//		if ( )
		Long min = Math.min(root.data, Math.min(leftOutput.second, rightOutput.second));
		Long max = Math.max(root.data, Math.max(leftOutput.third, rightOutput.third));

		boolean isBST = (root.data > leftOutput.third) && (root.data < rightOutput.second) && leftOutput.first
				&& rightOutput.first;

		return new Pairrr<Boolean, Long, Long>(isBST, min, max);
	}
	
	public static Pairrr<Boolean, Integer, Integer> isBSTInteger(BinaryTreeNode<Integer> root) {

		if (root == null) {
			// isBST, minimum, maximum
			return new Pairrr<Boolean, Integer, Integer>(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pairrr<Boolean, Integer, Integer> leftOutput = isBSTInteger(root.left);
		Pairrr<Boolean, Integer, Integer> rightOutput = isBSTInteger(root.right);
		
		Integer min = Math.min(root.data, Math.min(leftOutput.second, rightOutput.second));
		Integer max = Math.max(root.data, Math.max(leftOutput.third, rightOutput.third));

		boolean isBST = (root.data > leftOutput.third) && (root.data < rightOutput.second) && leftOutput.first
				&& rightOutput.first;

		return new Pairrr<Boolean, Integer, Integer>(isBST, min, max);
	}

}
