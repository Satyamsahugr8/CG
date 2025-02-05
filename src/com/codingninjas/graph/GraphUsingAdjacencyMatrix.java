package com.codingninjas.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GraphUsingAdjacencyMatrix<T> {
	
	int n;
	int [][] matrix;
	
	public GraphUsingAdjacencyMatrix(int n) {
		super();
		this.n = n;
		this.matrix = new int[n][n];
	}
	
	public static void main(String[] args) {
		
		//input
		int adjMatrix[][] = inputGraph();
		
		//dfs
		System.out.print("dfs : ");
		depthFirstSearch(adjMatrix);
//		
//		//bfs
//		System.out.print("bfs : ");
//		birthFirstSearch(adjMatrix);
//		
//		//hasPath return ArrayList
//		System.out.print("hasPathDFS : ");
//		boolean[] visited = new boolean[adjMatrix.length];
//		ArrayList<Integer> arrList = hasPath(adjMatrix, 0, 6, visited);
//		System.out.println(arrList);
//		
//		//hasPath return hasPath2
//		System.out.print("hasPathBFS : ");
//		boolean[] visited2 = new boolean[adjMatrix.length];
//		ArrayList<Integer> arrList2 = hasPath2(adjMatrix, 0, 6, visited2);
//		System.out.println(arrList2);
		
		// int adjMatrix[][] = inputGraphWithWeight();
		// primalgorithm(adjMatrix);
		
		
	}

	private static void primalgorithm(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean visited[] = new boolean[n];
		int parent[] = new int[n];
		int weight[] = new int[n];
		
		//source - vertex 0;
		parent[0] = -1;
		weight[0] = 0;
		
		for (int i = 1; i < n; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < n; i++) {
			int minVertex = findMinVertex(visited, weight);
			visited[minVertex] = true;
			
			//Explore neighbor of minVertex
			for (int j = 0; j < n; j++) {
				if ( adjMatrix[minVertex][j] != 0 && !visited[j] ) {
					if ( weight[j] > adjMatrix[minVertex][j] ) {
						weight[j] = adjMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		
		//print MST
		for (int i = 1; i < n; i++) {
			System.out.println(i+ " " + parent[i] + " " + weight[i]);
//			if ( i < parent[i] ) {
//				System.out.println(i+ " " + parent[i] + " " + weight[i]);
//			}
//			else {
//				System.out.println(parent[i]+ " " + i + " " + weight[i]);
//			}
		}
		
	}

	private static int findMinVertex(boolean[] visited, int[] weight) {
		
		int minVertex = -1;
		for (int i = 0; i < visited.length; i++) {
			if ( !visited[i] && ( minVertex == -1 || weight[i] < weight[minVertex] ) ) {
				minVertex = i;
			}
		}
		
		return minVertex;
	}

	// hasPath DFS
	private static ArrayList<Integer> hasPath(int[][] adjMatrix, int source, int destination, boolean[] visited) {
		
		if ( source == destination ) {
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			arrList.add(source);
			return arrList;
		}
		
		visited[source] = true;
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(source);
		
		for (int i = 0; i < adjMatrix.length; i++) {
			if ( adjMatrix[source][i] == 1 && visited[i] == false )  {
				arrList.addAll(hasPath(adjMatrix, i, destination, visited));
				return arrList;
			}
		}
		
		return arrList;
	}
	
	
	// hasPath BFS
	private static ArrayList<Integer> hasPath2(int[][] adjMatrix, int source, int destination, boolean[] visited) {
		
		Queue<Integer> pendingQueue = new LinkedList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		
		visited[source] = true;
		pendingQueue.add(source);
		
		while ( !pendingQueue.isEmpty() ) {
			
			int element = pendingQueue.poll();
//			System.out.print(element + " ");
			
			for (int j = 0; j < adjMatrix.length; j++) {
				
				if ( adjMatrix[element][j] == 1 && visited[j] == false ) {
			
					visited[j] = true;
					pendingQueue.add(j);
					map.put(j, element);
					
					if ( j == destination ) {
					
						int temp = j;
						while ( temp != 0 ) {
							arrList.add(temp);
							temp = map.get(temp);
						}
						
						arrList.add(0);
						
						return arrList;
					}
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	public static int[][] inputGraphWithWeight() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Vertices : ");
		System.out.println("Enter Number of Edges : ");
		System.out.println("Enter Vertices of Edges : ");
		
		int n = sc.nextInt();
		int e = sc.nextInt();
		int adjMatrix[][] = new int[n][n];
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				System.out.print(adjMatrix[i][j]);
			}
			System.out.println();
		}
		sc.close();
		
		return adjMatrix;
	}
	
	public static int[][] inputGraph() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Vertices : ");
		System.out.println("Enter Number of Edges : ");
		System.out.println("Enter Vertices of Edges : ");
		
		int n = sc.nextInt();
		int e = sc.nextInt();
		int adjMatrix[][] = new int[n][n];
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				System.out.print(adjMatrix[i][j]);
			}
			System.out.println();
		}
		sc.close();
		
		return adjMatrix;
	}
	
	//DFS
	
	//DFS
	public static void depthFirstSearch(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		
		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if ( visited[i] == false ) {
				depthFirstSearch(adjMatrix, i, visited);
				count++;
				System.out.println();
			}
		}

		System.out.println(count);
		
	}
	private static void depthFirstSearch(int[][] adjMatrix, int currVertice, boolean[] visited) {
		
		visited[currVertice] = true;
		
		System.out.print(currVertice + " ");
		
		for (int j = 0; j < adjMatrix.length; j++) {
			if ( adjMatrix[currVertice][j] == 1 && visited[j] == false ) {
				depthFirstSearch(adjMatrix, j, visited);
			}
		}
		
	}
	

	//BFS
	public static void birthFirstSearch(int[][] adjMatrix) {
		boolean[] visited = new boolean[adjMatrix.length];
		
		for (int i = 0; i < visited.length; i++) {
			if ( visited[i] == false ) {
				breadthFirstSearch(adjMatrix, i, visited);
				System.out.println();
			}
		}
	}

	private static void breadthFirstSearch(int[][] adjMatrix, int i, boolean[] visited) {
		
		Queue<Integer> pendingQueue = new LinkedList<Integer>();
		visited[i] = true;
		pendingQueue.add(i);
		
		while ( !pendingQueue.isEmpty() ) {
			
			int element = pendingQueue.poll();
			System.out.print(element + " ");
			
			for (int j = 0; j < adjMatrix.length; j++) {
				
				if ( adjMatrix[element][j] == 1 && visited[j] == false ) {
					visited[j] = true;
					pendingQueue.add(j);
				}
			}
			
			
		}
		
	}
	
}
