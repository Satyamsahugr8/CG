package com.tufplus.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.common.Q;
import com.tufplus.graphs.Traversal.Pair;

public class Traversal {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Traversal traversal = new Traversal();

        // // Adjacency-list input
        // List<Integer> result = traversal.dfsOfGraph(4, List.of(List.of(1, 2),
        // List.of(0, 3), List.of(0), List.of(1)));
        // System.out.println("DFS (adj): " + result);

        // List<Integer> bfsResult = traversal.bfsOfGraph(4, List.of(List.of(1, 2),
        // List.of(0, 3), List.of(0), List.of(1)));
        // System.out.println("BFS (adj): " + bfsResult);

        // // Edge-list input for the same graph: 0-1, 0-2, 1-3
        // List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(1,
        // 3));
        // System.out.println("DFS (edges): " + traversal.dfsOfGraphFromEdges(4, edges,
        // false));
        // System.out.println("BFS (edges): " + traversal.bfsOfGraphFromEdges(4, edges,
        // false));

        // int component = traversal.findNumberOfComponent(5, List.of(List.of(0, 1),
        // List.of(1, 2), List.of(3, 4)));
        // [[0, 1], [1, 2], [2, 3], [4, 5]]
        // int component = traversal.findNumberOfComponent(6, List.of(List.of(0, 1),
        // List.of(1, 2), List.of(2, 3), List.of(4, 5)));
        // System.out.println("Number of components: " + component);

        // Flood fill algorithm

        // int[][] image = {
        // {1, 1, 1},
        // {1, 1, 0},
        // {1, 0, 1}
        // };
        // int sr = 1, sc = 1;
        // int newColor = 2;

        // int ans [][] = traversal.floodFill(image, sr, sc, newColor);

        // for (int[] is : ans) {
        // for (int i : is) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // }

        // numberOfEnclaves

        // int[][] grid = {
        // {0, 0, 0, 0},
        // {1, 0, 1, 0},
        // {0, 1, 1, 0},
        // {0, 0, 0, 0}
        // };

        // input [[0, 0, 0, 1],[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]]
        // int [][] grid = {
        // {0, 0, 0, 1},
        // {0, 0, 0, 0},
        // {0, 1, 1, 1},
        // {0, 0, 1, 1},
        // {0, 0, 1, 0}
        // };

        // int enclaves = traversal.numberOfEnclaves(grid);
        // System.out.println("Number of enclaves: " + enclaves);

        // orangesRotting
        // Input: grid = [ [2, 1, 1] , [0, 1, 1] , [1, 0, 1] ]

        // int[][] grid = {
        //         { 2, 1, 1 },
        //         { 0, 1, 1 },
        //         { 1, 0, 1 }
        // };

        // int minutes = traversal.orangesRotting(grid);
        // System.out.println("Minutes until all oranges rot: " + minutes);

