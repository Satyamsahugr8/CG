package com.aryan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.codingninjas.stack.Pairr;

public class BFSQuestions {

    public static void main(String[] args) {
        
            BFSQuestions bfsQuestions = new BFSQuestions();
            
            // // question input
            // int[][] board = {
            //     {-1,-1,-1,-1,-1,-1},
            //     {-1,-1,-1,-1,-1,-1},
            //     {-1,-1,-1,-1,-1,-1},
            //     {-1,35,-1,-1,13,-1},
            //     {-1,-1,-1,-1,-1,-1},
            //     {-1,15,-1,-1,-1,-1}
            // };

            // int answer = bfsQuestions.snakesAndLadders(board);
            // System.out.println("Answer: " + answer);

            // shortestPathBinaryMatrix
            // int[][] grid = {
            //     {0, 1},
            //     {1, 0}
            // };
            // int answer = bfsQuestions.shortestPathBinaryMatrix(grid);
            // System.out.println("Answer: " + answer);

            // rottenOrange input
            // int [][] grid = {
            //     {2,1,1},
            //     {0,1,0},
            //     {0,0,2}
            // };
            // int [][] grid2 = {
            //     {2, 1, 1},
            //     {0, 1, 1},
            //     {1, 0, 1}
            // };

            // int grid3[][] = {{2,1,1}, {0,1,1}, {1,0,1}};

            // int answer = bfsQuestions.orangesRotting(grid3);
            // System.out.println("Answer: " + answer);


            // input for max distance
            // int [][] grid = {
            //     {1, 0, 1},
            //     {0, 0, 0},
            //     {1, 0, 1}
            // };
            // int answer = bfsQuestions.maxDistance(grid);
            // System.out.println("Answer: " + answer);

            // highestPeak
            // int [][] isWater = {
            //     {1, 0, 1},
            //     {0, 0, 0},
            //     {1, 0, 1}
            // };
            // int [][] answer = bfsQuestions.highestPeak(isWater);
            // System.out.println("Answer: " + Arrays.deepToString(answer));


            // input for shortest path
            // int [][] grid = {
            //     {0, 0, 0},
            //     {1, 1, 0},
            //     {0, 0, 0},
            //     {1, 1, 1},
            //     {0, 0, 0}
            // };

            // [[0,0,0,0,0,0,0,0,0,0],[0,1,1,1,1,1,1,1,1,0],[0,1,0,0,0,0,0,0,0,0],[0,1,0,1,1,1,1,1,1,1],[0,1,0,0,0,0,0,0,0,0],[0,1,1,1,1,1,1,1,1,0],[0,1,0,0,0,0,0,0,0,0],[0,1,0,1,1,1,1,1,1,1],[0,1,0,1,1,1,1,0,0,0],[0,1,0,0,0,0,0,0,1,0],[0,1,1,1,1,1,1,0,1,0],[0,0,0,0,0,0,0,0,1,0]]
            // int [][] grid = {
            //     {0,0,0,0,0,0,0,0,0,0},
            //     {0,1,1,1,1,1,1,1,1,0},
            //     {0,1,0,0,0,0,0,0,0,0},
            //     {0,1,0,1,1,1,1,1,1,1},
            //     {0,1,0,0,0,0,0,0,0,0},
            //     {0,1,1,1,1,1,1,1,1,0},
            //     {0,1,0,0,0,0,0,0,0,0},
            //     {0,1,0,1,1,1,1,1,1,1},
            //     {0,1,0,1,1,1,1,0,0,0},
            //     {0,1,0,0,0,0,0,0,1,0},
            //     {0,1,1,1,1,1,1,0,1,0},
            //     {0,0,0,0,0,0,0,0,1,0}
            // };

            // int k = 1;
            // int answer = bfsQuestions.shortestPath(grid, k);
            // System.out.println("Answer: " + answer);

            // input for shortest path all keys
            // String[] grid = {
            //     "@.a.#",
            //     "###.#",
            //     "b.A.B"
            // };

            // grid = ["@..aA","..B#.","....b"]
            // String[] grid = {
            //     "@..aA",
            //     "..B#.",
            //     "....b"
            // };


            // ["@...a",".###A","b.BCc"]
            String[] grid = {
                "@...a",
                ".###A",
                "b.BCc"
            };

            int answer = bfsQuestions.shortestPathAllKeys(grid);
            System.out.println("Answer: " + answer);

    }

