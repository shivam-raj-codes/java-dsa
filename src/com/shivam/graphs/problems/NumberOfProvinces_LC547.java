package com.shivam.graphs.problems;

import java.util.ArrayList;

public class NumberOfProvinces_LC547 {

    public static int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        /// 2D-Matrix -> List
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {

                // (i != j)
                // Avoid self-loop: a node is always connected to itself in the matrix
                // Example: isConnected[0][0] = 1 means node 0 is connected to itself.
                // We don't add this because graph traversal does not need self-connections.
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j); // create adjacency List from given Matrix.

                    /// adj.get(j).add(i);
                    // Not needed because adjacency matrix already contains both directions
                    // for an undirected graph.
                }
            }
        }

        /// to Check is it 0 or 1 base - indexing?
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        // 0 - base indexing
        ///  visited Array
        boolean[] visited = new boolean[vertices];


        int provinces = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, visited, adj); // Starting DFS from an unvisited node means we found a new provinces.
            }
        }

        return provinces;
    }


    /// dfs -> work is to just reach out all the connected-vertices
    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, visited, adj);
            }
        }

    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0}, {1,1,0}, {0,0,1}
        };

        System.out.println("Total No. of Provinces: " + findCircleNum(isConnected));

    }
}


// Time -> O(N) + O(vertices + 2*Edge)

// space: -> O(N) - visited[] + O(N) - recursion-stack ~ O(N)