        // nearest 01 matrix
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },    
                { 0, 0, 1, 1 }
        };

        int[][] nearest = traversal.nearest(grid);

        System.out.println("Nearest 01 Matrix:");

        for (int[] is : nearest) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }

    }




    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        return new int[0]; // Placeholder return, replace with actual implementation
    }


    public int[][] nearest2(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;

        int [][] newGrid = grid;

        // collect all the 1s in the grid and add them to the queue
        Queue<int []> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // Perform BFS from all the 1s simultaneously
        while (!queue.isEmpty()) {

            int size = queue.size();
            int count = 0;

            for (int i = 0; i < size; i++) {
                count++;
                
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                int currentValue = grid[row][col];

                if ( count == 1 ) {
                    newGrid[row][col] = 0;
                }

                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if ( newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                        && grid[newRow][newCol] == 0 ) {
                        
                        queue.add(new int[]{newRow, newCol});
                        
                        if ( count == 1 ) {
                            newGrid[newRow][newCol] = 0;
                        } else {
                            newGrid[newRow][newCol] = count;
                        }

                        grid[newRow][newCol] = 1;
                    }
                }
            }
        }

        return newGrid; // Placeholder return, replace with actual implementation

    }


    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // enqueue all source cells with value 1 and set their distance to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    result[newRow][newCol] = result[row][col] + 1;
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }

        return result;
    }

    class Pair<T, U> {
        T i;
        U j;

        Pair(T i, U j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<Pair<Integer, Integer>> store1 = new ArrayList<>();
        Queue<Pair<Integer, Integer>> queueStore2 = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    store1.add(new Pair<>(i, j));
                } else if (grid[i][j] == 2) {
                    queueStore2.add(new Pair<>(i, j));
                }
            }
        }

        count += orangesRotting2(grid, visited, store1, queueStore2);

        for (Pair<Integer, Integer> pair : store1) {
            if (!visited[pair.i][pair.j]) {
                return -1; // If there's still a fresh orange that hasn't been visited, return -1
            }
        }

        return count;
    }

    public int orangesRotting2(int[][] grid, boolean[][] visited,
            ArrayList<Pair<Integer, Integer>> store1, Queue<Pair<Integer, Integer>> queueStore2) {
        int time = 0;

        while (!queueStore2.isEmpty()) {
            int currentSize = queueStore2.size();
            boolean hasRotten = false;

            for (int i = 0; i < currentSize; i++) {
                Pair<Integer, Integer> cell = queueStore2.poll();
                int row = cell.i;
                int col = cell.j;
                visited[row][col] = true;

                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                            grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {

                        queueStore2.add(new Pair<>(newRow, newCol));
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2; // Mark as rotten
                        hasRotten = true;
                    }
                }
            }

            if (hasRotten) {
                time++;
            }
        }

        return time;
    }

    public boolean isBoundary(int i, int j, int[][] grid) {
        if (i == 0 || j == 0 || i == (grid.length - 1) || j == (grid[0].length - 1))
            return true;
        return false;
    }

    public int numberOfEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    count += numberOfEnclaves2(grid, visited, i, j);
                }

            }
        }

        return count;
    }

    public int numberOfEnclaves2(int[][] grid, boolean[][] visited, int i, int j) {

        int count = 0;
        boolean isEnclave = true; // Assume valid until proven otherwise

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i, j));
        visited[i][j] = true;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.poll();
            int row = cell.i;
            int col = cell.j;

            count++; // Count the current land cell
            if (isBoundary(row, col, grid)) {
                isEnclave = false; // Mark as invalid if we reach the boundary
            }

            // Why it fails
            // If the component contains a boundary cell, the whole component should be
            // invalidated.
            // Your code resets count only when a boundary cell is encountered, but then
            // continues BFS.
            // Later internal cells in the same component can still increment count again.
            // So a component with boundary cells can still return a positive count, which
            // is incorrect
            // if (!isBoundary(row, col, grid)) {
            // count++;
            // } else {
            // count = 0; // Reset count if we reach the boundary
            // }

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {

                    queue.add(new Pair<>(newRow, newCol));
                    visited[newRow][newCol] = true;
                }

            }
        }

        return isEnclave ? count : 0; // Return count if it's an enclave, otherwise return 0
    }

    private boolean isValid(int i, int j, int n, int m) {
        // Return false if pixel is invalid
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;

        // Return true if pixel is valid
        return true;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // given
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(sr, sc));

        int oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return image;
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int i = current.i;
            int j = current.j;

            if (isValid(i, j, image.length, image[0].length) && image[i][j] == oldColor) {
                image[i][j] = newColor;
            } else {
                continue;
            }

            queue.add(new Pair<Integer, Integer>(i + 1, j));
            queue.add(new Pair<Integer, Integer>(i - 1, j));
            queue.add(new Pair<Integer, Integer>(i, j + 1));
            queue.add(new Pair<Integer, Integer>(i, j - 1));
        }

        return image;
    }

    // input is number of vertices and adjacency list
    // Example: V = 4, adj = [[1,2],[0,3],[0],[1]]
    // visualization of the graph:
    // 0 -- 1
    // | |
    // 2 3

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean visited[] = new boolean[V];
        return dfsOfGraphHelper(V, adj, 0, visited, new ArrayList<>());
    }

    public List<Integer> dfsOfGraphHelper(int V, List<List<Integer>> adj, int node, boolean visited[],
            List<Integer> result) {

        visited[node] = true;
        result.add(node);

        // explore neighbors of the current node
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsOfGraphHelper(V, adj, neighbor, visited, result);
            }
        }

        return result;
    }

    // bfs traversal of a graph
    // input is number of vertices and adjacency list
    // Example: V = 4, adj = [[1,2],[0,3],[0],[1]]
    // visualization of the graph:
    // 0 -- 1
    // | |
    // 2 3
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean visited[] = new boolean[V];
        return bfsOfGraphHelper(V, adj, 0, visited, new ArrayList<>());
    }

    public List<Integer> bfsOfGraphHelper(int V, List<List<Integer>> adj, int node, boolean visited[],
            List<Integer> result) {

        // BFS uses a queue to explore neighbors level by level
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            result.add(currentNode);

            // explore neighbors of the current node
            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    // DFS traversal when input is edge list: [[u,v], ...]
    // If directed = false, each edge is treated as undirected.
    public List<Integer> dfsOfGraphFromEdges(int V, List<List<Integer>> edges, boolean directed) {
        List<List<Integer>> adj = buildAdjListFromEdges(V, edges, directed);
        return dfsOfGraph(V, adj);
    }

    // BFS traversal when input is edge list: [[u,v], ...]
    // If directed = false, each edge is treated as undirected.
    public List<Integer> bfsOfGraphFromEdges(int V, List<List<Integer>> edges, boolean directed) {
        List<List<Integer>> adj = buildAdjListFromEdges(V, edges, directed);
        return bfsOfGraph(V, adj);
    }

    // Converts edge list into adjacency list for traversal.
    public List<List<Integer>> buildAdjListFromEdges(int V, List<List<Integer>> edges, boolean directed) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            if (edge.size() < 2) {
                continue;
            }

            int u = edge.get(0);
            int v = edge.get(1);

            if (u < 0 || u >= V || v < 0 || v >= V) {
                continue;
            }

            adj.get(u).add(v);
            if (!directed) {
                adj.get(v).add(u);
            }
        }

        return adj;
    }

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

        int E = edges.size();

        // To store adjacency list
        List<List<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // [[0,1],[1,2]]
        // Add edges to adjacency list
        for (int i = 0; i < E; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            if (u < 0 || u >= V || v < 0 || v >= V) {
                continue;
            }

            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }

        System.out.println("Adjacency List: " + adjLs);

        // Visited array
        boolean[] vis = new boolean[V];

        // Variable to store number of components
        int cnt = 0;

        // Start Traversal
        for (int i = 0; i < V; i++) {
            // If the node is not visited
            if (!vis[i]) {
                // Increment counter
                cnt++;

                // Start traversal from current
                // node using any traversal
                bfsOfGraph(i, adjLs, vis);
                // dfs(i, adjLs, vis);
            }
        }

        // Return the count
        return cnt;
    }

    public List<Integer> bfsOfGraph(int i, List<List<Integer>> adj, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            result.add(node);

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return result;
    }

}