    public int shortestPathAllKeys(String[] grid) {

        if ( grid == null || grid.length == 0 ) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length();
        int step = 0;
        int totalKeys = 0;

        // boolean [][] visited = new boolean[n][m];

        ArrayList<Character> keys = new ArrayList<>();

        Map<Character, Character> keyToIndex = new HashMap<>();
        keyToIndex.put('A', 'a');
        keyToIndex.put('B', 'b');
        keyToIndex.put('C', 'c');
        keyToIndex.put('D', 'd');
        keyToIndex.put('E', 'e');
        keyToIndex.put('F', 'f');

        Queue<int []> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if ( grid[i].charAt(j) == '@' ) {
                    // start bfs from here
                    queue.offer(new int[]{i, j}); // row, col
                    String state = i + "," + j + "," + keys.toString();
                    visited.add(state);
                }

                if ( grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f' ) {
                    totalKeys++;
                }
            }    
        }

        while ( !queue.isEmpty() ) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                // int keys = cell[2];

                // check for 4 directions
                int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

                for (int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m ) {
                        
                        Character nextCell = grid[newRow].charAt(newCol);

                        if ( nextCell == '#' ) {
                            continue;
                        }

                        // Lock cell
                        if ( nextCell >= 'A' && nextCell <= 'F' ) {
                            Character requiredKey = keyToIndex.get(nextCell);
                            if ( !keys.contains(requiredKey) ) {
                                continue;
                            }
                        }

                        // key cell
                        if ( nextCell >= 'a' && nextCell <= 'f' ) {
                            if ( !keys.contains(nextCell) ) {
                                keys.add(nextCell);
                                totalKeys--;
                            }
                        }

                        String state = newRow + "," + newCol + "," + keys.toString();
                        
                        if ( visited.contains(state) ) {
                            continue;
                        } else {
                            visited.add(state);
                        }

                        if ( totalKeys == 0 ) {
                            return step + 1;
                        }

                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            step++;
        }
        
        return -1;
    }

    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        if ( grid == null || grid.length == 0 || grid[0].length == 0 ) {
            return -1;
        }

        if ( n == 1 && m == 1 ) {
            return 0;
        }

        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, k}); // row, col, remaining

        int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][k] = true;

        while ( !queue.isEmpty() ) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                int remaining = cell[2];

                for (int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol][remaining] ) {
                        
                        if ( grid[newRow][newCol] == 1 && remaining > 0 ) {
                            visited[newRow][newCol][remaining] = true;
                            queue.offer(new int[]{newRow, newCol, remaining - 1});
                        } else if ( grid[newRow][newCol] == 0 ) {
                            visited[newRow][newCol][remaining] = true;
                            queue.offer(new int[]{newRow, newCol, remaining});
                        }

                        if ( newRow == n - 1 && newCol == m - 1 ) {
                            return distance + 1;
                        }
                    }
                }
            }

            distance++;
        }
 
        return -1;
    }

    public int[][] highestPeak(int[][] isWater) {
        
        int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        int[][] result = new int[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int n = isWater.length;
        int m = isWater[0].length;

        // iterate over grid and add water cells to queue and for land cell mark as -1 in result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }

        // queue bfs iteration
        while ( !queue.isEmpty() ) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int [] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && result[newRow][newCol] == -1 ) {
                        result[newRow][newCol] = result[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }

            }
        }

        return result;
    }

    public int maxDistance(int[][] grid) {

        if (grid == null || grid.length == 0 ) {
            return -1;
        }

        Queue<int []> queue = new LinkedList<>();
        int [][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;
        int freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if ( grid[i][j] == 1 ) {
                    queue.offer(new int[]{i, j});
                }
                if ( grid[i][j] == 0 ) {
                    freshOranges++;
                }
            }
        }

        // queue bfs iteration
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] rottenCell = queue.poll();
                int row = rottenCell[0];
                int col = rottenCell[1];

                // check for 4 directions if have fresh oranges 
                for (int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 0 ) {
                        grid[newRow][newCol] = 1;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }

            minutes++;
        }

        return freshOranges == 0 ? minutes - 1 : -1;
    }

    public int orangesRotting(int[][] grid) {

        // ✅ Core Logic Flow:

        // Count initial fresh oranges
        // Add all rotten oranges to queue
        // BFS: spread rotting from rotten oranges to adjacent fresh ones
        // Return minutes if all rotted, else -1

        // if size of grid is 1 and 1 
        if (grid == null || grid.length == 0 ) {
            return -1;
        }

        // // lets take size is 1 and 1 then check for 0 1 2 
        // if (grid.length == 1 && grid[0].length == 1 ) {
            
        //     if ( grid[0][0] == 0 ) {
        //         return 0;
        //     } else if ( grid[0][0] == 1 ) {
        //         return -1;
        //     } else if ( grid[0][0] == 2 ) {
        //         return 0;
        //     }
        // }

        // iterate over grid and add rotten oranges to queue and 
        // for fresh orange check for 4 direction and if we found 0 0 0 0 then return -1;
        Queue<int []> queue = new LinkedList<>();
        int [][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if ( grid[i][j] == 2 ) {
                    queue.offer(new int[]{i, j});
                }
                if ( grid[i][j] == 1 ) {
                    freshOranges++;
                }
            }
        }

        // queue bfs iteration
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] rottenCell = queue.poll();
                int row = rottenCell[0];
                int col = rottenCell[1];

                // check for 4 directions if have fresh oranges 
                for (int[] dir : directions) {
                    
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1 ) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }

            minutes++;

        }

        return freshOranges == 0 ? minutes - 1 : -1;
    }

    public int orangesRottingHelper(int[][] grid) {
        return 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        if (rows == 1 && cols == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1; // mark start visited

        int distance = 1;
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    if (nrow < 0 || nrow >= rows || ncol < 0 || ncol >= cols || grid[nrow][ncol] == 1) {
                        continue;
                    }

                    if (nrow == rows - 1 && ncol == cols - 1) {
                        return distance + 1;
                    }

                    queue.add(new int[]{nrow, ncol});
                    grid[nrow][ncol] = 1;
                }
            }

            distance++;
        }

        return -1;
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        List<Pairr<Integer, Integer>> cells = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            column.add(i);
        }

        cells.add(new Pairr<Integer,Integer>(0, 0));
        // column [0, 1, 2, 3, 4, 5]
        for (int i = board.length - 1; i >= 0; i--) {
            for (Integer j : column) {
                cells.add(new Pairr<>(i, j));
            }
            // column [5, 4, 3, 2, 1, 0]
            Collections.reverse(column);
        }
        
        int[] distance = new int[(n * n) + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            
            int curr = queue.poll(); // 1

            for (int inext = curr + 1; inext <= Math.min(curr + 6, n*n); inext++) {
                
                // inext = 2, 3, 4, 5, 6, 7
                Pairr<Integer, Integer> cell = cells.get(inext);
                Integer row = cell.getF();
                Integer col = cell.getS();
                int destination = board[row][col] != -1 ? board[row][col] : inext;

                // if ( distance[destination] == -1 ) {
                //     distance[destination] = distance[curr] + 1;
                //     queue.add(destination);
                // }

                if ( destination >= 1 && destination <= n*n && distance[destination] == -1 ) {
                    distance[destination] = distance[curr] + 1;
                    queue.add(destination);
                }

            }
        }

        return distance[n*n] == -1 ? -1 : distance[n*n];
    }
    
}
