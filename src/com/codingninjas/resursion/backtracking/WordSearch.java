package com.codingninjas.resursion.backtracking;

public class WordSearch {

	public static void main(String[] args) {
		
		char [][]board = {{'G','e','G','k','Q','I'},{'T','g','x','x','k','j'},
				{'G','w','i','O','s','T'},{'K','Z','W','O','M','h'},{'M','E','q','i','t','o'},
				{'B','R','J','K','p','z'}};
		String word = "JqEZWOitpK";
		char[] charArray = word.toCharArray();
		
		boolean answer = wordSearch(board, charArray);
		System.out.println(answer);
	}

	private static boolean wordSearch(char[][] board, char[] charArray) {
		
		boolean[][] boardBoo = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
					if ( wordSearch(board, charArray, boardBoo, i, j, 0) ) return true;
			}
		} 
		
		return false;
		
	}

	private static boolean wordSearch(char[][] board, char[] charArray, boolean[][] boardBoo, int i, int j, int k) {
		
		// beyond limit
		if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return false;
		
		// check for current word 
		if ( k < charArray.length && board[i][j] != charArray[k] ) return false;
		
		System.out.println(i + "  " + j);
		
		// mark current visited
		boardBoo[i][j] = true;
		
		if ( k == charArray.length - 1 ) return true;
		
		//explore all possible path - top right bottom left
		if ( i - 1 >= 0 && boardBoo[i - 1][j] != true &&  wordSearch(board, charArray, boardBoo, i - 1, j, k + 1)) return true;
		else if ( j + 1 < boardBoo[i].length && boardBoo[i][j + 1] != true &&  wordSearch(board, charArray, boardBoo, i, j + 1, k + 1)) return true;
		else if ( i + 1 < boardBoo.length && boardBoo[i + 1][j] != true &&  wordSearch(board, charArray, boardBoo, i + 1, j, k + 1)) return true;
		else if ( j - 1 >= 0 && boardBoo[i][j - 1] != true &&  wordSearch(board, charArray, boardBoo, i, j - 1, k + 1)) return true;
		
		boardBoo[i][j] = false;
		
		return false;
	}

}
