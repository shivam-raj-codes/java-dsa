package com.shivam.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirGrUsingTopologicalSort {
    public boolean isCyclic(int V, int[][] edges) {
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

        ///  in - Degree
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            /// all vertex with inDeg = 0 : put in Queue
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            cnt++;
            /// node is in your topo-Sort
            /// so, please remove it from the inDegree[]
            for (int it: adj.get(node)) {
                inDegree[it]--; /// remove from inDegree[].
                if (inDegree[it] == 0) {
                    /// after removing, the inDegree of 'it' becomes-> 0
                    /// => have one more ele to put in topoSort
                    q.offer(it);
                }
            }
        }

        return cnt != V; /// count != No. of Vertices => Cycle exist.
    }
}
