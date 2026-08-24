package com.shivam.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DirectedGraph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }


    public static ArrayList<Integer> bfsOfDirectedG(int start, int vertices, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs_Result = new ArrayList<>();
        boolean[] visited = new boolean[vertices + 1];

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;


        while (!q.isEmpty()) {
            int node = q.poll();

            bfs_Result.add(node); /// ans

            // for all neighbours
            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {
                    q.add(neighbour); // add into Queue
                    visited[neighbour] = true; // marks as -> true
                }

            }
        }
        return bfs_Result;
    }



    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // 1 - base indexing
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>()); // internal arraylist=> contains all the neighbours.
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 6);
        addEdge(adj, 5, 7);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 8);


        System.out.println("Adjacency List: ");
        for (int i = 1; i < n + 1; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        System.out.println("\nBFS Traversal On Directed Graph: ");
        System.out.println(bfsOfDirectedG(1, n, adj));
    }
}
