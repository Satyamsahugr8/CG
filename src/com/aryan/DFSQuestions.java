package com.aryan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSQuestions {
    
    public static void main(String[] args) {
        
        DFSQuestions dfsQuestions = new DFSQuestions();

        // // question input
        // int[][] board = {
        //     {-1,-1,-1,-1,-1,-1},
        //     {-1,-1,-1,-1,-1,-1},
        //     {-1,-1,-1,-1,-1,-1},
        //     {-1,35,-1,-1,13,-1},
        //     {-1,-1,-1,-1,-1,-1},
        //     {-1,15,-1,-1,-1,-1}
        // };

        // int answer = dfsQuestions.snakesAndLadders(board);
        // System.out.println("Answer: " + answer);

        // int result = dfsQuestions.numIslands(new char[][]{
        //     {'1','1','1','1','0'},
        //     {'1','1','0','1','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','0','0','0'}});
        // System.out.println("Number of islands: " + result);


        // input for shortest bridge
        // int [][] grid = {
        //     {0, 1, 0},
        //     {0, 0, 0},
        //     {0, 0, 1}
        //  };

        // int grid2 [][] = {
        //     {0, 1, 0, 0, 0},
        //     {0, 1, 0, 0, 0},
        //     {0, 1, 0, 0, 0},
        //     {0, 0, 0, 1, 1},
        //     {0, 0, 0, 1, 1}
        // };

        // int grid3 [][] = {
        //     {1, 1, 1, 1, 1},
        //     {1, 0, 0, 0, 1},
        //     {1, 0, 1, 0, 1},
        //     {1, 0, 0, 0, 1},
        //     {1, 1, 1, 1, 1}
        // };

        // int shortestBridgeLength = dfsQuestions.shortestBridge(grid);
        // System.out.println("Shortest bridge length: " + shortestBridgeLength);

        // int shortestBridgeLength2 = dfsQuestions.shortestBridge(grid2);
        // System.out.println("Shortest bridge length 2: " + shortestBridgeLength2);

        // int shortestBridgeLength3 = dfsQuestions.shortestBridge(grid3);
        // System.out.println("Shortest bridge length 3: " + shortestBridgeLength3);

        // is cycle in graph
        // boolean hasCycle = dfsQuestions.isCycle(4, new int[][]{
        //     {0, 1},
        //     {1, 2},
        //     // {2, 0},
        //     {1, 3}
        // });
        // System.out.println("Graph has cycle: " + hasCycle);

        // bipartite graph
        // boolean isBipartite = dfsQuestions.isBipartite(4, 
        //     List.of(
        //         // [0, 1], [0, 3], [1, 2], [2, 3]
        //         List.of(0, 1), // Edges for vertex 0
        //         List.of(0, 3), // Edges for vertex 1
        //         List.of(1, 2), // Edges for vertex 2
        //         List.of(2, 3)  // Edges for vertex 3
        //     )
        // );

        // System.out.println("Graph is bipartite : " + isBipartite);


        // topological sort
        // V = 6,adj=[ [ ], [ ], [3], [1], [0,1], [0,2] ]
        // input for topological sort
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of()); // Edges for vertex 0
        adj.add(List.of()); // Edges for vertex 1
        adj.add(List.of(3)); // Edges for vertex 2
        adj.add(List.of(1)); // Edges for vertex 3
        adj.add(List.of(0, 1)); // Edges for vertex 4
        adj.add(List.of(0, 2)); // Edges for vertex 5

        int [] ans = dfsQuestions.topoSort(V, adj);
        System.out.println("Topological Sort: ");
        for (int i : ans) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Topological Sort (as array): " + Arrays.toString(ans));

        System.out.print("Topological Sort (as stream): ");
        Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }


    public int[] topoSort(int V, List<List<Integer>> adj) {

        // our work to find indegree of each vertex
        int [] indegree = new int[V];
        List<Integer> topoOrder = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (Integer neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        System.out.println("Indegree array: " + Arrays.toString(indegree));

         // queue for bfs
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topoOrder.add(currentVertex); // Add vertex to topological order
            System.out.print(currentVertex + " "); // Print the vertex in topological order

            for (Integer neighbor : adj.get(currentVertex)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean isCyclic(int V, List<List<Integer>> adj) {

        // our work to find indegree of each vertex
        int [] indegree = new int[V];
        List<Integer> topoOrder = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (Integer neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // System.out.println("Indegree array: " + Arrays.toString(indegree));

         // queue for bfs
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topoOrder.add(currentVertex); // Add vertex to topological order
            // System.out.print(currentVertex + " "); // Print the vertex in topological order

            for (Integer neighbor : adj.get(currentVertex)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }

            }
        }

        if ( topoOrder.size() != V ) {
            return true; // Graph has a cycle
        }
        
        return false; // Graph does not have a cycle
    }

    public boolean isBipartite(int V, List<List<Integer>> edges) {

        int[] colors = new int[V];

        List<List<Integer>> adjacencyList = CreateGraph.createGraphFromList(V, edges);
        // System.out.println(adjacencyList);

        return bfsBipartite(V, adjacencyList, colors);
    }

    public boolean bfsBipartite(int V, List<List<Integer>> graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                colors[i] = 1; // Start coloring with color 1
            } else {
                continue;
            }

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                int currentColor = colors[currentVertex];
                // explore its neigbhors
                for (Integer neighbor : graph.get(currentVertex)) {

                    if (visited[neighbor] && colors[neighbor] == currentColor) {
                        return false;
                    }
                    if (visited[neighbor]) {
                        continue;
                    }

                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    colors[neighbor] = currentColor == 1 ? 2 : 1; // Assign opposite color to the neighbor
                }   
            }
        }
        
        return true;
    }



    // public boolean isBipartite(int V, int[][] edges) {
    //     List<List<Integer>> graph = CreateGraph.createGraph(V, edges);
    //     int[] colors = new int[V];
    //     for (int i = 0; i < V; i++) {
    //         if (colors[i] == 0) {
    //             if (!dfsBipartite(graph, colors, i, 1)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // public boolean dfsBipartite(List<List<Integer>> graph, int[] colors, int node, int color) {
    //     colors[node] = color;
    //     for (int neighbor : graph.get(node)) {
    //         if (colors[neighbor] == 0) {
    //             if (!dfsBipartite(graph, colors, neighbor, -color)) {
    //                 return false;
    //             }
    //         } else if (colors[neighbor] == color) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public boolean isCycle(int V, int[][] edges) {
        // Code here

        // Create adjacency list
        List<List<Integer>> graph = CreateGraph.createGraph(V, edges);
        // for (int[] edge : edges) {
        //     graph.get(edge[0]).add(edge[1]);
        //     graph.get(edge[1]).add(edge[0]);
        // }

        // System.out.println("Graph: " + graph);

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(graph, visited, i, -1)) {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean dfsCycle(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCycle(graph, visited, neighbor, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Found a back edge
            }
        }
        return false;
    }


    public int shortestBridge(int[][] grid) {
        
        if (grid == null || grid.length == 0) return -1;
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // Find and mark the first island
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found; j++) {
                if (grid[i][j] == 1) {
                    dfsShortestBridge(grid, i, j, visited);
                    found = true;
                }
            }
        }
        
        // Multi-source BFS from first island
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return level;  // Reached second island
                        }
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        return -1;  // Should not reach here if exactly two islands
    }

    public void dfsShortestBridge(int [][] grid, int i, int j, boolean[][] visitedDfs) {
        
        if ( i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1 || visitedDfs[i][j] ) {
            return;
        }

        // visited mark
        visitedDfs[i][j] = true;
        dfsShortestBridge(grid, i, j + 1, visitedDfs);
        dfsShortestBridge(grid, i + 1, j, visitedDfs);
        dfsShortestBridge(grid, i, j - 1, visitedDfs);
        dfsShortestBridge(grid, i - 1, j, visitedDfs);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char [][] grid, int i, int j) {
        
        if ( i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1' ) {
            return;
        }

        grid[i][j] = '0';
        
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);   
    }

}
