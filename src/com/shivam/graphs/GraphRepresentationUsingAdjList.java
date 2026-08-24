package com.shivam.graphs;

import java.util.ArrayList;

public class GraphRepresentationUsingAdjList {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        int n = 3, m = 3; // n = number of vertices, m = number of edges

        // Adjacency List: each index represents a vertex
        // adj.get(i) stores all neighbours of vertex i
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // For 1-based indexing:
        // create n+1 lists because index 0 will remain unused
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }


        // Undirected edge: 1 --- 2
        // Add 2 in neighbour list of 1
        // Add 1 in neighbour list of 2
        adj.get(1).add(2);
        adj.get(2).add(1);


        // General way for an undirected graph:
        // adj.get(u).add(v);
        // adj.get(v).add(u);


        // For a directed graph:
        // only add one direction
        // adj.get(u).add(v);


        // Undirected edge: 2 --- 3
        adj.get(2).add(3);
        adj.get(3).add(2);


        // Undirected edge: 1 --- 3
        adj.get(1).add(3);
        adj.get(3).add(1);


        // Display adjacency list
        // Format:
        // vertex -> all connected vertices
        //
        // Example:
        // 1 -> 2 3
        // 2 -> 1 3
        // 3 -> 2 1

        for (int i = 1; i <= n; i++) {

            System.out.print(i + " -> ");

            // Traverse neighbours of current vertex
            for (int node : adj.get(i)) {
                System.out.print(node + " ");
            }

            System.out.println();
        }

//        for (int i = 1; i < n; i++) {
//
//            for (int j = 0; j < adj.get(i).size(); j++) {
//
//                System.out.print(adj.get(i).get(j) + " ");
//
//            }
//
//            System.out.println();
//
//        }

    }
}