package com.shivam.graphs.problems;

import java.util.*;
public class BridgeInGraphLC {

    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        timer = 1;   // reset timer for every test case

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        /// graph
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n]; /// timeIn
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges; /// ans
    }

    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1; /// marks as visited
        tin[node] = low[node] = timer;
        timer++;

        /// neighbour
        for (int it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                /// not vis
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                /// node --- it be a bridge?
                if (low[it] > tin[node]) {
                    // can't reach the current - node
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(it);

                    bridges.add(temp);
                }
            }
            else {
                /// visited
                // hey adj. just give me the lowest time
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}
