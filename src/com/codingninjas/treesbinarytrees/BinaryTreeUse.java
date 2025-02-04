package com.codingninjas.treesbinarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.codingninjas.stack.StackEmptyException;
import com.codingninjas.stack.StackUsingLL;

@SuppressWarnings({"resource", "unused"})
public class BinaryTreeUse {

	public static void main(String[] args) {
		
		//1
//		BinaryTreeNode<Integer> root1 = buildBinaryTree();
//		printBinaryTree(root1);
		
		//2
//		Scanner sc = new Scanner(System.in);
//		BinaryTreeNode<Integer> root2 = takeInput(sc);
//		printBinaryTree(root2);
		
		//3
//		BinaryTreeNode<Integer> root3 = takeInputBetter(true, 0, false);
//		printBinaryTree(root3);
		
		//3
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.print("root : ");
		printBinaryTree(root);
		System.out.println();
		System.out.println();
		System.out.println("printBinaryTreeBest : ");
		printBinaryTreeBest(root);
		
		//4
		System.out.println();
		int n = numberOfNodes(root);
		System.out.println("number of Nodes " + n);
		
		//5
//		1 2 3 4 5 6 7 -1 -1 -1 -1 8 -1 -1 -1 -1 -1
		System.out.println();
		int ln = nodeWithLargestData(root);
		System.out.println("largest Node is " + ln);

		//6
		System.out.println();
		int maximumHeight = heightOftheBinaryTree(root);
		System.out.println("height of root node is : " + maximumHeight);
		
		//7
		System.out.println();
		int numOfLeaf = numberOfLeafNodes(root);
		System.out.println("number of leaf nodes are : " + numOfLeaf);
		
		//8
		System.out.println();
		int k = 2;
		System.out.print("k : "+ k +" KDepthNodes : ");
		KDepthNodes(root, k);
		System.out.println();
		
		//9
		//print pre-order
		System.out.println();
		System.out.print("Pre-order : ");
		preOrder(root);
						
		// print post-order
		System.out.println();
		System.out.print("Post-order : ");
		postOrder(root);
		
		//10
//		System.out.println();
//		System.out.print("removeLeafNode : ");
//		removeLeafNode(root);
//		printBinaryTreeBest(root);
		
		//11
		System.out.println();
		mirrorBinaryTree(root);
		System.out.print("mirrorBinaryTree : ");
		printBinaryTreeBest(root);
		
		//12
		System.out.println();
		boolean b = isBalanced(root);
		System.out.println("is balanced : " + b);
		
		//13
		System.out.println();
		boolean bb = isBalancedBetterCall(root);
		System.out.println("is balanced better : " + bb);
		
		//14
		System.out.println();
		int diameter = diameter(root);
		System.out.println("diameter of root is : " + diameter);
		
		System.out.println();
		Pair<Integer, Integer> daimeterHeight = heightDiameter(root);
		System.out.println("diameter of root best : " + daimeterHeight.diameter);
		
		//15
		System.out.println();
		int[] preorder = {1,2,4,5,3,6,7};
		int[] inorder = {4,2,5,1,6,3,7};	
		BinaryTreeNode<Integer> result = createBinaryTreeCall(preorder, inorder);
		System.out.print("Given in-order And pre-order tree : ");
		printBinaryTreeBest(result);
		
		//16
//		System.out.println();
//		createAndInsertDuplicate(root);
//		System.out.println("duplicateLeft Tree : ");
//		printBinaryTreeBest(root);

		//17
		System.out.println(); 
		int[] resultArray = maxiAndMini(root);
		
		System.out.print("maxiAndMini : ");
		for (int i : resultArray) {
			System.out.print(i + " ");
		}
		
		//18
		System.out.println();
		System.out.println();
		System.out.print("printLevelWise : ");
		printLevelWise(root, 0);
		
		System.out.println();
		System.out.println();
		System.out.println("printLevelWiseBest : ");
		printLevelWiseBest(root);
		
		//19
		System.out.println();
		System.out.println();
		boolean i = hasPathSum(root, 12);
		System.out.print("hasPathSum : ");
		System.out.println(i);
		
		//2
		System.out.print("printRootToLeaf : ");
		printRootToLeaf(root, 12, "");
		System.out.println();
		
		//21
		System.out.println();
		int summ = sumNumbers(root, true, 0);
		System.out.print("sumNumbers : ");
		System.out.println(summ);
		
		//22
		System.out.println();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Boolean nn = nodeToRootPath(root, 5, ans);
		System.out.println("node is present : "+ nn);
		System.out.print("nodeToRootPath : ");
		for (Integer integer : ans) {
			System.out.print(integer + " ");
		}
		
		//23
		System.out.println();
		System.out.println();
		ArrayList<BinaryTreeNode<Integer>> answer = new ArrayList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> element = new BinaryTreeNode<Integer>(5);
		Boolean mn = nodeToRootPathReturnsBinaryNode(root, element, answer);
		System.out.println("node is present : "+ mn);
		System.out.print("nodeToRootPath : ");
		for (BinaryTreeNode<Integer> integer : answer) {
			System.out.print(integer.data + " ");
		}
		
		//24
		// 1.node to root 
		// 2.k depth with previous blocker
		System.out.println();
		
		//25
		// 3: k distance from given node
		System.out.println();
		BinaryTreeNode<Integer> data = new BinaryTreeNode<Integer>(5);
		int kk = 2;
		System.out.print("k distance nodes : ");
		List<Integer> finalAnswer = kDistance(root, data, kk);
		for (Integer integer : finalAnswer) {
			System.out.print(integer +" ");
		}
		
		//26
		// sum tree
		//sumNumber failing in code 360
//		System.out.println();
//		System.out.println();
//		int sum = sumNumbers(root);
//		System.out.println("Sum Root to Leaf Numbers : " + sum);
		
		//27 
		// Done: inorder and postorder to tree
		
		//28
		// TODO: question from tuf+
		
		//29
		System.out.println();
		System.out.print("rootToElementNodePath : " );
		ArrayList<Integer> ress = rootToElementReturnArrayList(root, 6);
		System.out.println(ress);
		
		//30
		System.out.println();
		List<List<Integer>> answer1 = levelWiseBestReturnListInteger(root);
		System.out.println("list of list of level wise : " + answer1);
		
		//31
		//LCA of Binary Tree
//		int x = 5;
//		int y = 1;
//		int lca = lcaOfBinaryTree(root, x, y);
//		System.out.println();
//		System.out.println("LCA : " + lca);
		
		//32
		//LCA of Binary Tree
//		ArrayList<BinaryTreeNode<Integer>> xPath = new ArrayList<BinaryTreeNode<Integer>>();
//		BinaryTreeNode<Integer> xx = new BinaryTreeNode<Integer>(-2);
//		BinaryTreeNode<Integer> yy = new BinaryTreeNode<Integer>(8);
//		BinaryTreeNode<Integer> lca2 = lcaOfBinaryTreeNode(root, xx, yy);
//		System.out.println();
//		System.out.println("LCA : " + lca2.data);
//		
//		nodeToRootPathReturnsBinaryNode(root, xx, xPath);
//		
//		System.out.print("node to root : ");
//		for (BinaryTreeNode<Integer> binaryTreeNode : xPath) {
//			System.out.print(binaryTreeNode.data + " ");
//		}
		
		
		//33 
		// iterativly inorder preorder and postorder
		System.out.println();
		printInorderUsingIterative(root);
		
		//34
		// using ArrayList
		
		
		//35
		// using Stack
		System.out.println("bestApproachReturnArray : ");
		ArrayList<ArrayList<Integer>> arrrr = bestApproachReturnArray(root, 19);
		for (ArrayList<Integer> arrayList : arrrr) {
			ArrayList<Integer> array = arrayList;
			for (Integer arrayList2 : array) {
				System.out.print(array + " ");
			}
			System.out.println();
		}
		
		
		//36
		//symmetric
		boolean s = returnSymmetric(root);
		System.out.println();
		System.out.println("symmetric : " + s);

	}
	
