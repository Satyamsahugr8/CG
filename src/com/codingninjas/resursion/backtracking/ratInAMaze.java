package com.codingninjas.resursion.backtracking;

public class ratInAMaze {
	
	public static void main(String[] args) {

		int maze[][] = {{1,1,0},{1,1,0},{0,1,1}};
		int n = maze.length;
		
		System.out.println("maze : ");
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(maze[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
//		int maze[][] = {{1,1,0},{1,0,0},{0,1,1}};
//		System.out.println(ratInMaze(maze));
		
		int dn = maze.length;
		int[][] path = new int[n][n];
		solveMaze2(maze, 0, 0, path);
	}

	private static boolean ratInMaze(int[][] maze) {
		int n = maze.length;
		int[][] path = new int[n][n];
//		solveMaze2(maze, 0, 0, path);
//		System.out.println();
		return solveMaze(maze, 0, 0, path);
	}

	private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		
		int n = maze.length;
		
		// check if i,j is valid cell
		if ( i < 0 || i >= n || j < 0 || j>= n || maze[i][j] == 0 || path[i][j] == 1 ) {
			return false;
		}
		
		// include the cell in current path 
		path[i][j] = 1;
		
		// check if destination 
		if ( i == n-1 && j == n-1 ) {
			return true;
		}
		
		// Explore further in all direc.
		//top
		if ( solveMaze(maze, i-1, j, path)) return true;
		//right
		if ( solveMaze(maze, i, j + 1, path)) return true;
		//bottom
		if ( solveMaze(maze, i+1, j, path)) return true;
		//left
		if ( solveMaze(maze, i, j-1 , path)) return true;
		
		
		return false;
	}

	private static void solveMaze2(int[][] maze, int i, int j, int[][] path) {
		
		int n = maze.length;
		
		// check if i,j is valid cell
		if ( i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1 ) {
			return;
		}
		
		// include the cell in current path 
		path[i][j] = 1;
		
		// check if destination 
		if ( i == n-1 && j == n-1 ) {
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			System.out.println();
			path[i][j] = 0;
			return;
		}
		 
		// Explore further in all direc.
		//top
		solveMaze2(maze, i-1, j, path);
		//right
		solveMaze2(maze, i, j+1, path);
		//bottom
		solveMaze2(maze, i+1, j, path);
		//left
		solveMaze2(maze, i, j-1 , path);
		
		path[i][j] = 0;
	}
}
