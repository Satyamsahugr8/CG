package com.codingninjas.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int source;
	int neighbor;
	int weight;
	
	public Edge(int source, int neigbhor, int weight) {
		super();
		this.source = source;
		this.neighbor = neigbhor;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
	

}

public class GraphUsingAdjacencyList {

	public static void main(String[] args) throws Exception {
		
		//input
//		ArrayList<Edge>[] graph = getInput();
//		
//		//hasPath
//		boolean dd = hasPath(graph);
//		System.out.println(dd);
//		
//		//dfs
//		System.out.print("DFS : ");
//		depthFirstSearch(graph);
//		
//		System.out.println();
//		
//		//bfs
//		System.out.print("BFS : ");
//		birthFirstSearch(graph);
		
		//krushal's Algorithm
//		krushalsAlgo();
		
		
	}
	
	private static void krushalsAlgo() {
		
		// number of vertices is n
		// number of edge's are n - 1;
		
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
	
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int edges = sc.nextInt();
		Edge[] edgeArray = new Edge[edges];
		int j = 0;
		
		for (int i = 0; i < edges; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			edgeArray[j] = new Edge(v1,v2,wt);
			graph[v2].add(new Edge(v2,v1,wt));
			j++;
		}
		
		sc.close();
		
		// sort edgeArray wrt weight
		Arrays.sort(edgeArray);
		
		Edge[] mst = krushalAlgorithm(edgeArray, vertices);
		
		// create graph using mst
		for (int i = 0; i < mst.length; i++) {
			if ( mst[i].source < mst[i].neighbor) {
				System.out.print( mst[i].source + " " + mst[i].neighbor + " " + mst[i].weight );
			}
			else {
				System.out.print( mst[i].neighbor + " " + mst[i].source + " " + mst[i].weight );
			}
			System.out.println();
		}
		
	}
	
	
	public static Edge[] krushalAlgorithm(Edge[] edges, int n) {
		
		Edge[] mst = new Edge[n-1];
		int parent [] = new int[n];
		
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		int i = 0;
		
		while ( count != n -1 ) {
			Edge currentEdge = edges[i++];
			int v1Parent = findParent(currentEdge.source, parent);
			int v2Parent = findParent(currentEdge.neighbor, parent);
			
			if ( v1Parent != v2Parent ) {
				// includ
				mst[count] = currentEdge;
				count++;
				parent[v1Parent] = parent[v2Parent];
			}
			
		}
		
		return mst;
	}

	private static int findParent(int source, int[] parent) {
		
		if ( source == parent[source] ) {
			return source;
		}
		
		return findParent(parent[source], parent);
		
	}

	//BFS
	public static void birthFirstSearch(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		birthFirstSearch(graph, 0, visited);
	}

	private static void birthFirstSearch(ArrayList<Edge>[] graph, int i, boolean[] visited) {
		
		Queue<Integer> pendingQueue = new LinkedList<Integer>();
		pendingQueue.add(i);
		visited[i] = true;

		while( !pendingQueue.isEmpty() ) {
			
			int elem = pendingQueue.poll();
			System.out.print(elem + " ");
			
			for (Edge edge: graph[elem]) {
				if ( visited[edge.neighbor] == false ) {
					pendingQueue.add(edge.neighbor);
					visited[edge.neighbor] = true;
				}
			}
			
		}
		
		
	}

	//DFS
	public static void depthFirstSearch(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		depthFirstSearch(graph, 0, visited);
		
	}
	private static void depthFirstSearch(ArrayList<Edge>[] graph, int i, boolean[] visited) {
		
		visited[i] = true;
		System.out.print(i + " ");
		
		for (Edge edge: graph[i]) {
			if ( visited[edge.neighbor] == false ) {
				depthFirstSearch(graph, edge.neighbor, visited);
			}
		}
		
	}


	public static boolean hasPath(ArrayList<Edge>[] graph) throws Exception {
		
		Scanner sc = new Scanner(System.in);
//		int vertices = sc.nextInt();
//		
//		@SuppressWarnings("unchecked")
//		ArrayList<Edge>[] graph = new ArrayList[vertices];
//		for (int i = 0; i < vertices; i++) {
//			graph[i] = new ArrayList<>();
//		}
//		
//		int edges = sc.nextInt();
//		
//		for (int i = 0; i < edges; i++) {
//			int v1 = sc.nextInt();
//			int v2 = sc.nextInt();
//			int wt = sc.nextInt();
//			graph[v1].add(new Edge(v1,v2,wt));
//			graph[v2].add(new Edge(v2,v1,wt));
//		}
		
		System.out.println("Enter source and destination : ");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		
		boolean visited[] = new boolean[graph.length];
		sc.close();
		return hasPath(graph, source, destination, visited);
	}
	
	private static boolean hasPath(ArrayList<Edge>[] graph, int source, int destination, boolean[] visited) {
		
		if ( source == destination ) {
			return true;
		}
		
		visited[source] = true;
		
		for (Edge edge: graph[source]) {
			System.out.println(edge.neighbor);
			if ( visited[edge.neighbor] == false ) {
				boolean b = hasPath(graph, edge.neighbor, destination, visited);
				if ( b ) {
					return b;
				}
			}
		}
		return false;
	}
	
	public static ArrayList<Edge>[] getInput() {
		
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
//				Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int edges = sc.nextInt();
		
		for (int i = 0; i < edges; i++) {
//			String[] parts = br.readLine().split(" ");
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		
		sc.close();
		return graph;
	}

	public static ArrayList<Edge>[] getInput2() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vertices = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int edges = Integer.parseInt(br.readLine()); 
		
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v1,v2,wt));
		}
		
		return graph;
	}
	
}
