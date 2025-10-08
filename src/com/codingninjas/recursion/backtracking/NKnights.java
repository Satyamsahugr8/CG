package com.codingninjas.recursion.backtracking;

import java.util.ArrayList;

class Three <T,U,V> {
	T first;
	U second;
	V third;
	
	public Three(T first, U second, V third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	
}

public class NKnights {

	public static void main(String[] args) {
		
		int[][] board = new int[5][5];
//		placeKnights(board, 0, 0, 4);
		
//		int kNightStartPointi = 2;
//		int kNightStartPointj = 2;
		
		moveKnight(board, 2, 2);
		
	}
	
	public static void moveKnight(int[][] board, Integer row, Integer col) {
		
		int n = board.length;
		
		// no moves return 
		
		
		Three<Boolean, Integer, Integer> item = isValidAndMove(board, row, col);
		
//		if ( item.first ) {
//			moveKnight(board, item.second, item.third);
//		}
		
//		else {
		if ( item.first == false ) {
			System.out.println();
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
 		
		
	}
	
	public static void placeKnights(int[][] board, int row, int col, int kcount) {

		int n = board.length;

		if (kcount == 0) {

			// valid
			System.out.println();
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();

			// reset Kcount
			
//			kcount = kcount + 1;
			return;
		}

		if (col == n ) {
			row = row + 1;
			col = 0;
		}

		if ( row == n) return;
		
		// check for all cols
		System.out.println("row : " + row);
		System.out.println("col : " + col);
		System.out.println("kcount : " + kcount);
		System.out.println("isvaild : " + isValid(board, row, col));

		if ( isValid(board, row, col) ) {
			
			int tempRow = row;
			int tempCol = col;
			
			board[row][col] = 1;
			placeKnights(board, row, col + 1, kcount - 1);
			board[tempRow][tempCol] = 0;

		} else {
			placeKnights(board, row, col + 1, kcount);
		}

	}
	
	public static ArrayList<ArrayList<Integer>> placeQueensReturnBoardArrayList(int[][] board, int row, int col) {
		
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
			
			return null;
		}
		
		// check for all cols
		for (int i = 0; i < n; i++) {
			
			// check if its safe to place queen
			// before placing check

//			System.out.println("row : " + row);
//			System.out.println("i : " + i);
//			System.out.println("isvaild : " + isValid(board, row, i));
			
			if ( isValid(board, row, i) ) {
				board[row][i] = 1;
//				placeQueens(board, row+1, i);
				board[row][i] = 0;
			}
		}
		return null;
		
	}
	
	private static Three<Boolean, Integer, Integer> isValidAndMove(int[][] board, Integer row, Integer col) {

		int n = board.length;
		board[row][col] = 1;

		// up right
		if (row - 2 >= 0 && row - 2 < n && col + 1 >= 0 && col + 1 < n) {
			if (board[row - 2][col + 1] != 1) {
//				board[row][col] = 1;
				 if (!isValidAndMove(board, row-2, col+1).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row-2, col+1);
			}

		}

		// right top
		if (col + 2 >= 0 && col + 2 < n && row - 1 >= 0 && row - 1 < n) {
			if (board[row - 1][col + 2] != 1) {
//				board[row][col] = 1;
//				isValidAndMove(board, row-1, col+2);
				if (!isValidAndMove(board, row-1, col+2).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row-1, col+2);
			}

		}

		// right down
		if ( col + 2 >= 0 && col + 2 < n && row + 1 < n && row + 1 >= 0 ) {
			if (board[row + 1][col + 2] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row+1, col+2).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row+1, col+2);
			}
			
		}

		// down right
		if ( row + 2 >= 0 && row + 2 < n && col + 1 >= 0 && col + 1 < n ) {
			if (board[row + 2][col + 1] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row+2, col+1).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row+2, col+1);
			}
		}
		
		//down left
		if ( row + 2 >= 0 && row + 2 < n && col - 1 >= 0 && col - 1 < n ) {
			if (board[row + 2][col - 1] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row+2, col-1).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row+2, col-1);

			}
		}

		// left down
		if ( col - 2 >= 0 && col - 2 < n && row + 1 < n && row + 1 >= 0) {
			if (board[row + 1][col - 2] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row+1, col-2).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row+1, col-2);

			}
		}
		
		// left top
		if ( col - 2 >= 0 && col - 2 < n && row - 1 >= 0 && row - 1 < n ) {
			if (board[row - 1][col - 2] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row-1, col-2).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row-1, col-2);

			}
		}
		
		// up left
		if ( row - 2 >= 0 && row - 2 < n && col - 1 >= 0 && col - 1 < n ) {
			if (board[row - 2][col - 1] != 1) {
//				board[row][col] = 1;
				if (!isValidAndMove(board, row-2, col-1).first ) return new Three<Boolean, Integer, Integer>(false, row, col);
//				return new Three<Boolean, Integer, Integer>(true, row-2, col-1);
			}
		}

		return new Three<Boolean, Integer, Integer>(false, row, col);
	}
	
	private static boolean isValid(int[][] board, Integer row, Integer col) {
		
		int n = board.length;
		
		// up right
		if ( row - 2 >= 0 && row - 2 < n && col + 1 >= 0 && col + 1 < n) {
			if ( board[row - 2][col - 1] == 1 ) {
				return false;
			}
			else if ( board[row - 2][col - 1] == 1 ) {
				return false;
			}
		}
		
		// up left
		if ( row - 2 >= 0 && row - 2 < n && col - 1 >= 0 && col - 1 < n ) {
			
		}

		// down left/right
		if ( row + 2 >= 0 && row + 2 < n && col - 1 >= 0 && col - 1 < n && col + 1 >= 0 && col + 1 < n) {
			if ( board[row + 2][col - 1] == 1 ) {
				return false;
			}
			else if ( board[row + 2][col - 1] == 1 ) {
				return false;
			}
		}
		
		// right top/down
		if ( col + 2 >= 0 && col + 2 < n && row - 1 >= 0 && row + 1 < n && row - 1 < n && row + 1 >= 0) {
			if ( board[row - 1][col + 2] == 1 ) {
				return false;
			}
			else if ( board[row + 1][col + 2] == 1 ) {
				return false;
			}
		}
		
		// left top/down
		if ( col - 2 >= 0 && col - 2 < n && row - 1 >= 0 && row + 1 < n && row - 1 < n && row + 1 >= 0) {
			if ( board[row - 1][col - 2] == 1 ) {
				return false;
			}
			else if ( board[row + 1][col - 2] == 1 ) {
				return false;
			}
		}
		
		return true;
	}

}
