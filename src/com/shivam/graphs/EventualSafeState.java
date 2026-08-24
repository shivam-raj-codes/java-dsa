package com.shivam.graphs;

import java.util.ArrayList;

public class EventualSafeState {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
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


        boolean[] visited = new boolean[V];
        boolean[] pathVis = new boolean[V];
        int[] check = new int[V]; /// safe node marked

        /// components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { /// not visited
                dfsCheck(i, adj, visited, check, pathVis);
            }
        }

        ArrayList<Integer> safeNodelist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                /// is Safe & add in List
                safeNodelist.add(i);
            }
        }

        return safeNodelist;
    }


    /// dfs
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] check, boolean[] pathVis) {
        visited[node] = true;
        pathVis[node] = true;
        check[node] = 0;    /// entered for this guy say it as 0

        /// adj. Node
        for (int it : adj.get(node)) {
            /// when the node is not visited
            if (!visited[it]) {  // not visited
                if (dfsCheck(it, adj, visited, check, pathVis)) { ///  if it gets true -> finds Cycle
                    /// if is Cycle => Can't be Safe Node
                    check[node] = 0;
                    return true;
                }
            }
            /// if the node has been previously visited
            ///  but, it has to be visited on Same path
            else if (visited[it] && pathVis[it]) { // already visited & in same path
                /// if it is Cycle => Can't be Safe Node
                check[node] = 0;
                return true;
            }
        }

        check[node] = 1; /// yes it is Safe node.

        /// while returning -> backtrack
        pathVis[node] = false;
        return false;
    }
}

// Space: O(3N).

// Adjacency List Creation : O(E)
// DFS Traversal          : O(V + E)
// Collect Safe Nodes     : O(V)
// Time: O(V + E)
