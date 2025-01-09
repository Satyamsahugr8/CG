package com.codingninjas.resursion.backtracking;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeNQueens(4);
	}
	
	public static void placeNQueens(int n) {
		int board[][] = new int[n][n];
		placeQueens(board, 0, 0);
	}
	
	public static void placeQueens(int[][] board, int row, int col) {
		
		int n = board.length;
		
		if ( row == n ) {
			
			// valid
			System.out.println();
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(board[r][c]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			return;
		}
		
		// check for all cols
		
		
		for (int i = 0; i < n; i++) {
			
			// check if its safe to place queen
			// before placing check

			System.out.println("row : " + row);
			System.out.println("col : " + col);
			System.out.println("isvaild : " + isValid(board, row, col));
			
			if ( isValid(board, row, col) ) {	
				board[row][i] = 1;
				placeQueens(board, row+1, i);
				board[row][i] = 0;
			}
		}
		
	}

	private static boolean isValid(int[][] board, int row, int col) {
		
		int n = board.length;
		
		// up
		for (int i = 0; i < row; i++) {
			if ( board[i][col] == 1 ) {
				return false;
			}
		}
		
		// down
		for (int i = row + 1; i < n; i++) {
			if ( board[i][col] == 1 ) {
				return false;
			}
		}
		
		// right
		for (int i = col+1; i < n; i++) {
			if ( board[row][i] == 1 ) {
				return false;
			}
		}
		
		// left
		for (int i = 0; i < col; i++) {
			if ( board[row][i] == 1 ) {
				return false;
			}
		}
		
		// topleft
		for (int r = row-1, c = col-1; r >= 0 && r < n && c >= 0 && c< board.length; c--,r--) {
			if ( board[r][c] == 1 ) {
				return false;
			}
		}
		
		// topright
		for (int r = row-1, c = col+1; r >= 0 && r < n 
				&& c >= 0 && c< n; c++,r--) {
			if ( board[r][c] == 1 ) {
				return false;
			}
		}
		
		// downleft
		for (int r = row+1, c = col-1; r >= 0 && r < n 
				&& c >= 0 && c< n; c--,r++) {
			if ( board[r][c] == 1 ) {
				return false;
			}
		}
		
		// downright
		for (int r = row+1, c = col+1; r >= 0 && r < n 
				&& c >= 0 && c< n; c++,r++) {
			if ( board[r][c] == 1 ) {
				return false;
			}
		}
		
		return true;
	}

}
