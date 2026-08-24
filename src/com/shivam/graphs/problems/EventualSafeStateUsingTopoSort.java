package com.shivam.graphs.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EventualSafeStateUsingTopoSort {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        /// Original adjacency list
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

        /// Reverse adjacency list
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        /// Create V empty lists
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] inDegree = new int[V];

        /// Reverse the Graph
        for (int i = 0; i < V; i++) {
            // i -> it in original graph
            for (int it : adj.get(i)) {
                // Reverse edge:
                // i -> it
                // becomes // it -> i
                adjRev.get(it).add(i);

                // In reversed graph, this represents
                // the outgoing edge count of i
                inDegree[i]++;
            }
        }


        ArrayList<Integer> safeNodelist = new ArrayList<>(); /// Ans

        Queue<Integer> q = new LinkedList<>();
        // figureOut terminal Node
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                ///  put in Q
                q.offer(i);
            }
        }

        /// Topo Sort
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            // whoever is coming out from Queue is will have inDeg = 0 => is Safe Node.
            safeNodelist.add(node); /// safe - Node

            // traverse on adjacency - node
            for (int it : adjRev.get(node)) {
                inDegree[it] -= 1; /// indegree of adj - node reduce
                if (inDegree[it] == 0) {
                    /// push in Q
                    q.offer(it);
                }
            }
        }

        Collections.sort(safeNodelist);
        return safeNodelist;
    }
}
