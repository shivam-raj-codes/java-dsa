package com.shivam.graphs.algorithm;

import java.util.ArrayList;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
public class CountSCCUsingKOSARAJsAlgorithm {
    public int kosaraju(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        /// step1: dfs for all node to Sort vertices a/c to finishing time & stores in stack
        // Time: O(V + E) for dfs
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }


        /// step2: Reverse  the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        // Time: O(V + E) for list
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }


        for (int i = 0; i < V; i++) {
            vis[i] = false; /// to reuse same vis[] array in step: 3 everything marks as unvisited
            // traverse for all the adj. node for this particular node
            for (int it : adj.get(i)) {
                // for i the adjNode is it => edge from i -> it.
                // reverse is: it -> i

                adjT.get(it).add(i);
            }
        }

        /// step3: perform dfs but on order of finishing time.
        // Time: O(V + E) for dfs
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            if (!vis[node]) {
                scc++; /// no. of scc increased.
                dfs3(node, vis, adjT);
            }
        }

        return scc; /// ans
    }


    public void dfs(int node , boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;  /// mark as visited

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    /// step3: dfs
    private void dfs3 (int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true; /// mark as visited
        for (int it : adjT.get(node)) {
            if (!vis[it]) {
                dfs3(it, vis, adjT);
            }
        }
    }
}

// Time: O(3(V + E))
// Space: O(2 x V) for vis[] & stack + O(V + E) for list.
