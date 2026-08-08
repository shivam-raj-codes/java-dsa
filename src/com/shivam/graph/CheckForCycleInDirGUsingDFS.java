package com.shivam.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckForCycleInDirGUsingDFS {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ///  create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        /// add edges
        /// Traverse each row (each row is one edge)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }


        int[] visited = new int[V];
        Arrays.fill(visited, 0);
        int[] pathVis = new int[V];
        Arrays.fill(pathVis, 0);

        /// components
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) { /// not visited
                if (dfsCheck(i, adj, visited, pathVis)) { ///  give True => Cycle
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis) {
        visited[node] = 1;
        pathVis[node] = 1;

        /// adj. Node
        for (int it : adj.get(node)) {
            /// when the node is not visited
            if (visited[it] == 0) {  // not visited
                if (dfsCheck(it, adj, visited, pathVis)) { ///  if it gets true -> finds Cycle
                    return true;
                }
            }
            /// if the node has been previously visited
            ///  but, it has to be visited on Same path
            else if (visited[it] == 1 && pathVis[it] == 1) { // already visited & in same path
                return true;
            }
        }
        /// while returning -> backtrack
        pathVis[node] = 0;
        return false;
    }
}

// Time: O(V + E).
// Space: O(2N).

