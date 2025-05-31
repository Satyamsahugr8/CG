package com.codingninjas.resursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeNQueens(5);
//		List<List<String>> ss = solveNQueens(4);
//		ArrayList<ArrayList<Integer>> ss = solveNQueensListNum(4);
//		for (List<Integer> list : ss) {
////			for (String str : list) {
////				System.out.print(str);
////			}
//
//			System.out.println(list);
//		}
////		
//		System.out.println(ss.size());
		
	}
	
	public static void placeNQueens(int n) {
		int board[][] = new int[n][n];
		placeQueens(board, 0, 0);
		
	}
	
	public static ArrayList<ArrayList<Integer>> solveNQueensListNum(int n) {
		
		int board[][] = new int[n][n];
		return placeQueensReturnBoardListNum(board, 0, 0);
//		return null;
    }
	
	private static ArrayList<ArrayList<Integer>> placeQueensReturnBoardListNum(int[][] board, int row, int col) {
		
		int n = board.length;
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if ( row == n ) {
			
			// valid
			for (int r = 0; r < n; r++) {
				
				for (int c = 0; c < n; c++) {
					currentList.add(board[r][c]);
				}
				
				
			}list.add(currentList);
			
			return list;
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
				list.addAll(placeQueensReturnBoardListNum(board, row+1, i));
				board[row][i] = 0;
			}
		}
		
		return list;
		
	}

	public static List<List<String>> solveNQueens(int n) {
		List<String> board = new ArrayList<String>(n);
		for (int r = 0; r < n; r++) {
            String s = "";
            for (int c = 0; c < n; c++) {
			    s = s + ".";
            }
            board.add(s);
		}
		
		String[][] input = new String[n][n];
		
		for (int i = 0; i < input.length; i++) {
			String row1 = board.get(i);
			for (int j = 0; j < input.length; j++) {
				input[i][j] = row1.charAt(j) + "";
			}
		}
		
		return placeQueensReturnBoardList(input, 0, 0);
//		return null;
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

//			System.out.println("row : " + row);
//			System.out.println("i : " + i);
//			System.out.println("isvaild : " + isValid(board, row, i));
			
			if ( isValid(board, row, i) ) {
				board[row][i] = 1;
				placeQueens(board, row+1, i);
				board[row][i] = 0;
			}
		}
		
	}
	
	public static List<List<String>> placeQueensReturnBoardList(String[][] board, 
			int row, int col) {
		
		int n = board.length;
		List<String> currentList = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();
		
		if ( row == n ) {
			
			
			// valid
//			System.out.println();
			for (int r = 0; r < n; r++) {
				StringBuilder strb = new StringBuilder();
				for (int c = 0; c < n; c++) {
//					System.out.print(board[r][c]);
					strb.append(board[r][c]);
				}
				currentList.add(strb.toString());
//				System.out.println();
			}
//			System.out.println();
			list.add(currentList);
			return list;
		}
		
		// check for all cols
		for (int i = 0; i < n; i++) {
			
			// check if its safe to place queen
			// before placing check

//			System.out.println("row : " + row);
//			System.out.println("i : " + i);
//			System.out.println("isvaild : " + isValid(board, row, i));
			
			if ( isValidString(board, row, i) ) {
				board[row][i] = "Q";
				list.addAll(placeQueensReturnBoardList(board, row+1, i));
				board[row][i] = ".";
			}
		}
		
		return list;
		
	}
	
	private static boolean isValidString(String[][] board, int row, int col) {
		
		int n = board.length;
		
		// up
		for (int i = 0; i < row; i++) {
			if ( board[i][col] == "Q" ) {
				return false;
			}
		}
		
		// down
		for (int i = row + 1; i < n; i++) {
			if ( board[i][col] == "Q" ) {
				return false;
			}
		}
		
		// right
		for (int i = col+1; i < n; i++) {
			if ( board[row][i] == "Q" ) {
				return false;
			}
		}
		
		// left
		for (int i = 0; i < col; i++) {
			if ( board[row][i] == "Q" ) {
				return false;
			}
		}
		
		// topleft
		for (int r = row-1, c = col-1; r >= 0 && r < n && c >= 0 && c< board.length; c--,r--) {
			if ( board[r][c] == "Q" ) {
				return false;
			}
		}
		
		// topright
		for (int r = row-1, c = col+1; r >= 0 && r < n 
				&& c >= 0 && c< n; c++,r--) {
			if ( board[r][c] == "Q" ) {
				return false;
			}
		}
		
		// downleft
		for (int r = row+1, c = col-1; r >= 0 && r < n 
				&& c >= 0 && c< n; c--,r++) {
			if ( board[r][c] == "Q" ) {
				return false;
			}
		}
		
		// downright
		for (int r = row+1, c = col+1; r >= 0 && r < n 
				&& c >= 0 && c< n; c++,r++) {
			if ( board[r][c] == "Q" ) {
				return false;
			}
		}
		
		return true;

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
				placeQueens(board, row+1, i);
				board[row][i] = 0;
			}
		}
		return null;
		
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
		for (int r = row-1, c = col+1; r >= 0 && r < n && c >= 0 && c< n; c++,r--) {
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
