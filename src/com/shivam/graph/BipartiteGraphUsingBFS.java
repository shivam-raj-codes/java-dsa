package com.shivam.graph;

import java.util.*;

/// colors components
public class BipartiteGraphUsingBFS {
    public boolean isBipartite(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        /// Create V empty lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        /// Build adjacency list
        for (int[] edge : edges) {
            // edge = {0, 1} first iteration
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        /// check for components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!(check(i, V, adj, color))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check (int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        color[start] = 0; /// 0th guy with initial color -> 0
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                /// if adjacent node is yet not color
                /// will give the opposite color of the node
                if (color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.offer(it); /// push the colored one

                }
                ///  is the adjacent guy having same color
                /// someone did color it on some other path
                else if (color[it] == color[node]) {

                    /// not Bipartite
                    return false;

                }
            }
        }
        return true; /// it is Bipartite - Graph
    }
}

// Time: O(V + E)
// space: O(V + E)
