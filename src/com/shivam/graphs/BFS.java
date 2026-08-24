package com.shivam.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static ArrayList<Integer> bfsOfGraph(int start, int vertices, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean[] visited = new boolean[vertices + 1]; // visited array

        Queue<Integer> q = new LinkedList<>();


        q.add(start);  /// Add starting node to queue
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            bfs.add(node); // ans

            // get all the adjacent vertices of the 'node'

            for (int neighbour : adj.get(node)) { // will iterate on each adjacent node of 'node'

                // visited[i] == false
                if (!visited[neighbour]) {
                    q.add(neighbour);      // if it is not visited add in Queue &
                    visited[neighbour] = true;  // mark as -> visited => true
                }
            }
        }
        return bfs;
    }




    // Main - fn
    public static void main(String[] args) {
        int vertices = 9;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        /// For 1-based indexing:
        /// create n+1 lists because index 0 will remain unused
        for (int i = 0; i <= vertices; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 4, 5);
        addEdge(adj, 7, 5);

        System.out.println("Graph: Vertices");
        for (int i = 1; i <= vertices; i++) {

            System.out.print(i + " -> ");

            // Traverse neighbours of current vertex
            for (int node : adj.get(i)) {
                System.out.print(node + " ");
            }

            System.out.println();
        }


        System.out.println("BFS Traversal: ");
        System.out.println(bfsOfGraph(6, vertices, adj));
    }
}

// for Undirected - Graph: --->
// Time Complexity: O(V + 2E)
// Space Complexity: O(V)
