package com.codingninjas.recursion.backtracking;

public class Islandcount {

    public static void main(String[] args) {

        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },{ '0', '0', '0', '0', '0' } };

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        char[][] grid3 = {{'1'}};
        int g = numIslands(grid3);
        System.out.println(g);
    }

    public static int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {

                if (visited[i][j] != true ) {
                    int curr = numIslands(grid, visited, i, j);

                    // if ( curr == 1 ) {
                    //     for (int r = 0; r < visited.length; r++) {
                    //         for (int c = 0; c < visited[r].length; c++) {
                    //             System.out.print(visited[r][c]+" ");
                    //         }
                    //         System.out.println();
                    //     }
                    //     System.out.println();
                    // }
                    count += curr;
                }
                
            }
        }

        return count;
    }

    public static int numIslands(char[][] grid, boolean[][] visited, int i, int j) {

        int mark = 0;

        if (grid[i][j] == '1' && visited[i][j] == false) {

            mark = 1;
            //mark current visited
            visited[i][j] = true;

            // check top
            // if (isvalidMove(grid, visited, i - 1, j)) {
            //     numIslands(grid, visited, i-1, j);
            // }
            
            //right
            if (isvalidMove(grid, visited, i, j + 1)) {
                numIslands(grid, visited, i, j+1);
            }

            //down
            if (isvalidMove(grid, visited, i + 1, j)) {
                numIslands(grid, visited, i+1, j);
            }

            // left
            // if (isvalidMove(grid, visited, i, j - 1)) {
            //     numIslands(grid, visited, i, j-1);
            // }
        }

        

        return mark;
    }

    public static boolean isvalidMove(char[][] grid, boolean visited[][], int i, int j) {
        
        int n = grid.length;
        int m = grid[0].length;

        if ( i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0' || visited[i][j] == true ) {
			return false;
		}

        return true;
    }

}
