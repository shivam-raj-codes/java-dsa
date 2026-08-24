package com.shivam.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphUsingDFS {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        /// for components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col; /// color node with given color

        // for adjacency - node
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                ///  not color => dfs() & can might return false
                if (!dfs(it, 1 - col, color, adj)) {
                    return false;
                }
            }
            else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }
}

// Space: O(V) -> color Array
// Time: O(V + 2E)
