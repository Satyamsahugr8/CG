package com.pepcoding.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // Test the orangesRotting method
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        Solution solution = new Solution();
        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until all oranges rot: " + result);

    }


    public int orangesRotting(int[][] grid) {

        boolean [][] visited = new boolean[grid.length][grid[0].length];
        Queue<int []> queueStore = new LinkedList<>();
        int count = 0;
        int countOne = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countOne++;
                } else if (grid[i][j] == 2) {
                    queueStore.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        System.out.println("Initial count of fresh oranges: " + countOne);
        System.out.println("Initial queue: " + queueStore.toString());
        count = orangesRotting(grid, visited, countOne, queueStore);
        return count;
    }

    public int orangesRotting(int[][] grid, boolean[][] visited, int countOne, Queue<int []> queueStore) {

        int countMinute = 0;
        int directions [][] = {{0, 1},{1, 0},{0, -1},{-1, 0}};

        while (!queueStore.isEmpty()) {

            int size = queueStore.size();
            
            for (int i = 0; i < size; i++) {
                
                int[] node = queueStore.poll();
                int x = node[0];
                int y = node[1];

                System.out.println("Processing rotten orange at: (" + x + ", " + y + ")");

                for (int[] dir : directions) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if ( newx >= 0 && newy >= 0 && newx < grid.length && newy < grid[0].length 
                            && !visited[newx][newy] 
                            && grid[newx][newy] == 1 ) {
                        visited[newx][newy] = true;
                        queueStore.offer(new int[]{newx, newy});
                        countOne--;
                        System.out.println("Rotting orange at: (" + newx + ", " + newy + "), remaining fresh oranges: " + countOne);
                    }
                }

                System.out.println("Count of fresh oranges remaining: " + countOne);  
            }
            countMinute++;
        }

        if (countOne > 0) {
            return -1;
        }

        return countMinute - 1;
    }



    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();
            result.add(node);

            for(int neighbour : adj.get(node)) {
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        dfs(0, adj, visited, result);

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {

        visited[node] = true;
        result.add(node);

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, result);
            }
        }
    }

}
