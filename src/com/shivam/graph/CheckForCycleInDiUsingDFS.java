package com.shivam.graph;

import java.util.ArrayList;
public class CheckForCycleInDiUsingDFS {
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[]  vis = new boolean[v];

        // return dfs(1, -1, vis, adj); // only for single graph
        
        ///  for connected component
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj)) { /// dfs(i, -1, vis, adj) -> return ture
                    return true; /// Cycle
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int adjacentNode : adj.get(node)) {
            if (!visited[adjacentNode]) {
                ///  go for dfs on neighbour, parent as -> node
                if (dfs(adjacentNode, node, visited, adj)){ // dfs(adjacentNode, node, visited, adj) => if this returns true
                    return true; // => Cycle
                }

                // already visited but not came from parent
                else if (adjacentNode != parent) {
                    return true;   /// its repeated node in the path => cycle
                }
            }
        }
        return false;
    }
}

// Space : O(N)
// Time: O(N + 2*E) + O(number of total connected component).
