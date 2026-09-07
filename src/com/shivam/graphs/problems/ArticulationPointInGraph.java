package com.shivam.graphs.problems;
import java.util.ArrayList;

// https://takeuforward.org/plus/dsa/problems/articulation-point-in-graph

public class ArticulationPointInGraph {
    int timer = 0;

    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n]; /// will mark which are articulation points

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i); /// add articulation point in list
            }
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans; /// ans
    }

    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        int child = 0; /// child for starting node

        for (int it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                /// adj. is not visited
                dfs(it, node, vis, tin, low, mark, adj);

                low[node] = Math.min(low[node], low[it]); /// 🌟 if already not visited

                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1; /// articulation pt.
                }

                child++; /// unvisited child
            }
            else {
                /// 🌟 if 'neighbour i.e; it' is already visited
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        /// edge - case: for starting point
        if (parent == -1 && child > 1) {
            // is an articulation point
            mark[node] = 1;
        }

    }
}