	private static boolean returnSymmetric(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return true;
		}
		
		Queue<BinaryTreeNode<Integer>> leftTree = new LinkedList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> rightTree = new LinkedList<BinaryTreeNode<Integer>>();

		leftTree.add(root.left);
		rightTree.add(root.right);
		
		while ( !leftTree.isEmpty() && !rightTree.isEmpty() ) {

			BinaryTreeNode<Integer> frontL = leftTree.poll();
			BinaryTreeNode<Integer> frontR = rightTree.poll();
			
			if ( frontL == null && frontR == null ) continue;
			if ( frontL == null || frontR == null ) return false;
			if ( frontL.data != frontR.data ) return false;
			
			//push 
			leftTree.add(frontL.left);
			leftTree.add(frontL.right);
			rightTree.add(frontR.right);
			rightTree.add(frontR.left);
			
		}
		
		return true;
	}

	public static ArrayList<ArrayList<Integer>> bestApproachReturnArray(BinaryTreeNode<Integer> root, int tar) {
		
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> rightStackOrReverseIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		
		leftStackOrIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		rightStackOrReverseIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		
		BinaryTreeNode<Integer> left = getNextFromNormalInOrder(leftStackOrIn_OrderStack);
		BinaryTreeNode<Integer> right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
		
		while ( left.data < right.data ) {

			ArrayList<Integer> arr = new ArrayList<>();
			
            if ( left.data + right.data < tar ) {
				left = getNextFromNormalInOrder(leftStackOrIn_OrderStack);
			} 
			else if ( left.data + right.data > tar ) {
				right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
			} 
			else {
				// System.out.println( left.data + " " + right.data );
                arr.add(left.data);
                arr.add(right.data);
				left =  getNextFromNormalInOrder(leftStackOrIn_OrderStack);
				right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
			}

            if (arr.size() != 0) array.add(arr);
		}

        if ( array.size() == 0 ) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(-1);
            arr.add(-1);
            array.add(arr);
            return array;
        }

		return array;
	}

	public static void bestApproach(BinaryTreeNode<Integer> root, int tar) {
		
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> rightStackOrReverseIn_OrderStack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		
		leftStackOrIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		rightStackOrReverseIn_OrderStack.push(new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1));
		
		BinaryTreeNode<Integer> left = getNextFromNormalInOrder(leftStackOrIn_OrderStack);
		BinaryTreeNode<Integer> right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
		
		while ( left.data < right.data ) {
			
			if ( left.data + right.data < tar ) {
				left = getNextFromNormalInOrder(leftStackOrIn_OrderStack);
			} 
			else if ( left.data + right.data > tar ) {
				right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
			} 
			else {
				System.out.println( left.data + " " + right.data );
				left =  getNextFromNormalInOrder(leftStackOrIn_OrderStack);
				right = getNextFromNormalReverseInOrder(rightStackOrReverseIn_OrderStack);
			}
		}
		
	}

	public static BinaryTreeNode<Integer> getNextFromNormalReversePreOrder(
			StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
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
					return top.first;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					if ( top.first.left != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.left, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
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
	
	public static BinaryTreeNode<Integer> getNextFromNormalPreOrder(StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
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
					return top.first;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					if ( top.first.right != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.right, 1);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
					
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

	public static BinaryTreeNode<Integer> getNextFromNormalReverseInOrder(
			StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
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
					return top.first;
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
	
	public static BinaryTreeNode<Integer> getNextFromNormalInOrder(StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> leftStackOrIn_OrderStack) {
		
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
					return top.first;
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

	public static Pairrr<BinaryTreeNode<Integer>, Integer, Integer> getNextFromNormalReverseInOrderPair(
			StackUsingLL<Pairrr<BinaryTreeNode<Integer>, Integer, Integer>> leftStackOrIn_OrderStack) {
		
		while ( !leftStackOrIn_OrderStack.isEmpty() ) {
			try {
				
				Pairrr<BinaryTreeNode<Integer>, Integer, Integer> top = leftStackOrIn_OrderStack.top();
				
				// pre, s++ , left
				if ( top.second == 1 ) { 
					
					
					Integer s = -1;
					
					if ( top.first.left != null && top.first.right == null ) {
						s = 1;
					} else if ( top.first.left == null && top.first.right != null ) {
						s = 2;
					}

					if ( top.first.right != null ) {
						Pairrr<BinaryTreeNode<Integer>, Integer, Integer> lp = new Pairrr<BinaryTreeNode<Integer>, Integer, Integer>(top.first.right, 1, s);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					Integer s = -1;
					
					if ( top.first.left != null && top.first.right == null ) {
						s = 1;
					} else if ( top.first.left == null && top.first.right != null ) {
						s = 2;
					}
					
					if ( top.first.left != null ) {
						Pairrr<BinaryTreeNode<Integer>, Integer, Integer> lp = new Pairrr<BinaryTreeNode<Integer>, Integer, Integer>(top.first.left, 1, s);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
					return top;
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
	
	public static Pairrr<BinaryTreeNode<Integer>, Integer, Integer> getNextFromNormalInOrderPair(
			StackUsingLL<Pairrr<BinaryTreeNode<Integer>, Integer, Integer>> leftStackOrIn_OrderStack) {
		
		while ( !leftStackOrIn_OrderStack.isEmpty() ) {
			try {
				
				Pairrr<BinaryTreeNode<Integer>, Integer, Integer> top = leftStackOrIn_OrderStack.top();
				
				// pre, s++ , left
				if ( top.second == 1 ) {
					
					Integer s = -1;
					
					if ( top.first.left != null && top.first.right == null ) {
						s = 1;
					} else if ( top.first.left == null && top.first.right != null ) {
						s = 2;
					}
//					else {
//						s = 3;
//					}
					
					if ( top.first.left != null ) {
						Pairrr<BinaryTreeNode<Integer>, Integer, Integer> lp = new Pairrr<BinaryTreeNode<Integer>, Integer, Integer>(top.first.left, 1, s);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					
					Integer s = -1;
					
					if ( top.first.left != null && top.first.right == null ) {
						s = 1;
					} else if ( top.first.left == null && top.first.right != null ) {
						s = 2;
					}
					
					if ( top.first.right != null ) {
						Pairrr<BinaryTreeNode<Integer>, Integer, Integer> lp = new Pairrr<BinaryTreeNode<Integer>, Integer, Integer>(top.first.right, 1, s);
						leftStackOrIn_OrderStack.push(lp);
					}
					top.second++;
					return top;
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

	
	public static void printInorderUsingIterative(BinaryTreeNode<Integer> root) {
		
		StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>> stack = new StackUsingLL<Pairr<BinaryTreeNode<Integer>, Integer>>();
		Pairr<BinaryTreeNode<Integer>, Integer> pair = new Pairr<BinaryTreeNode<Integer>, Integer>(root, 1);
		
		stack.push(pair);
		
		String pre = "";
		String in = "";
		String post = "";
		
		
		while ( !stack.isEmpty() ) {
			try {
				
				Pairr<BinaryTreeNode<Integer>, Integer> top = stack.top();
				
				// pre, s++ , left
				if ( top.second == 1 ) { 
					pre += top.first.data + " ";
					top.second++;
					
					if ( top.first.left != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.left, 1);
						stack.push(lp);
					}
					
				}
				
				// in, s++ ,right
				else if ( top.second == 2 ) {
					in += top.first.data + " ";
					top.second++;
					
					if ( top.first.right != null ) {
						Pairr<BinaryTreeNode<Integer>, Integer> lp = new Pairr<BinaryTreeNode<Integer>, Integer>(top.first.right, 1);
						stack.push(lp);
					}
					
				}
				
				// post, pop
				else {
					post += top.first.data + " ";
					stack.pop();
				}
				
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("pre-order : " + pre);
		System.out.println("in-order : " + in);
		System.out.println("post-order : " + post);
		
	}
	
	public static BinaryTreeNode<Integer> lcaOfBinaryTreeNode(BinaryTreeNode<Integer> root, 
			BinaryTreeNode<Integer> x, BinaryTreeNode<Integer> y) {
		
		if ( root == null ) {
			return null;
		}
		
		ArrayList<BinaryTreeNode<Integer>> xPath = new ArrayList<BinaryTreeNode<Integer>>();
		ArrayList<BinaryTreeNode<Integer>> yPath = new ArrayList<BinaryTreeNode<Integer>>();
		// find root to node path for both x and y
//		ArrayList<Integer> xPath = rootToElementReturnArrayList(root, x);
//		ArrayList<Integer> yPath = rootToElementReturnArrayList(root, y);
		nodeToRootPathReturnsBinaryNode(root, x, xPath);
		nodeToRootPathReturnsBinaryNode(root, y, yPath);
		
		Collections.reverse(xPath);
		Collections.reverse(yPath);
		
//		System.out.print("xPath : ");
//		for (BinaryTreeNode<Integer> i : xPath) {
//			System.out.print(i.data + " ");
//		}
//		
//		System.out.println();
//		System.out.print("yPath : ");
//		for (BinaryTreeNode<Integer> i : yPath) {
//			System.out.print(i.data + " ");
//		}
		
		int i = 0;
		BinaryTreeNode<Integer> commonRoot = null;
		while ( i < Math.min(xPath.size(), yPath.size())) {
			
			if (xPath.get(i).data == yPath.get(i).data) {
				commonRoot = xPath.get(i);
			}
			else {
				break;
			}
			
			i++;
		}
		
		return commonRoot;
	}

	public static int lcaOfBinaryTree(BinaryTreeNode<Integer> root, int x, int y) {
		
		if ( root == null ) {
			return -1;
		}
		
//		ArrayList<BinaryTreeNode<Integer>> answer = new ArrayList<BinaryTreeNode<Integer>>();
//		List<Integer> finalAnswer = new ArrayList<Integer>();
//		nodeToRootPathReturnsBinaryNode(root, x, answer);
		
		// find root to node path for both x and y
		ArrayList<Integer> xPath = rootToElementReturnArrayList(root, x);
		ArrayList<Integer> yPath = rootToElementReturnArrayList(root, y);
		
		Collections.reverse(xPath);
		Collections.reverse(yPath);
		
//		System.out.println("xPath");
//		for (Integer i : xPath) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println();
//		System.out.println("yPath");
//		for (Integer i : yPath) {
//			System.out.print(i + " ");
//		}
		
		int i = 0;
		int commonRoot = -1;
		while ( i < Math.min(xPath.size(), yPath.size())) {
			
			if (xPath.get(i) == yPath.get(i)) {
				commonRoot = xPath.get(i);
			}
			
			else if (xPath.get(i) != yPath.get(i)) break;
			
			i++;
		}
		
		return commonRoot;
		
	}
	
	public static Boolean nodeToRootPathReturnsBinaryNode(BinaryTreeNode<Integer> root, int element, ArrayList<BinaryTreeNode<Integer>> answer) {
		
		if ( root == null || element < 0 ) return false;
		
		if (root.data == element ) {
			answer.add(root);
			return true;
		}
		
		if ( nodeToRootPathReturnsBinaryNode(root.left, element, answer) ) {
			answer.add(root);
			return true;
		}
		if ( nodeToRootPathReturnsBinaryNode(root.right, element, answer) ) {
			answer.add(root);
			return true;
		}
		
		return false;
	}

	public static List<List<Integer>> levelWiseBestReturnListInteger(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return new ArrayList<List<Integer>>();
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<BinaryTreeNode<Integer>>();
		queue.enQueue(root);
		queue.enQueue(null);
		
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		while ( !queue.isEmpty() ) {
						
			BinaryTreeNode<Integer> front = queue.deQueue();
			
			if ( !queue.isEmpty() ) {
				
				if ( front == null ) {
					
					if ( !list.isEmpty() ) {
						listOfList.add(list);
						list = new ArrayList<Integer>();
					}
					
//					System.out.println();
					queue.enQueue(null);
				}
				
			
				else {
					System.out.print(front.data + " ");
					list.add(front.data);
				
					if ( front.left != null ) {
						queue.enQueue(front.left);
					}
					
					if ( front.right != null ) {
						queue.enQueue(front.right);
					}
				}
			}
//			System.out.println(list);
		}
		
		if (!list.isEmpty()) listOfList.add(list);

		return listOfList;
	}

	public static ArrayList<Integer> rootToElementReturnArrayList(BinaryTreeNode<Integer> root, int target) {

		if ( root == null ) {
			return null;
		}
		
		if ( root.data == target ) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(root.data);
			return result;
		}
		
		ArrayList<Integer> leftResult = rootToElementReturnArrayList(root.left, target);
		if ( leftResult != null ) {
			leftResult.add(root.data);
			return leftResult;
		}
		
		ArrayList<Integer> rightResult = rootToElementReturnArrayList(root.right, target);
		if ( rightResult != null ) {
			rightResult.add(root.data);
			return rightResult;
		}
		
		return null;
	}
	public static int sumNumbers(BinaryTreeNode<Integer> root) {
        return sumNumbers(root, -1);
    }
    public static int sumNumbers(BinaryTreeNode<Integer> root, int rootData) {
        
        if ( root == null ) {
            return 0;
        }

        if ( root.left == null && root.right == null ) {
            
            if ( rootData == -1 ) {
                return root.data;
            } 
            
            root.data = root.data + rootData * 10;
            return root.data;
            
        }
        
        if ( rootData != -1 ) root.data = root.data + rootData * 10;
        
        int sum = 0;
        sum += sumNumbers(root.left, root.data);
        sum += sumNumbers(root.right, root.data);

        return sum;

    }
	public static List<Integer> kDistance(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> data, int kk) {
		
		ArrayList<BinaryTreeNode<Integer>> answer = new ArrayList<BinaryTreeNode<Integer>>();
		List<Integer> finalAnswer = new ArrayList<Integer>();
		nodeToRootPathReturnsBinaryNode(root, data, answer);
		
		for (int i = 0; i < answer.size(); i++) {
			KDepthNodeReturnList(answer.get(i), kk - i, i==0 ? null:answer.get(i-1), finalAnswer);
		}
		
		return finalAnswer;
		
	}
	public static Boolean nodeToRootPathReturnsBinaryNode(BinaryTreeNode<Integer> root, 
			BinaryTreeNode<Integer> element, ArrayList<BinaryTreeNode<Integer>> answer) {
		
		if ( root == null ) return false;
		
		if (root.data == element.data ) {
			answer.add(root);
			return true;
		}
		
		if ( nodeToRootPathReturnsBinaryNode(root.left, element, answer) ) {
			answer.add(root);
			return true;
		}
		if ( nodeToRootPathReturnsBinaryNode(root.right, element, answer) ) {
			answer.add(root);
			return true;
		}
		
		return false;
	}
	public static void KDepthNodeReturnList(BinaryTreeNode<Integer> root, int k, BinaryTreeNode<Integer> blocker, List<Integer> list) {
		
		if ( root == null || k < 0 || blocker == root) {
			return;
		}
		
		if ( k == 0 ) {
			list.add(root.data);
//			System.out.print(root.data + " ");
		}
		
		if ( root.left != null )  {
			KDepthNodeReturnList(root.left, k-1, blocker, list);
		}
		
		if ( root.right != null ) {
			KDepthNodeReturnList(root.right, k-1, blocker, list);
		}

	}
	public static int numberOfLeafNodes(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			return 0;
		}
		
		if (root.left == null && root.right == null ) {
			return 1;
		}
		
		int numOfLeaf = 0;
		
		if ( root.left != null )  {
			numOfLeaf += numberOfLeafNodes(root.left);
		}
		
		if ( root.right != null ) {
			numOfLeaf += numberOfLeafNodes(root.right);
		}
		
		return numOfLeaf;
	}
	public static Boolean nodeToRootPath(BinaryTreeNode<Integer> root, int element, ArrayList<Integer> answer) {
		
		if ( root == null ) return false;
		
		if (root.data == element ) {
			answer.add(root.data);
			return true;
		}
		
		if ( nodeToRootPath(root.left, element, answer) ) {
			answer.add(root.data);
			return true;
		}
		if ( nodeToRootPath(root.right, element, answer) ) {
			answer.add(root.data);
			return true;
		}
		
		return false;
	}
	
	public boolean symetricTree(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) return true;
		
		// left
		if ( root.left == null && root.right == null ) return true;
		
		BinaryTreeNode<Integer> tempLeft;
		if ( root.left != null) {
			tempLeft = root.left;
		}

		return false;
	}
	
	public static void printRootToLeaf(BinaryTreeNode<Integer> root, int target, String str) {

		target = target - root.data;
		
		
		if ( target > 0 && root.left != null || root.right != null ) {
			str = str + root.data + " ";
		}
		
		if ( target == 0 && root.left == null && root.right == null ) {
			str = str + root.data + " ";
			System.out.print(str);
		}
		
		if (root.left != null) printRootToLeaf(root.left, target, str);
		if (root.right != null) printRootToLeaf(root.right, target, str);
		
	}

	public static int sumNumbers(BinaryTreeNode<Integer> root, boolean isRoot, int sum) {
		
		if ( root == null ) {
			return sum;
		}

		if ( !isRoot ) {
			sum = sum + root.data;
			
		} else {
			sum = root.data;
		}
		
		int copySum = sum;
		
		if ( root.left != null ) {
			sum = sumNumbers(root.left, false, sum*10);
		}
		
		if ( root.right != null ) {
			
			if ( root.left == null ) sum = sumNumbers(root.right, false, copySum*10);
			else sum += sumNumbers(root.right, false, copySum*10);
		}
		
        return sum;
    }
	public static boolean hasPathSum(BinaryTreeNode<Integer> root, int targetSum) {
		
		boolean result = false;
		
		if ( root == null ) {
			return result;
		}	
		
		
		// root is present 
		targetSum = targetSum - root.data; 
		
		if ( targetSum < 0 ) {
			result = false;
		}
		
		if ( targetSum == 0 && root.left == null && root.right == null ) {
			return true;
		}
		
		if ( targetSum == 0 ) {
			result = false;
		}
		
		if ( root.left != null ) {
			result = hasPathSum(root.left, targetSum);
			if ( result ) return true;
		}
		
		if ( root.right != null ) {
			result = hasPathSum(root.right, targetSum);
			if ( result ) return true;
		}
		
		return result;  
    }
	public static void printLevelWiseBest(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<BinaryTreeNode<Integer>>();
		queue.enQueue(root);
		queue.enQueue(null);
		
		while ( !queue.isEmpty() ) {
			
			BinaryTreeNode<Integer> front = queue.deQueue();
			
			if ( !queue.isEmpty() ) {
				
				if ( front == null ) {
					System.out.println();
					queue.enQueue(null);
				}
				
			
				else {
					System.out.print(front.data + " ");
				
					if ( front.left != null ) {
						queue.enQueue(front.left);
					}
					
					if ( front.right != null ) {
						queue.enQueue(front.right);
					}
				
				}
			
			}
			
		}	
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root, int k) {
		
		if ( root == null ) {
			return;
		}
	
		if ( k == 0 ) {
			System.out.print(root.data + " ");
		}
		
		if ( root.left != null ) System.out.print(root.left.data + " ");
		if ( root.right != null ) System.out.print(root.right.data + " ");
		
		if ( root.left != null ) printLevelWise(root.left, k+1);
		if ( root.right != null ) printLevelWise(root.right, k+1);
		
	}
	public static int[] maxiAndMini(BinaryTreeNode<Integer> root) {
		
		if ( root == null) return null;
		
		int minimum = root.data;
		int maximum = root.data;
		
		if ( root.left != null ) {
			int[] left = maxiAndMini(root.left);
			minimum = Math.min(minimum, left[0]);
			maximum = Math.max(maximum, left[1]);
		}
		
		if ( root.right != null ) {
			int[] right = maxiAndMini(root.right);
			minimum = Math.min(minimum, right[0]);
			maximum = Math.max(maximum, right[1]);
		}
		
		int[] result = {minimum, maximum};
		return result;
	}
	public static BinaryTreeNode<Integer> createAndInsertDuplicate(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return null;
		}
		
		BinaryTreeNode<Integer> duplicateRoot = new BinaryTreeNode<Integer>(root.data);
		BinaryTreeNode<Integer> templeft = root.left;
		
		root.left = duplicateRoot;
		
		duplicateRoot.left = templeft;
		duplicateRoot.left = createAndInsertDuplicate(duplicateRoot.left);
		
		
		if ( root.right != null ) {	
			root.right = createAndInsertDuplicate(root.right);
		}
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> createBinaryTreeCall(int[] pre_order, int[] in_order) {
		return createTree(pre_order, in_order, 0, pre_order.length - 1, 0, in_order.length - 1);
	}
	
	// Optimized
	public static BinaryTreeNode<Integer> createTree(
			int[] preorder, int[] inorder, int preStart, int preEnd, 
			int inorderStart, int inorderEnd) {
		
		if (preStart > preEnd || inorderStart > inorderEnd) {
			return null;
		}
		
		int rootData = preorder[preStart];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		
		int rootIndex = -1;
		
		for (int i = inorderStart; i <= inorderEnd; i++) {
			if ( inorder[i] == rootData ) {
				rootIndex = i;
				break;
			}
		}
		
		if ( rootIndex == -1 ) {
			return null;
		}
		
		// left
		int startindexInorderLeft = inorderStart;
		int endindexInorderLeft = rootIndex - 1;
		int startindexPreLeft = preStart + 1;
		int endindexPreLeft = endindexInorderLeft - startindexInorderLeft + startindexPreLeft;
		
		// right
		int startindexInorderRight = rootIndex + 1;
		int endindexInorderRight = inorderEnd;
		int startindexPreRight = endindexPreLeft + 1;
		int endindexPreRight = preEnd;

		root.left = createTree(preorder, inorder, startindexPreLeft, endindexPreLeft, startindexInorderLeft, endindexInorderLeft);
		root.right = createTree(preorder, inorder, startindexPreRight, endindexPreRight, startindexInorderRight, endindexInorderRight);
						
		return root;
	}
	
	public static int callDiameter(BinaryTreeNode<Integer> root) {
		Pair<Integer, Integer> answer = heightDiameter(root);
		return answer.diameter;
	}

	//Optimized diameter
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return new Pair<Integer, Integer>(0, 0);
		}
		
		Pair<Integer, Integer> lO = heightDiameter(root.left);
		Pair<Integer, Integer> rO = heightDiameter(root.right);
		
		int overAllHeight = 1 + Math.max(lO.height, rO.height);
		int option1 = lO.height + rO.height;
		int option2 = lO.diameter;
		int option3 = rO.diameter;
		int overAllDiameter = Math.max(option1, Math.max(option2, option3));
		
		return new Pair<Integer, Integer>(overAllDiameter, overAllHeight);
		
	}
	
	// major issue with this time complexity we have going to each node and calling for height
	// and also calling recursive diameter call at each node
	// time complexity comes out to be O( n * h )
	public static int diameter(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return 0;
		}
		
		int option1 = heightOftheBinaryTree(root.left) + heightOftheBinaryTree(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.left);

		return Math.max(option1, Math.max(option2, option3));
	}
	
	public static boolean isBalancedBetterCall(BinaryTreeNode<Integer> root) {
		return isBalancedBetter(root).isBalanced;
	}

	public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) return new BalancedTreeReturn(0, true);

		BalancedTreeReturn leftBal = isBalancedBetter(root.left);
		BalancedTreeReturn rightBal = isBalancedBetter(root.right);
		
		boolean isBalanced = true;
		int height = 1 + Math.max(leftBal.height, rightBal.height);
		
		if ( Math.abs( leftBal.height - rightBal.height ) > 1 ) {
			isBalanced = false;
		}
		
		if ( !leftBal.isBalanced || !rightBal.isBalanced ) {
			isBalanced = false;
		}
		
		return new BalancedTreeReturn(height, isBalanced);
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) return true;

		int leftHeight = heightOftheBinaryTree(root.left);
		int rightHeight = heightOftheBinaryTree(root.right);
		
		if ( Math.abs( leftHeight - rightHeight ) > 1 ) {
			return false;
		}
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		
		return left && right;
	}

	public static BinaryTreeNode<Integer> mirrorBinaryTree( BinaryTreeNode<Integer> root ) {
		
		if ( root == null ) {
			return root;
		}
		
		BinaryTreeNode<Integer> tempRight = null;
		
		if ( root.right != null ) {
			tempRight = root.right;
		}
		
		if ( root.left != null )  {
			root.right = mirrorBinaryTree(root.left);
		}
	
		if ( root.right != null ) {
			root.left = mirrorBinaryTree(tempRight);
		}
		
		return root;
	}
	public static BinaryTreeNode<Integer> removeLeafNode(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			return null;
		}
		
		if ( root.left == null && root.right == null )  {
			return null;
		}
		
		if ( root.left != null ) {
			root.left = removeLeafNode(root.left);
		}
		
		if ( root.right != null ) {
			root.right = removeLeafNode(root.right);
		}
		
		return root;
	}
	
	public static void postOrder(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		if ( root.left != null )  {
			postOrder(root.left);
		}
	
		if ( root.right != null ) {
			postOrder(root.right);
		}
		
		System.out.print(root.data + " ");
		
	}

	public static void preOrder(BinaryTreeNode<Integer> root) {

		if ( root == null ) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		if ( root.left != null )  {
			preOrder(root.left);
		}
	
		if ( root.right != null ) {
			preOrder(root.right);
		}
		
	}
	
	public static void inOrder(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
		
		if ( root.left != null )  {
			inOrder(root.left);
		}
		
		System.out.print(root.data + " ");
	
		if ( root.right != null ) {
			inOrder(root.right);
		}
		
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

	public static void KDepthNodes(BinaryTreeNode<Integer> root, int k) {
		
		if ( root == null || k == 0) {
			return;
		}
		
		if ( k == 1 ) {
			System.out.print(root.data + " ");
		}
		
		if ( root.left != null )  {
			KDepthNodes(root.left, k-1);
		}
		
		if ( root.right != null ) {
			KDepthNodes(root.right, k-1);
		}

	}
	public static int heightOftheBinaryTree(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			return 0;
		}
		
		// initially if root is present that means height = 1;
		int maximumHeight = 0;
		
		if ( root.left != null )  {
			int leftHeight = heightOftheBinaryTree(root.left);
			maximumHeight = leftHeight;
		}
		
		if ( root.right != null ) {
			int rightHeight = heightOftheBinaryTree(root.right);
			if ( maximumHeight < rightHeight ) {
				maximumHeight = rightHeight;
			}
		}
		
		return 1 + maximumHeight;
	}
	
	public static int nodeWithLargestData(BinaryTreeNode<Integer> root) {

		if ( root == null ) {
			return 0;
		}
		
		int largestNode = root.data;
		
		 
		if ( root.left != null )  {
			int leftLargest = nodeWithLargestData(root.left);
			if ( leftLargest > largestNode ) {
				largestNode = leftLargest;
			} 
		}
		
		if ( root.right != null ) {
			int rightLargest = nodeWithLargestData(root.right);
			largestNode = Math.max(rightLargest , largestNode);
		}
		
		return largestNode;
	}

	public static int numberOfNodes(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			return 0;
		}
		
		int numOfNodes = 1;

		if ( root.left != null ) numOfNodes += numberOfNodes(root.left);
		if ( root.right != null ) numOfNodes += numberOfNodes(root.right);
		
		return numOfNodes;
	}
	
	public static void printBinaryTreeBest(BinaryTreeNode<Integer> root ) {
		
		if ( root == null ) {
			return;
		}
		
		System.out.print(root.data + ": ");
		
		if ( root.left != null ) {
			System.out.print( "L"+root.left.data + ",");
		}
		
		if ( root.right != null ) {
			System.out.print( "R"+ root.right.data + ",");
		}
		
		System.out.println();
		printBinaryTreeBest(root.left);
		printBinaryTreeBest(root.right);
		

	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		
		Scanner sc = new Scanner(System.in);
		
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		
		System.out.println("Enter root data : ");
		int rootData = sc.nextInt();
		
		if ( rootData == -1 ) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enQueue(root);
		
		while ( !pendingNodes.isEmpty() ) {
			
			BinaryTreeNode<Integer> front = pendingNodes.deQueue();
			
			System.out.println("Enter left child of " + front.data);
			int leftChild = sc.nextInt();
			if ( leftChild != -1 ) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftChild);
				front.left = left;
				pendingNodes.enQueue(left);
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = sc.nextInt();
			if ( rightChild != -1 ) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightChild);
				front.right = right;
				pendingNodes.enQueue(right);
			}
			
		}
		
		return root;
	}
		
	public static BinaryTreeNode<Integer> buildBinaryTree( ) {
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> rootLeftLeft = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> rootLeftRight = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> rootRightLeft = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> rootRightRight = new BinaryTreeNode<Integer>(7);
		
		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = rootLeftLeft;
		rootLeft.right = rootLeftRight;
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		
		return root;
	}

	public static BinaryTreeNode<Integer> takeInput(Scanner sc){
		
		System.out.println("Enter root data : ");
		int rootData = sc.nextInt();
		
		if ( rootData == -1 ) {
			return null;
		}
		 
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
//		System.out.println("Enter left data : ");
//		int leftRootData = sc.nextInt();
		root.left = takeInput(sc);
		
//		System.out.println("Enter right data : ");
//		int rightNodeData = sc.nextInt();
		root.right = takeInput(sc);
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeInputBetter(Boolean isRoot, int rootData, Boolean isLeft){
		
		Scanner sc  = new Scanner(System.in);
		
		if ( isRoot ) {
			System.out.println("Enter root data : ");
			rootData = sc.nextInt();
		} 
		
		else {
			
			if ( isLeft ) {
				System.out.println("Enter left data of " + rootData);
				rootData = sc.nextInt();
			} 
			else {
				System.out.println("Enter right data of " + rootData);
				rootData = sc.nextInt();
			}
		}
		
		if ( rootData == -1 ) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		root.left = takeInputBetter(false, rootData, true);
		root.right = takeInputBetter(false, rootData, false);
		
		return root;
		
	}
	
	public static void printBinaryTree(BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
			return;
		}
	
		System.out.print(root.data + " ");

		printBinaryTree(root.left);
		printBinaryTree(root.right);
		
	}
	
	
}
