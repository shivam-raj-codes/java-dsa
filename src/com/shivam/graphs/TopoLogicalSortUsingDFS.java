package com.shivam.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopoLogicalSortUsingDFS {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // build adjacency List
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
           ans.add(stack.peek());
           stack.pop();
        }
        return ans;
    }

    private void dfs(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, visited, st, adj);
            }
        }

        ///  when do not have further dfs - call
        // put node into stack while going back
        st.push(node);
    }
}
