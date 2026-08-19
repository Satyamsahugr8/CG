package com.tufplus.graphs.hardproblems;

import java.util.*;

public class EventualSafeNodes {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] onPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, visited, onPath, i)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isSafe(int[][] graph, boolean[] visited, boolean[] onPath, int node) {
        if (visited[node]) {
            return !onPath[node]; // If already visited, check if it's on the current path
        }

        visited[node] = true;
        onPath[node] = true;

        for (int neighbor : graph[node]) {
            if (!isSafe(graph, visited, onPath, neighbor)) {
                return false; // If any neighbor is not safe, this node is not safe
            }
        }

        onPath[node] = false; // Backtrack
        return true; // This node is safe
    }

}